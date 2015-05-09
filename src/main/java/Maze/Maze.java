package Maze;

public class Maze
{
	private boolean[][] mazeGrid;

	public Maze(boolean[][] mazeGrid)
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
				if (mazeGrid[i][j])
				{
					solutionGrid.append('#');
				}
				else
				{
					solutionGrid.append(' ');
				}
			}

			solutionGrid.append('\n');
		}

		return solutionGrid.toString();
	}
}
