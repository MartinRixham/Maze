package Maze;

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

		String dimensionsLine = fileLines.get(0);

		String[] dimensions = dimensionsLine.split(" ");

		int height = Integer.parseInt(dimensions[0]);
		int width = Integer.parseInt(dimensions[1]);

		MazeSquare[][] mazeGrid = new MazeSquare[height][width];

		String startPositionLine = fileLines.get(1);

		String[] startCoordinate = startPositionLine.split(" ");

		Coordinate startPosition =
				new Coordinate(
						Integer.parseInt(startCoordinate[0]),
						Integer.parseInt(startCoordinate[1]));

		String endPositionLine = fileLines.get(2);

		String[] endCoordinate = endPositionLine.split(" ");

		Coordinate endPosition =
				new Coordinate(
						Integer.parseInt(endCoordinate[0]),
						Integer.parseInt(endCoordinate[1]));

		for (int i = 3; i < fileLines.size(); i++)
		{
			String line = fileLines.get(i).replaceAll(" ", "");

			for (int j = 0; j < line.length(); j++)
			{
				char character = line.charAt(j);

				if (startPosition.isAt(j, i - 3))
				{
					mazeGrid[i - 3][j] =
							new MazeSquare(SquareType.START, mazeGrid);
				}
				else if (endPosition.isAt(j, i - 3))
				{
					mazeGrid[i - 3][j] =
							new MazeSquare(SquareType.END, mazeGrid);
				}
				else if (character == '0')
				{
					mazeGrid[i - 3][j] =
						new MazeSquare(SquareType.SPACE, mazeGrid);
				}
				else if (character == '1')
				{
					mazeGrid[i - 3][j] =
						new MazeSquare(SquareType.WALL, mazeGrid);
				}
			}
		}

		return new Maze(mazeGrid);
	}
}
