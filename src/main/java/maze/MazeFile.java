package maze;

import java.util.List;

public class MazeFile
{
	private List<String> fileLines;

	public MazeFile(List<String> fileLines)
	{
		this.fileLines = fileLines;
	}

	public MazeSquare[][] getMaze()
	{
		MazeSquare[][] mazeGrid = this.getMazeGrid();

		for (int i = 0; i < mazeGrid.length; i++)
		{
			String line = this.fileLines.get(i + 1);

			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				char character = line.charAt(j);
				mazeGrid[j][i] = this.getSquare(character, mazeGrid);
			}
		}

		return mazeGrid;
	}

	private MazeSquare getSquare(char character, MazeSquare[][] mazeGrid) {

		switch (character) {

			case 'S':
				return new Start();
			case 'E':
				return new End();
			case '#':
				return new Wall();
			default:
				return new Space(mazeGrid);
		}
	}

	private MazeSquare[][] getMazeGrid()
	{
		String dimensionsLine = this.fileLines.get(0);
		String[] dimensions = dimensionsLine.split(" ");

		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);

		return new MazeSquare[width][height];
	}
}
