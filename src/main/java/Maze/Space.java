package Maze;

public class Space implements MazeSquare
{
	private MazeSquare[][] mazeGrid;

	public Space(MazeSquare[][] mazeGrid)
	{
		this.mazeGrid = mazeGrid;
	}

	public char getCharacter()
	{
		return ' ';
	}
}
