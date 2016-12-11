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

isGood ::  Maze -> (Int, Int) -> (Int, Int) -> Bool
isGood maze (x, y) (xCaller, yCaller)
--  | x < 0 || x >= length m = False
  | y < 0 || y > w  = False
  | square == Start = True
  | square == End   = True
  | square == Wall  = False
  | (x, y-1) == (xCaller, yCaller) = isGood maze (x,y+1) (x, y)
  | (x, y+1) == (xCaller, yCaller) = isGood maze (x,y-1) (x, y)
  | otherwise       = isGood maze (x,y-1) (x, y) && isGood maze (x,y+1) (x, y)
  where
    square = getMazeSquare maze (x,y)
    w = width maze
