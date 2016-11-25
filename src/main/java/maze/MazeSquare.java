package maze;

public interface MazeSquare
{
	char getCharacter();

	boolean isGood(Space caller);

	boolean alreadyAsked();
}
