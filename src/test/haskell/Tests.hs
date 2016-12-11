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
      solve (Maze [[Start, End]])
      `shouldBe` "SE\n"

    it "walls" $
      solve (Maze [[Start, End, Wall]])
      `shouldBe` "SE#\n"

    it "spaces" $
      solve (Maze [[Start, Space, End]])
      `shouldBe` "SXE\n"

    it "bad spaces" $
      solve (Maze [[Start, End, Wall, Space]])
      `shouldBe` "SE# \n"

    it "Start is good" $
      isGood (Maze [[Start]]) (0, 0) (0, 0)
      `shouldBe` True

    it "End is good" $
      isGood (Maze [[End]]) (0, 0) (0, 0)
      `shouldBe` True

    it "Walls are bad" $
      isGood (Maze [[Wall]]) (0, 0) (0, 0)
      `shouldBe` False

    it "Find a good space" $
      isGood (Maze [[Start, Space, End]]) (0, 1) (0, 1)
      `shouldBe` True

    it "Find a bad space" $
      isGood (Maze [[Start, End, Wall, Space]]) (0, 3) (0, 3)
      `shouldBe` False

    it "Solve a big maze" $
      isGood (Maze [[Start, Space, Space, End]]) (0, 1) (0, 1)
      `shouldBe` True

    it "Solve 2D maze" $
      isGood (Maze [[Start, Space, End], [Wall, Space, Wall]]) (1, 1) (1, 1)
      `shouldBe` False
