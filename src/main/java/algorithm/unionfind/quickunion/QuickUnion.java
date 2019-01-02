package algorithm.unionfind.quickunion;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import algoriths.helpers.Helpers;

//Note: Solved after watching lecture with answer.
//improvements weight the trees;s
public class QuickUnion {
	//Assign shared roots
	int[] data;
	
	QuickUnion() {
		System.out.println("Enter data length");
		Scanner scanner = new Scanner(System.in);
		int dateLength = scanner.nextInt();
		data = new int[dateLength];
		for(int i=0; i<dateLength; i++)  data[i] = i;
		this.askQuestion();
	}
	
	//check root id;
	int findRoot(int i) {
		//Find the root of tree;
		while(i != data[i]) {
			i = data[i];
		}
		return i;
	}
	
	void union(int n1, int n2) {
		int rootIndex1 = findRoot(n1);
		int rootIndex2 = findRoot(n2);
		data[rootIndex1] = rootIndex2;
		
		this.askQuestion();
	}
	
	void connection(int n1, int n2) {
		int rootIndex1 = findRoot(n1);
		int rootIndex2 = findRoot(n2);
		
		if(rootIndex1 == rootIndex2) {
			System.out.println("Connected");
		} else {
			System.out.println("Not connected");
		}
		this.askQuestion();
	}
	
	void askQuestion() {
		
		Helpers helpers = new Helpers();
		Map q = helpers.provideQuestions();
		String choice = (String) q.get("choice");
		int n1 = (Integer) q.get("n1");
		int n2 = (Integer) q.get("n2");
		
		if(choice.equals("Union")) {
			this.union(n1, n2);
		} else if(choice.equals("Connection")) {
			this.connection(n1, n2);
		}
		
	}
	
	public static void main(String[] arg) {
		new QuickUnion();
	}
	
}
