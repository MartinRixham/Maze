package Maze;

public enum SquareType
{
	WALL,

	SPACE,

	START,

	END;

	public char toCharacter()
	{
		switch (this)
		{
			case WALL:
				return '#';
			case SPACE:
				return ' ';
			case START:
				return 'S';
			case END:
				return 'E';
		}

		throw new RuntimeException("There is no character implemented for square type " + this.name() + ".");
	}
}
