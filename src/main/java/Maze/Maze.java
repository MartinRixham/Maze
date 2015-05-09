package Maze;

public class Maze
{
	private MazeSquare[][] mazeGrid;

	public Maze(
		MazeSquare[][] mazeGrid)
	{
		this.mazeGrid = mazeGrid;
	}

	public String solve()
	{
		StringBuilder solutionGrid = new StringBuilder();

		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				solutionGrid.append(mazeGrid[i][j].getCharacter());
			}

			solutionGrid.append('\n');
		}

		return solutionGrid.toString();
	}
}
