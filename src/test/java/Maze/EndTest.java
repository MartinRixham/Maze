package Maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndTest
{
	@Test
	public void getCharacter_endSquare_returnsE()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare = new End();

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('E', character);
	}
}
