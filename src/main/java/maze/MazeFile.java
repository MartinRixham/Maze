package maze;

import java.util.List;

public class MazeFile
{
	private TextFile textFile;

	public MazeFile(String fileName)
	{
		this.textFile = new TextFile(fileName);
	}

	public Maze getMaze()
	{
		List<String> fileLines = this.textFile.read();
		MazeSquare[][] mazeGrid = this.getMazeGrid(fileLines);

		for (int i = 0; i < mazeGrid.length; i++)
		{
			String line = fileLines.get(i + 1);

			for (int j = 0; j < mazeGrid[i].length; j++)
			{
				char character = line.charAt(j);
				mazeGrid[j][i] = this.getSquare(character, mazeGrid);
			}
		}

		return new Maze(mazeGrid);
	}

	private MazeSquare getSquare(char character, MazeSquare[][] mazeGrid) {

		if (character == 'S')
        {
             return new Start();
        }
        else if (character == 'E')
        {
            return new End();
        }
        else if (character == '#')
        {
            return new Wall();
        }
        else
        {
            return new Space(mazeGrid);
        }
	}

	private MazeSquare[][] getMazeGrid(List<String> fileLines)
	{
		String dimensionsLine = fileLines.get(0);
		String[] dimensions = dimensionsLine.split(" ");

		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);

		return new MazeSquare[width][height];
	}
}
