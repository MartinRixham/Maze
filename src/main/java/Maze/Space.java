package Maze;

import java.util.Collection;

public class Space implements MazeSquare
{
	private MazeSquare[][] mazeGrid;

	public Space(MazeSquare[][] mazeGrid)
	{
		this.mazeGrid = mazeGrid;
	}

	public char getCharacter()
	{
		Coordinate coordinate = this.getCoordinate();

		Collection<MazeSquare> neighbours =
			coordinate.getNeighbours(this.mazeGrid);

		for (MazeSquare neighbour : neighbours)
		{
			if (neighbour instanceof Start)
			{
				return 'X';
			}
		}

		return ' ';
	}

	private Coordinate getCoordinate()
	{
		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				if (mazeGrid[i][j] == this)
				{
					return new Coordinate(j, i);
				}
			}
		}

		throw new RuntimeException("The space is not in the maze grid.");
	}
}
