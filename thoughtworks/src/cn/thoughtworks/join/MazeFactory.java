package cn.thoughtworks.join;

/**
 * MazeFactory，用于创建Maze
 * @author darlingliu 2018-07-28
 *
 */

public class MazeFactory {
	
	public static String result = null;
	
	/**
	 * @param command 程序输入
	 * @return 通过输入字符串，构造Maze并返回
	 */
	public static Maze create(String command) {
		Maze maze = new Maze();
		String[] rows = command.split("\n");
		if(rows.length != 3) {
			result = "Incorrect command format.";
			return maze;
		}
		String maze_size = rows[0];
		String connection = rows[1];
		String robot_move = rows[2];
		String[][] maze_matrix = init(maze_size);
		connect_maze(maze_matrix, connection);
		maze.setMazeMatrix(maze_matrix);
		return maze;
	}
	
	/**
	 * 通过输入command的第一行，完成MazeMatrix的初始化
	 * @param size 包含MazeMatrix行和列的字符串
	 * @return 二维String数组，代表MazeMatrix
	 */
	private static String[][] init(String maze_size) {
		String[] row_col = maze_size.split(" ");
		if(row_col.length != 2) {
			result = "Incorrect command format.";
			return null;
		}		
		try {
			int row = Integer.valueOf(row_col[0]);
			int colum = Integer.valueOf(row_col[1]);
			if(row <= 0 || colum <= 0) {
				result = "Number out of range.";
				return null;
			}				
			String[][] maze_matrix = new String[2*row+1][2*colum+1];
			for(int i = 0; i < maze_matrix.length; i++) {
				for(int j = 0; j < maze_matrix[0].length; j++) {
					if(i % 2 == 1 && j % 2 == 1)
						maze_matrix[i][j] = "[R]";
					else
						maze_matrix[i][j] = "[W]";
				}
			}	
			return maze_matrix;
		} catch (NumberFormatException e) {
			result = "Invalid number format.";
		}
		return null;
	}
	
	/**
	 * 通过连通性，将迷宫中道路连通
	 * @param maze_matrix 初始化后的MazeMatrix
	 * @param connection 连通性定义字符串
	 */
	private static void connect_maze(String[][] maze_matrix, String connection){

		if(maze_matrix == null || connection == null || connection.equals(" "))
			return;
		int road_x = maze_matrix.length/2;
		int road_y = maze_matrix[0].length/2;
		String[] connections = connection.split(";");
		for(String connect: connections) {
			String[] pos = connect.split(",| ");
			if(pos.length == 4) {
				try {
					int p1_x = Integer.valueOf(pos[0]);
					int p1_y = Integer.valueOf(pos[1]);
					int p2_x = Integer.valueOf(pos[2]);
					int p2_y = Integer.valueOf(pos[3]);
					if(p1_x < 0 || p1_x >= road_x || p1_y < 0 || p1_y >= road_y || p2_x < 0 || p2_x >= road_x || p2_y < 0 || p2_y >= road_y ) {
						result = "Number out of range.";
						return;
					}
					if(p1_x == p2_x && Math.abs(p1_y-p2_y) == 1) {
						maze_matrix[2*p1_x+1][p1_y+p2_y+1] = "[R]";
					}else if (p1_y == p2_y && Math.abs(p1_x-p2_x) == 1) {
						maze_matrix[p1_x+p2_x+1][2*p1_y+1] = "[R]";
					}else {
						result = "Maze format error.";
						return;
					}
				} catch (NumberFormatException e) {
					result = "Invalid number format.";
					return;
				}
			}else {
				result = "Incorrect command format.";
				return;
			}
		}		
	}
	
	public static void robotMove(String movePath, String[][] mazeMatrix) {
		String[] robot_movePath = movePath.split(" ");
		if(robot_movePath.length > 2 ) {
			MazeFactory.result = "Incorrect command format";
			return;
		}
		String robot_pos = robot_movePath[0];
		String robot_move = robot_movePath.length == 2? robot_movePath[1]:null;
		String[] pos = robot_pos.split(",");
		if(pos.length != 2) {
			MazeFactory.result = "Incorrect command format";
			return;
		}
		int maze_x = mazeMatrix.length/2;
		int maze_y = mazeMatrix[0].length/2;
		try {
			int pos_x = Integer.valueOf(pos[0]);
			int pos_y = Integer.valueOf(pos[1]);
			mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
			if(robot_move != null) {
				mazeMatrix[2*pos_x+1][2*pos_y+1] = "[R]";
				String[] move = robot_move.split("");
				for(String m: move) {
					switch (m) {
					case "W":
						if(pos_y - 1 < 0 ) {
							mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
							return;
						}else {
							pos_y--;
						}
						break;
					case "A":
						if(pos_x - 1 < 0) {
							mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
							return;
						}else {
							pos_x--;
						}
						break;
					case "S":
						if(pos_y + 1 >= maze_y ) {
							mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
							return;
						}else {
							pos_y++;
						}
						break;
					case "D":
						if(pos_x + 1 >= maze_x) {
							mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
							return;
						}else {
							pos_x++;
						}
						break;
					default:
						mazeMatrix[2*pos_x+1][2*pos_y+1] = "[*]";
						return;
					}
				}
			}
		} catch (NumberFormatException e) {
			MazeFactory.result = "Invalid number format.";
		}
	}
}
