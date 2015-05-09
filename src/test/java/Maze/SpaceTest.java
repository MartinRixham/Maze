package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest
{
	@Test
	public void getCharacter_spaceSurroundedByWalls_returnsSpace()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		MazeSquare mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Wall();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		char character = mazeSquare.getCharacter();

		assertEquals(' ', character);
	}

	@Test
	public void getCharacter_spaceSurroundedOnThreeSidesByWalls_returnsSpace()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		MazeSquare mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Space(mazeGrid);

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		char character = mazeSquare.getCharacter();

		assertEquals(' ', character);
	}

	@Test
	public void getCharacter_spaceBetweenStartAndEnd_returnsX()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		MazeSquare mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new End();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Start();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		char character = mazeSquare.getCharacter();

		assertEquals('X', character);
	}
}
