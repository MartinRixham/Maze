package Maze;

public class Maze
{
	private boolean[][] mazeGrid;

	private Coordinate startPosition;

	public Maze(boolean[][] mazeGrid, Coordinate startPosition)
	{
		this.mazeGrid = mazeGrid;
		this.startPosition = startPosition;
	}

	public String solve()
	{
		StringBuilder solutionGrid = new StringBuilder();

		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				if (startPosition.x() == j && startPosition.y() == i)
				{
					solutionGrid.append('S');
				}
				else if (mazeGrid[i][j])
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
