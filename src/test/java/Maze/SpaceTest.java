package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest
{
	@Test
	public void getCharacter_spaceSquare_returnsSpace()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals(' ', character);
	}
}
