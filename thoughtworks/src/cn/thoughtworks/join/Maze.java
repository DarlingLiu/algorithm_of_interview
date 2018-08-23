package cn.thoughtworks.join;

/**
 * �Թ��࣬�ڲ���һ����ά����mazeMatrix���洢�Թ��ľ�������
 * @author darlingliu 2018-07-28
 *
 */
public class Maze {
	private String[][] mazeMatrix;
	public Maze() {
		
	}
	public Maze(String[][] mazeMatrix) {
		this.setMazeMatrix(mazeMatrix);
	}
	public String[][] getMazeMatrix() {
		return mazeMatrix;
	}
	public void setMazeMatrix(String[][] mazeMatrix) {
		this.mazeMatrix = mazeMatrix;
	}
	
	/**
	 * @return ��Maze������Ⱦ��������Ⱦ����ַ���
	 */
	public String render() {
		if(MazeFactory.result != null)
			return MazeFactory.result;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < mazeMatrix.length; i++) {
			for(int j = 0; j < mazeMatrix[0].length; j++) {
				sb.append(mazeMatrix[i][j] + " ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		return sb.toString();
	}
	
}
