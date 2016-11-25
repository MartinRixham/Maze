package maze;

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

	@Override
	public boolean alreadyAsked()
	{
		return false;
	}
}
