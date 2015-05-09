package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeSquareTest
{
	@Test
	public void getCharacter_isWall_returnsHash()
	{
		MazeSquare mazeSquare = new MazeSquare(true);

		char character = mazeSquare.getCharacter();

		assertEquals('#', character);
	}

	@Test
	public void getCharacter_isNotWall_returnsSpace()
	{
		MazeSquare mazeSquare = new MazeSquare(false);

		char character = mazeSquare.getCharacter();

		assertEquals(' ', character);
	}
}
