package Maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest
{
	@Test
	public void isGood_spaceSurroundedByWalls_returnsFalse()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new End();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Wall();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		assertFalse(mazeSquare.isGood(mazeSquare));
	}

	@Test
	public void isGood_spaceSurroundedOnThreeSidesByWalls_returnsFalse()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Space(mazeGrid);

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		assertFalse(mazeSquare.isGood(mazeSquare));
	}

	@Test
	public void isGood_spaceBetweenStartAndEnd_returnsTrue()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new End();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Start();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		assertTrue(mazeSquare.isGood(mazeSquare));
	}

	@Test
	public void isGood_spaceNextToStartAndThreeWalls_returnsFalse()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][3];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = mazeSquare;
		mazeGrid[1][2] = new Start();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();

		assertFalse(mazeSquare.isGood(mazeSquare));
	}

	@Test
	public void isGood_spaceNextToTwoSpacesAndTwoWalls_returnsFalse()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][5];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();
		mazeGrid[0][3] = new Wall();
		mazeGrid[0][4] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = new Space(mazeGrid);
		mazeGrid[1][2] = mazeSquare;
		mazeGrid[1][3] = new Space(mazeGrid);
		mazeGrid[1][4] = new Wall();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();
		mazeGrid[2][3] = new Wall();
		mazeGrid[2][4] = new Wall();

		assertFalse(mazeSquare.isGood(mazeSquare));
	}

	@Test
	public void isGood_spaceSeparatedFromStartAndEnd_returnsFalse()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[3][5];

		Space mazeSquare = new Space(mazeGrid);

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();
		mazeGrid[0][3] = new Wall();
		mazeGrid[0][4] = new Wall();

		mazeGrid[1][0] = new Start();
		mazeGrid[1][1] = new Space(mazeGrid);
		mazeGrid[1][2] = mazeSquare;
		mazeGrid[1][3] = new Space(mazeGrid);
		mazeGrid[1][4] = new End();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Wall();
		mazeGrid[2][3] = new Wall();
		mazeGrid[2][4] = new Wall();

		assertTrue(mazeSquare.isGood(mazeSquare));
	}
}
