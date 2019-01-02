package algorithm.unionfind.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import algoriths.helpers.Helpers;

//BEFORE LECTURE
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
	protected List<int[]> mainList;
	
	public UnionFind(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.total = rows*columns;
		this.mainList = new ArrayList<int[]>();
		
		System.out.println("ROWS: "+rows+" COLS: "+columns);
		
		this.askQuestion();
	}
	
	
	public int getListIndex(int n) {
		int doesNotExist = -1;
		for(int i=0; i < this.mainList.size(); i++) {
			if(this.mainList.get(i) != null) {
				for(int j=0; j<this.mainList.get(i).length; i++) {
					if(this.mainList.get(i)[j] == n) {
						return i;
					}
				}
			}
		}
		return doesNotExist;
	}
	
	public void askQuestion() {
		
		Helpers helpers = new Helpers();
		Map q = helpers.provideQuestions();
		String choice = (String) q.get("choice");
		int n1 = (Integer) q.get("n1");
		int n2 = (Integer) q.get("n2");
		
		if(choice.equals("Union")) {
			new Union(this.rows,this.columns, n1, n2);
		}
		else if(choice.equals("Connection")) {
			new Connection(this.rows,this.columns, n1, n2);
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
