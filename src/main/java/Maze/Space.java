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
		if (this.isGood(this))
		{
			return 'X';
		}
		else
		{
			return ' ';
		}
	}

	public  boolean isGood(Space caller)
	{
		Coordinate coordinate = this.getCoordinate();

		Collection<MazeSquare> neighbours =
			coordinate.getNeighbours(this.mazeGrid);

		int badNeighbourCount = 0;

		for (MazeSquare neighbour : neighbours)
		{
			if (neighbour != caller && !neighbour.isGood(this))
			{
				badNeighbourCount += 1;
			}
		}

		if (badNeighbourCount > 2)
		{
			return false;
		}

		return true;
	}

	private Coordinate getCoordinate()
	{
		for (int i = 0; i < mazeGrid.length; i++)
		{
			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				if (mazeGrid[i][j] == this)
				{
					return new Coordinate(i , j);
				}
			}
		}

		throw new RuntimeException("The space is not in the maze grid.");
	}
}
