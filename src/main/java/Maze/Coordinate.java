package Maze;

public class Coordinate
{
	private int x;

	private int y;

	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public boolean isAt(int x, int y)
	{
		return x == this.x && y == this.y;
	}
}
