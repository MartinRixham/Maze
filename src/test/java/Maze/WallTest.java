package Maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WallTest
{
	@Test
	public void getCharacter_wallSquare_returnsHash()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[1][1];

		MazeSquare mazeSquare = new Wall();

		mazeGrid[0][0] = mazeSquare;

		char character = mazeSquare.getCharacter();

		assertEquals('#', character);
	}
}
