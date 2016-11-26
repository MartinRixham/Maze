package maze;

import java.util.ArrayList;
import java.util.Collection;

public class Coordinate
{
	private int x;

	private int y;

	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public <T> Collection<T> getNeighbours(T[][] grid)
	{
		int x = this.x;
		int y = this.y;

		Collection<T> neighbours = new ArrayList<>();

		if (grid.length > x + 1)
		{
			neighbours.add(grid[x + 1][y]);
		}

		if (y > 0)
		{
			neighbours.add(grid[x][y - 1]);
		}

		if (x > 0)
		{
			neighbours.add(grid[x - 1][y]);
		}

		if (grid.length > x && grid[x].length > y + 1)
		{
			neighbours.add(grid[x][y + 1]);
		}

		return neighbours;
	}
}
