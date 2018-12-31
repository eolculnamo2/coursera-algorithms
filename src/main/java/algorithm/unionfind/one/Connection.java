package algorithm.unionfind.one;

public class Connection extends UnionFind{

	public Connection(int rows, int columns, int n1, int n2) {
		super(rows, columns);
		this.isConnected(n1, n2);
	}
	
	public void isConnected(int n1, int n2) {
		//if Indexes match, it is connected.
		int indexList1 = this.getListIndex(n1);
		int indexList2 = this.getListIndex(n2);
		
		if(indexList1 == indexList2) {
			System.out.println("Connected");
		} else {
			System.out.println("Not Connected");
		}
	}

}
