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
      `shouldBe` ""
