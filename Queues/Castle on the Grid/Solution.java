import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		char[][] grid = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = in.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		in.close();

		Solution sol = new Solution();
		System.out.println(sol.getMinimumSteps(new Grid(a, b), new Grid(c, d), N, grid));
	}

	public int getMinimumSteps(Grid begin, Grid end, int n, char[][] grid) {
		boolean done = false;
		Queue<Grid> vertexQueue = new LinkedList<Grid>();
		begin.visit();
		vertexQueue.add(begin);

		while (!done && !vertexQueue.isEmpty()) {
			Grid front = vertexQueue.poll();
			List<Grid> neighbors = getNeighbors(front, n, grid);
			Iterator<Grid> gridNeighbors = neighbors.iterator();
			while (!done && gridNeighbors.hasNext()) {
				Grid nextNeighbor = gridNeighbors.next();
                
				if (!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					nextNeighbor.setLength(1 + front.getLength());
					vertexQueue.add(nextNeighbor);
				}

				if (nextNeighbor.equals(end)) {
					done = true;
					end.setLength(nextNeighbor.getLength());
				}

			}
		}

		return end.getLength();

	}

	public List<Grid> getNeighbors(Grid grid, int n, char[][] grid2) {
		List<Grid> neighbors = new ArrayList<Grid>();

		neighbors.addAll(goLeft(grid.x, 0, grid.y, grid2, grid));
		neighbors.addAll(goUp(grid.y, n, grid.x, grid2, grid));
		neighbors.addAll(goRight(grid.x, n, grid.y, grid2, grid));
		neighbors.addAll(goDown(grid.y, 0, grid.x, grid2, grid));

		return neighbors;
	}

	private List<Grid> goRight(int sPoint, int endPoint, int fPoint, char[][] grid2, Grid grid) {
		List<Grid> neighbors = new ArrayList<Grid>();
		for (int i = sPoint + 1; i < endPoint; i++) {
			Grid newGrid = new Grid(i, fPoint);
			if (grid2[newGrid.x][newGrid.y] == 'X')
				break;
			grid2[i][fPoint] = 'X';
			neighbors.add(newGrid);
		}
		return neighbors;
	}

	private List<Grid> goLeft(int sPoint, int endPoint, int fPoint, char[][] grid2, Grid grid) {
		List<Grid> neighbors = new ArrayList<Grid>();
		for (int i = sPoint - 1; i >= 0; i--) {
			Grid newGrid = new Grid(i, fPoint);
			if (grid2[newGrid.x][newGrid.y] == 'X')
				break;
			grid2[i][fPoint] = 'X';
			neighbors.add(newGrid);
		}
		return neighbors;
	}

	private List<Grid> goUp(int sPoint, int endPoint, int fPoint, char[][] grid2, Grid grid) {
		List<Grid> neighbors = new ArrayList<Grid>();
		for (int i = sPoint + 1; i < endPoint; i++) {
			Grid newGrid = new Grid(fPoint, i);
			if (grid2[newGrid.x][newGrid.y] == 'X')
				break;
			grid2[fPoint][i] = 'X';
			neighbors.add(newGrid);
		}
		return neighbors;
	}

	private List<Grid> goDown(int sPoint, int endPoint, int fPoint, char[][] grid2, Grid grid) {
		List<Grid> neighbors = new ArrayList<Grid>();
		for (int i = sPoint - 1; i >= 0; i--) {
			Grid newGrid = new Grid(fPoint, i);
			if (grid2[newGrid.x][newGrid.y] == 'X')
				break;
			grid2[fPoint][i] = 'X';
			neighbors.add(newGrid);
		}
		return neighbors;
	}
}

class Grid {
	int x;
	int y;
	boolean visited;
	int length;

	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
		this.visited = false;
		this.length = 0;
	}

	public void visit() {
		this.visited = true;
	}

	public boolean isVisited() {
		return visited;
	}
	
	public void setLength(int cost) {
		length = cost;
	}

	public int getLength() {
		return length;
	}

	public String getCell(){
		return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
	}

	@Override
	public String toString() {
		return "Grid [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
