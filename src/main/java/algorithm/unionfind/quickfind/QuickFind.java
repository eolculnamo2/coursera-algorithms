package algorithm.unionfind.quickfind;

import java.util.Scanner;

public class QuickFind {
	//will add protected if subclass is needed.
	
	/*Example:
	* 0 1 2 3 4 5
	* 0 1 0 3 4 3
	* 0 and 2 are connected; 3 and 5 connected
	*/
	 int[] data;
	
	 QuickFind() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter length of data.");
		int dataLength = scanner.nextInt();
		
		//load data array
		data = new int[dataLength];
		for(int i=0; i < dataLength; i++) {
			data[i] = i;
		}
		this.askQuestion();
	}
	
	void union(int n1, int n2) {
		int oldN = data[n1];

		if(data[n1] != data[n2]) {
			for(int i = 0; i < data.length; i++) {
				if(data[i] == oldN) {
					data[i] = n2;
				}
			}
		} else {
			System.out.println("Numbers are already connected.");
		}
		this.askQuestion();
	}
	
	void connection(int n1, int n2) {
		if(data[n1] == data[n2]) {
			System.out.println("Connected");
		} else {
			System.out.println("Not connected");
		}
		this.askQuestion();
	}
	
	void askQuestion() {
		
		System.out.println("Union or Connection?");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		
		System.out.println("Enter Number 1");
		int n1 = scanner.nextInt();
		System.out.println("Enter Number 2");
		int n2 = scanner.nextInt();
		
		if(choice.equals("Union")) {
			this.union(n1, n2);
		} else if(choice.equals("Connection")) {
			this.connection(n1, n2);
		}
		
	}
	
	public static void main (String[] arg) {
		new QuickFind();
	}
}
