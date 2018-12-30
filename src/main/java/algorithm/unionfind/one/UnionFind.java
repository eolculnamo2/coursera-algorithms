package algorithm.unionfind.one;

import java.util.ArrayList;
import java.util.Scanner;

//will take columns and rows
//Rows and columns specified through constructor parameters

//UNION METHOD
//union method will either create a new array or add to an existing one if valid.
//valid is directly up, down, and across between the two points in the grid

//CONNECTION METHOD
//Tests to see if points are connected, directly or indirectly through other points.

/* 3 ROWS; 5 COLS;
 * 01 02 03 04 05
 * 06 07 08 09 10
 * 11 12 13 14 15
 * */
public class UnionFind {
	protected int rows;
	protected int columns;
	protected int total;
	protected ArrayList<int[]> mainList;
	
	public UnionFind(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.total = rows*columns;
		this.mainList = new ArrayList();
		
		System.out.println("ROWS: "+rows+" COLS: "+columns);
		
		this.askQuestion();
	}
	
	public boolean isBordered(int n1, int n2) {
		
		int[] borders = {
				 n1 - this.columns - 1,
				 n1 - this.columns,
				 n1 - this.columns + 1,
				 n1 - 1,
				 n1 + 1,
				 n1 + this.columns - 1,
				 n1 + this.columns,
				 n1 + this.columns + 1
		};
		
		for(int border: borders) {
			if( border == n2) {
				return true;
			}
		}
		
		return false;
	}
	public int[] getList(int n) {
		int[] doesNotExist = {-1};
		for(int i=0; i < mainList.size(); i++) {
			for(int j=0; j<mainList.get(i).length; i++) {
				if(mainList.get(i)[j] == n) {
					return mainList.get(i);
				}
			}
		}
		return doesNotExist;
	}
	public void union(int n1, int n2) {
		
		if(this.isBordered(n1, n2)) {
			//Need to add list 2;
			int[] list = this.getList(n1);
			System.out.println("DO");
			
		}
		else {
			System.out.println("DO NOT DO");
		}
	}
	
	public void askQuestion() {
		System.out.println("Enter 'Union' or 'Connection'");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		
		System.out.println("Enter number 1");
		int n1 = scanner.nextInt();
		System.out.println("Enter number 2");
		int n2 = scanner.nextInt();
		
		if(choice.equals("Union")) {
			this.union(n1,n2);
		}
		
		else if(choice.equals("Connection")) {
			
		}
	}
	
	public static void main( String[] args) {
		System.out.println("Enter Number of Rows");
		Scanner scanner = new Scanner(System.in);
		int enteredRows = scanner.nextInt();
		System.out.println("Enter Number of Columns");
		int enteredCols = scanner.nextInt();
		
		new UnionFind(enteredRows, enteredCols);
	}
	
}