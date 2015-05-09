package Maze;

public class Maze
{
	private MazeSquare[][] mazeGrid;

	private Coordinate startPosition;

	private Coordinate endPosition;

	public Maze(
		MazeSquare[][] mazeGrid,
		Coordinate startPosition,
		Coordinate endPosition)
	{
		this.mazeGrid = mazeGrid;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}

	public String solve()
	{
		StringBuilder solutionGrid = new StringBuilder();

		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				if (startPosition.isAt(j, i))
				{
					solutionGrid.append('S');
				}
				else if (endPosition.isAt(j, i))
				{
					solutionGrid.append('E');
				}
				else
				{
					solutionGrid.append(mazeGrid[i][j].getCharacter());
				}
			}

			solutionGrid.append('\n');
		}

		return solutionGrid.toString();
	}
}
