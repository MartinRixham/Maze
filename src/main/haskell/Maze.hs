module Maze (Maze (..), MazeSquare (..), fromString, fromChar, isGood, solve) where

import Control.Monad.Fix

--------------------------------------------------------------------------------

-- returns true if at least two of the booleans in a list are True
any2 :: [Bool] -> Bool
any2 [] = False
any2 (b:bs) = if b then any id bs else any2 bs

-- returns first element of a (possibly infinite) list which is equal to
-- the following element
stable :: (Eq a) => [a] -> a
stable (x:ys@(y:_))
    | x == y     = x
    | otherwise = stable ys

-- returns the shortest list (that is shorter than the maximum Int)
-- in a list of lists
shortest :: [[a]] -> [a]
shortest = snd . foldr findMin (maxBound :: Int,[])
  where findMin x (yLen, y) = let xLen = length x in
          if xLen < yLen then (xLen, x) else (yLen, y)

--------------------------------------------------------------------------------

type Coordinate = (Int, Int)

--------------------------------------------------------------------------------

data Maze = Maze [[MazeSquare]] deriving (Eq, Show)

fromString :: String -> Maze
fromString s = Maze $ map (map fromChar) $ lines s

showPath :: Maze -> [Coordinate] -> String
showPath maze path = unlines $ map (map $ showCoordinate maze) (getCoordinatesGrid maze)
  where
    showCoordinate maze p = case getMazeSquare maze p of
      Start -> 'S'
      End   -> 'E'
      Wall  -> '#'
      Space -> if p `elem` path then 'X' else ' '

width :: Maze -> Int
width (Maze maze) = if length maze == 0
                    then 0
                    else length $ maze !! 0

height :: Maze -> Int
height (Maze maze) = length maze

isInside :: Maze -> Coordinate -> Bool
isInside maze (x, y) = 0 <= x && x < height maze && 0 <= y && y < width maze

getCoordinatesList :: Maze -> [Coordinate]
getCoordinatesList maze = [(x,y) | x <- [0..h-1], y <- [0..w-1]]
  where h = height maze
        w = width maze

getCoordinatesGrid :: Maze -> [[Coordinate]]
getCoordinatesGrid maze = [[(x,y)| y <- [0..w-1]] | x <- [0..h-1]]
  where h = height maze
        w = width maze

listOfStarts :: Maze -> [Coordinate]
listOfStarts maze = filter ((==Start).(getMazeSquare maze)) $ getCoordinatesList maze

goodPaths :: Maze -> [[Coordinate]]
goodPaths maze = filter reachesEnd paths
  where reachesEnd = (==End) . (getMazeSquare maze) . last
        paths = stable $ iterate (concatMap $ extendPath maze) [[]]

extendPath :: Maze -> [Coordinate] -> [[Coordinate]]
extendPath maze [] = map (:[]) $ listOfStarts maze
extendPath maze path
  | extensions == [] = [path]
  | reachesEnd path = [path]
  | otherwise = map ((path ++) . return) extensions
  where
    (x,y) = last path
    notWall = (/= Wall) . getMazeSquare maze
    extensions = filter (\p -> isInside maze p && p `notElem` path && notWall p) [(x, y-1), (x, y+1), (x-1, y), (x+1, y)]
    reachesEnd = (==End) . (getMazeSquare maze) . last

solveCoordinate :: Maze -> Coordinate -> Char
solveCoordinate maze p = case getMazeSquare maze p of
  Start -> 'S'
  End   -> 'E'
  Wall  -> '#'
  Space -> if p `elem` shortestPath then 'X' else ' '
  where
    shortestPath = shortest $ goodPaths maze

getMazeSquare :: Maze -> Coordinate -> MazeSquare
getMazeSquare (Maze maze) (x,y) = (maze !! x) !! y

solve :: Maze -> String
solve maze = unlines $ map (map $ solveCoordinate maze) (getCoordinatesGrid maze)

isGood ::  Maze -> Coordinate -> Coordinate -> Bool
isGood maze p pCaller
  | not $ isInside maze p = False
  | square == Wall        = False
  | square == Start       = True
  | square == End         = True
  | otherwise = any (p `elem`) $ goodPaths maze
  where square = getMazeSquare maze p

--------------------------------------------------------------------------------

data MazeSquare = Start | End | Wall | Space deriving (Eq, Show)

fromChar :: Char -> MazeSquare
fromChar 'S' = Start
fromChar 'E' = End
fromChar '#' = Wall
fromChar ' ' = Space
