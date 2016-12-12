module Maze (Maze (..), MazeSquare (..), fromString, fromChar, isGood, solve) where

--------------------------------------------------------------------------------

type Coordinate = (Int, Int)

any2 :: [Bool] -> Bool
any2 [] = False
any2 (b:bs) = if b then any id bs else any2 bs

--------------------------------------------------------------------------------

data Maze = Maze [[MazeSquare]] deriving (Eq, Show)

fromString :: String -> Maze
fromString s = Maze $ map (map fromChar) $ lines s

width :: Maze -> Int
width (Maze maze) = if length maze == 0
                    then 0
                    else length $ maze !! 0

height :: Maze -> Int
height (Maze maze) = length maze

solveCoordinate :: Maze -> Coordinate -> Char
solveCoordinate (Maze maze) (x, y) = case (maze !! x) !! y of
  Start -> 'S'
  End   -> 'E'
  Wall  -> '#'
  Space -> if isGood (Maze maze) (x, y) (x, y) then 'X' else ' '

getMazeSquare :: Maze -> Coordinate -> MazeSquare
getMazeSquare (Maze maze) (x,y) = (maze !! x) !! y

solve :: Maze -> String
solve maze = unlines $ map (map $ solveCoordinate maze) coordinates
  where
    w = width maze
    h = height maze
    coordinates = [[(x,y)| y <- [0..w-1]] | x <- [0..h-1]]

isGood ::  Maze -> Coordinate -> Coordinate -> Bool
isGood maze (x, y) (xCaller, yCaller)
  | not $ isInside (x,y) = False
  | square == Wall       = False
  | square == Start      = True
  | square == End        = True
  | otherwise = any2 $ map isGoodOrCaller neighbours
  where
    square = getMazeSquare maze (x,y)
    neighbours = filter (\p -> isInside p) [(x, y-1), (x, y+1), (x-1, y), (x+1, y)]
    isInside (x, y) = 0 <= x && x < height maze && 0 <= y && y < width maze
    isGoodOrCaller p = p == (xCaller, yCaller) || isGood maze p (x,y)

--------------------------------------------------------------------------------

data MazeSquare = Start | End | Wall | Space deriving (Eq, Show)

fromChar :: Char -> MazeSquare
fromChar 'S' = Start
fromChar 'E' = End
fromChar '#' = Wall
fromChar ' ' = Space
