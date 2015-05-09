package Maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFile
{
	private String file;

	public TextFile(String file)
	{
		this.file = file;
	}

	public List<String> read()
	{
		BufferedReader fileReader;

		try
		{
			fileReader = new BufferedReader(new FileReader(this.file));
		}
		catch(FileNotFoundException exception)
		{
			throw new RuntimeException(exception);
		}

		String fileLine;

		List<String> fileLines = new ArrayList<String>();

		try
		{
			while ((fileLine = fileReader.readLine()) != null)
			{
				fileLines.add(fileLine);
			}
		}
		catch(IOException exception)
		{
			throw new RuntimeException(exception);
		}

		return fileLines;
	}
}