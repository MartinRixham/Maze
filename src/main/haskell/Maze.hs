module Maze (Maze (..), MazeSquare, solve) where

type MazeSquare = Char

data Maze = Maze [[MazeSquare]] deriving (Show)

solve :: Maze -> String
solve (Maze m) = concat m
