package Maze;

public class Start implements MazeSquare
{
	@Override
	public char getCharacter()
	{
		return 'S';
	}

	@Override
	public boolean isGood(Space caller)
	{
		return true;
	}

	@Override
	public boolean alreadyAsked()
	{
		return false;
	}
}
