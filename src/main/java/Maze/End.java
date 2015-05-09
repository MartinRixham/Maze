package Maze;

public class End implements MazeSquare
{
	@Override
	public char getCharacter()
	{
		return 'E';
	}

	@Override
	public boolean isGood(Space caller)
	{
		return true;
	}
}
