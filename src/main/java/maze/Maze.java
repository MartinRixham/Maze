package maze;

public class Maze
{
	private MazeSquare[][] mazeGrid;

	public Maze(MazeSquare[][] mazeGrid)
	{
		this.mazeGrid = mazeGrid;
	}

	public String solve()
	{
		String solutionGrid = "";

		for (int i = 0; i < mazeGrid[0].length; i++)
		{
			for (int j = 0; j < mazeGrid.length; j++)
			{
				solutionGrid += mazeGrid[j][i].getCharacter();
			}

			solutionGrid += '\n';
		}

		return solutionGrid;
	}
}
