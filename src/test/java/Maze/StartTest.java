package Maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StartTest
{
	@Test
	public void getCharacter_startSquare_returnsS()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare = new Start();

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('S', character);
	}

}
