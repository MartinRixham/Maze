package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeSquareTest
{
	@Test
	public void getCharacter_wallSquare_returnsHash()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare =
			new MazeSquare(SquareType.WALL, mazeGrid);

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('#', character);
	}

	@Test
	public void getCharacter_spaceSquare_returnsSpace()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare =
			new MazeSquare(SquareType.SPACE, mazeGrid);

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals(' ', character);
	}

	@Test
	public void getCharacter_startSquare_returnsS()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare =
				new MazeSquare(SquareType.START, mazeGrid);

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('S', character);
	}

	@Test
	public void getCharacter_endSquare_returnsE()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare =
				new MazeSquare(SquareType.END, mazeGrid);

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('E', character);
	}
}
