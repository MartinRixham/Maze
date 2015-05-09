package Maze;

import java.util.Collection;

public class Space implements MazeSquare
{
	private MazeSquare[][] mazeGrid;

	private boolean isBad = false;

	private boolean isGood = false;

	private boolean alreadyAsked = false;

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

	// A space is good if it lies on a direct path between the start and the end.
	public  boolean isGood(Space caller)
	{
		// If this has already been calculated don't recalculate.
		if (this.isBad)
		{
			return false;
		}

		if (this.isGood)
		{
			return true;
		}

		this.alreadyAsked = true;

		Coordinate coordinate = this.getCoordinate();

		Collection<MazeSquare> neighbours =
			coordinate.getNeighbours(this.mazeGrid);

		int badNeighbourCount = 0;

		for (MazeSquare neighbour : neighbours)
		{
			if (neighbour != caller &&
				(neighbour.alreadyAsked() || !neighbour.isGood(this)))
			{
				badNeighbourCount += 1;
			}
		}

		this.alreadyAsked = false;

		if (badNeighbourCount > 2)
		{
			this.isBad = true;

			return false;
		}

		if (caller == this)
		{
			this.isGood = true;
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

	@Override
	public boolean alreadyAsked()
	{
		return this.alreadyAsked;
	}
}
