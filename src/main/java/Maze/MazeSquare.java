package Maze;

public class MazeSquare
{
	private SquareType squareType;

	private MazeSquare[][] mazeGrid;

	public MazeSquare(SquareType squareType, MazeSquare[][] mazeGrid)
	{
		this.squareType = squareType;
		this.mazeGrid = mazeGrid;
	}

	public char getCharacter()
	{
		return this.squareType.toCharacter();
	}
}
