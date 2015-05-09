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

		String lines = "";

		for (String line : fileLines)
		{
			lines = lines.concat(line);
			lines = lines.concat("\n");
		}

		return new Maze(lines);
	}
}
