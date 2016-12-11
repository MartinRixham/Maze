module Maze (Maze (..), MazeSquare, isGood, solve) where

type MazeSquare = Char

data Maze = Maze [[MazeSquare]] deriving (Show)

solve :: Maze -> String
solve (Maze m) = map f $ unlines m
  where f ' ' = 'X'
        f c   = c

isGood ::  Maze -> Int -> Int -> Bool
isGood (Maze m) x y
--  | x < 0 || x >= length m = False
  | y < 0 || y > width = False
  | square == 'S' = True
  | square == 'E' = True
  | square == '#' = False
  | otherwise     = isGood (Maze m) x (y-1) && isGood (Maze m) x (y+1)
  where
    square = (m !! x) !! y
    width = if m == [] then 0 else length (m !! 0)
