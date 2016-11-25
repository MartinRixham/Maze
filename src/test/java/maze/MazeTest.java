package maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest
{
	@Test
	public void solve_trivialMaze_returnsSolution()
	{
		MazeSquare[][] mazeGrid = new MazeSquare[5][5];

		mazeGrid[0][0] = new Wall();
		mazeGrid[0][1] = new Wall();
		mazeGrid[0][2] = new Wall();
		mazeGrid[0][3] = new Wall();
		mazeGrid[0][4] = new Wall();

		mazeGrid[1][0] = new Wall();
		mazeGrid[1][1] = new Start();
		mazeGrid[1][2] = new Wall();
		mazeGrid[1][3] = new Wall();
		mazeGrid[1][4] = new Wall();

		mazeGrid[2][0] = new Wall();
		mazeGrid[2][1] = new Wall();
		mazeGrid[2][2] = new Space(mazeGrid);
		mazeGrid[2][3] = new Wall();
		mazeGrid[2][4] = new Wall();

		mazeGrid[3][0] = new Wall();
		mazeGrid[3][1] = new Wall();
		mazeGrid[3][2] = new Wall();
		mazeGrid[3][3] = new End();
		mazeGrid[3][4] = new Wall();

		mazeGrid[4][0] = new Wall();
		mazeGrid[4][1] = new Wall();
		mazeGrid[4][2] = new Wall();
		mazeGrid[4][3] = new Wall();
		mazeGrid[4][4] = new Wall();

		Maze maze =
			new Maze(mazeGrid);

		String solution = maze.solve();

		assertEquals(
			"#####\n#S###\n## ##\n###E#\n#####\n",
			solution
		);
	}
}
