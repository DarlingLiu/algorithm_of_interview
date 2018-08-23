package cn.thoughtworks.join;

public class MazeTest {

	public static void main(String[] args) {
		String command = "3 3" + "\n" + "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
		Maze maze = MazeFactory.create(command);
		String mazeText = maze.render();
		System.out.println(command);
		System.out.println(mazeText);
	}

}
