package algoriths.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Helpers {
	public int[] concatIntArr(int[] arr1, int[] arr2) {
		int[] answer = new int[arr1.length+arr2.length];
		
		for(int i=0; i < arr1.length; i++) {
			answer[i] = arr1[i];
		}
		
		for(int i=arr1.length; i < arr2.length+arr1.length; i++) {
			answer[i] = arr2[i-arr1.length];
		}
		
		return answer;
	}
	
	public Map provideQuestions() {
		Map qMap = new HashMap();
		String choice;
		int n1;
		int n2;
		
		System.out.println("Union or Connection?");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.next();
		
		System.out.println("Enter Number 1");
		n1 = scanner.nextInt();
		System.out.println("Enter Number 2");
		n2 = scanner.nextInt();
		
		qMap.put("n1", n1);
		qMap.put("n2", n2);
		qMap.put("choice", choice);
		return qMap;
		
	}
}
