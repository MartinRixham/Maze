package maze;

public class Main
{
	public static void main(String[] args)
	{
		String fileName = args[0];
		TextFile textFile = new TextFile(fileName);
		MazeFile mazeFile = new MazeFile(textFile.read());
		Maze maze = new Maze(mazeFile.getMaze());
		String solution = maze.solve();

		System.out.print(solution);
	}
}
