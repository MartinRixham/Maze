package maze;

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
				new Integer[] { 0, 1, 0 },
				new Integer[] { 1, 9, 1 },
				new Integer[] { 0, 1, 0 },
			};

		Collection<Integer> neighbours = coordinate.getNeighbours(grid);

		assertEquals(4, neighbours.size());

		for (Integer neighbour : neighbours)
		{
			assertEquals(new Integer(1), neighbour);
		}
	}
}
