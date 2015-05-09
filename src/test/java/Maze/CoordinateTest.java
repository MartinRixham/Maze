package Maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Collection;

public class CoordinateTest
{
	@Test
	public void getNeighbours_emptyGrid_returnsNoNeighbours()
	{
		Coordinate coordinate = new Coordinate(0, 0);

		Object[][] grid = new Object[0][0];

		Collection<Object> neighbours = coordinate.getNeighbours(grid);

		assertEquals(0, neighbours.size());
	}

	@Test
	public void getNeighbours_coordinateInTheMiddle_returnsFourNeighbours()
	{
		Coordinate coordinate = new Coordinate(1, 1);

		Integer[][] grid =
			new Integer[][]
			{
				new Integer[] { 1, 2, 3 },
				new Integer[] { 4, 5, 6 },
				new Integer[] { 7, 8, 9 },
			};

		Collection<Integer> neighbours = coordinate.getNeighbours(grid);

		assertEquals(4, neighbours.size());
	}
}
