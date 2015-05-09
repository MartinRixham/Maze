package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest
{
	@Test
	public void solve_trivialMaze_returnsSolution()
	{
		MazeSquare[][] mazeGrid =
			new MazeSquare[][]
			{
				new MazeSquare[]
					{
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true)
					},
				new MazeSquare[]
					{
						new MazeSquare(true),
						new MazeSquare(false),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true)
					},
				new MazeSquare[]
					{
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(false),
						new MazeSquare(true),
						new MazeSquare(true)
					},
				new MazeSquare[]
					{
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(false),
						new MazeSquare(true)
					},
				new MazeSquare[]
					{
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true),
						new MazeSquare(true)
					}
			};

		Coordinate startPosition = new Coordinate(1, 1);

		Coordinate endPosition = new Coordinate(3, 3);

		Maze maze =
			new Maze(mazeGrid, startPosition, endPosition);

		String solution = maze.solve();

		assertEquals(
			"#####\n#S###\n## ##\n###E#\n#####\n",
			solution
		);
	}
}
