module Maze (Maze (..), MazeSquare, isGood, solve) where

type MazeSquare = Char

data Maze = Maze [[MazeSquare]] deriving (Show)

solve :: Maze -> String
solve (Maze m) = map f $ unlines m
  where f ' ' = 'X'
        f c   = c

isGood ::  Maze -> Int -> Int -> Bool
isGood (Maze m) x y = True
