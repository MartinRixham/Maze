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

		for (int i = 3; i < fileLines.size(); i++)
		{
			String line = fileLines.get(i).replaceAll(" ", "");

			for (int j = 0; j < line.length(); j++)
			{
				char character = line.charAt(j);

				if (character == '1')
				{
					mazeGrid[i - 3][j] = new MazeSquare(true);
				}
				else if (character == '0')
				{
					mazeGrid[i - 3][j] = new MazeSquare(false);
				}
			}
		}

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

		return new Maze(mazeGrid, startPosition, endPosition);
	}
}
