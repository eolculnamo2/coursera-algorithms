package algoriths.helpers;

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
}
