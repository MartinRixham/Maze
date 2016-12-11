module Maze (Maze (..), MazeSquare (..), isGood, solve) where

data Maze = Maze [[MazeSquare]] deriving (Show)

data MazeSquare = Start | End | Wall | Space deriving (Eq, Show)
type Coordinate = (Int, Int)

getCharacter :: MazeSquare -> Char
getCharacter Start = 'S'
getCharacter End   = 'E'
getCharacter Wall  = '#'
getCharacter Space = ' '

solveCoordinate :: Maze -> (Int, Int) -> Char
solveCoordinate (Maze maze) (x, y) = case (maze !! x) !! y of
  Start -> 'S'
  End   -> 'E'
  Wall  -> '#'
  Space -> if isGood (Maze maze) (x, y) (x, y) then 'X' else ' '

getMazeSquare :: Maze -> (Int, Int) -> MazeSquare
getMazeSquare (Maze maze) (x,y) = (maze !! x) !! y

width :: Maze -> Int
width (Maze maze) = if length maze == 0
                    then 0
                    else length $ maze !! 0

height :: Maze -> Int
height (Maze maze) = length maze

solve :: Maze -> String
solve maze = unlines $ map (map $ solveCoordinate maze) coordinates
  where
    w = width maze
    h = height maze
    coordinates = [[(x,y)| y <- [0..w-1]] | x <- [0..h-1]]

-- isGood ::  Maze -> (Int, Int) -> Bool
-- isGood maze (x, y)
-- --  | x < 0 || x >= length m = False
--   | y < 0 || y > w  = False
--   | square == Start = True
--   | square == End   = True
--   | square == Wall  = False
--   | otherwise       = isGood maze (x,y-1) && isGood maze (x,y+1)
--   where
--     square = getMazeSquare maze (x,y)
--     w = width maze

any2 :: [Bool] -> Bool
any2 [] = False
any2 (b:bs) = if b then any id bs else any2 bs

isGood ::  Maze -> (Int, Int) -> (Int, Int) -> Bool
isGood maze (x, y) (xCaller, yCaller)
  | not $ isInside (x,y) = False
  | square == Wall       = False
  | square == Start      = True
  | square == End        = True
  | otherwise = any2 $ map (\p -> p == (xCaller, yCaller) || isGood maze p (x,y)) neighbours
  where
    square = getMazeSquare maze (x,y)
    neighbours = filter (\p -> isInside p) [(x, y-1), (x, y+1), (x-1, y), (x+1, y)]
    isInside (x, y) = 0 <= x && x < height maze && 0 <= y && y < width maze
