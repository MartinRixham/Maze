import Test.Hspec        (Spec, describe, it, shouldBe)
import Test.Hspec.Runner (configFastFail, defaultConfig, hspecWith)

-- import Maze (Maze, MazeSquare, solve)
import Maze

main :: IO ()
main = hspecWith defaultConfig {configFastFail = True} specs

specs :: Spec
specs = describe "maze" $ do

    it "degenerate maze" $
      solve (Maze [[]])
      `shouldBe` "\n"

    it "simple maze" $
      solve (Maze ["SE"])
      `shouldBe` "SE\n"

    it "walls" $
      solve (Maze ["SE","##"])
      `shouldBe` "SE\n##\n"

    it "spaces" $
      solve (Maze ["S E"])
      `shouldBe` "SXE\n"

    -- it "bad spaces" $
    --   solve (Maze ["SE# "])
    --   `shouldBe` "SE# \n"

    it "Start is good" $
      isGood (Maze ["SE"]) 0 0
      `shouldBe` True

    it "End is good" $
      isGood (Maze ["ES"]) 0 0
      `shouldBe` True
