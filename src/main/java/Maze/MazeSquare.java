package Maze;

public class MazeSquare
{
	public boolean isWall;

	public MazeSquare(boolean isWall)
	{
		this.isWall = isWall;
	}

	public char getCharacter()
	{
		if (isWall)
		{
			return '#';
		}
		else
		{
			return ' ';
		}
	}
}
