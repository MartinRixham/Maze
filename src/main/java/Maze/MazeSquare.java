package Maze;

public interface MazeSquare
{
	char getCharacter();

	boolean isGood(Space caller);
}
