package codefun;

import java.util.ArrayList;
import java.util.List;

public class Worksheet {

	private static int totalPaths = 0;
	private static List<List<Point>> arrayOfPaths = new ArrayList<List<Point>>();
	
	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		List<Point> list = new ArrayList<Point>();
		numPossiblePaths(arr, 2, 0, 0, list);
		for(List<Point> list1 : arrayOfPaths) {
			System.out.println(list1.toString());
		}
	}
	
	private static void numPossiblePaths(int[][] arr, int N, int i, int j, List<Point> list) {
		// wrong coordinates
		if(i >= N || j >= N) return;
		
		Point point = new Point(i, j);
		list.add(point);
		if(i== N-1 && j == N-1) {
			totalPaths++;
			List<Point> list2 = new ArrayList<Point>();
			list2.addAll(list);
			arrayOfPaths.add(list2);
			list.remove(point);
			return;
		}
		
		numPossiblePaths(arr, N, i, j+1, list);
		numPossiblePaths(arr, N, i+1, j, list);
		list.remove(point);
	}
	
	private static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	//1,2,3,4,5,6  7,8,9,10,11,12
	
	
}
