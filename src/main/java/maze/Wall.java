package maze;

public class Wall implements MazeSquare
{
	@Override
	public char getCharacter()
	{
		return '#';
	}

	@Override
	public boolean isGood(Space caller)
	{
		return false;
	}

	@Override
	public boolean alreadyAsked()
	{
		return false;
	}
}
