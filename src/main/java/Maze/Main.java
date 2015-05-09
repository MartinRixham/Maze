package Maze;

public class Main
{
	public static void main(String[] args)
	{
		String fileName = args[0];

		MazeFile mazeFile = new MazeFile(fileName);

		Maze maze = mazeFile.getMaze();

		String solution = maze.solve();

		System.out.println(solution);
	}
}
