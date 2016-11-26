package maze;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MazeFileTest
{
	@Test
	public void getMaze_simpleMaze_returnsGridWithSquares()
	{
		List<String> fileLines =
			Arrays.asList(
				"4 4",
				"####",
				"#S #",
				"# E#",
				"####");

		MazeFile mazeFile = new MazeFile(fileLines);
		MazeSquare[][] mazeGrid = mazeFile.getMaze();

		assertTrue(mazeGrid[0][0] instanceof Wall);
		assertTrue(mazeGrid[0][1] instanceof Wall);
		assertTrue(mazeGrid[0][2] instanceof Wall);
		assertTrue(mazeGrid[0][3] instanceof Wall);

		assertTrue(mazeGrid[1][0] instanceof Wall);
		assertTrue(mazeGrid[1][1] instanceof Start);
		assertTrue(mazeGrid[1][2] instanceof Space);
		assertTrue(mazeGrid[1][3] instanceof Wall);

		assertTrue(mazeGrid[2][0] instanceof Wall);
		assertTrue(mazeGrid[2][1] instanceof Space);
		assertTrue(mazeGrid[2][2] instanceof End);
		assertTrue(mazeGrid[2][3] instanceof Wall);

		assertTrue(mazeGrid[3][0] instanceof Wall);
		assertTrue(mazeGrid[3][1] instanceof Wall);
		assertTrue(mazeGrid[3][2] instanceof Wall);
		assertTrue(mazeGrid[3][3] instanceof Wall);
	}
}
