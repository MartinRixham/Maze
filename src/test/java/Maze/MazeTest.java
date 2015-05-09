package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest
{
	@Test
	public void solve_trivialMaze_returnsSolution()
	{
		boolean[][] mazeGrid =
			new boolean[][]
			{
				new boolean[] { true, true, true, true, true },
				new boolean[] { true, false, true, true, true },
				new boolean[] { true, true, false, true, true },
				new boolean[] { true, true, true, false, true },
				new boolean[] { true, true, true, true, true }
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
