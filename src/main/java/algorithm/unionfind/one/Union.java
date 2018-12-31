package algorithm.unionfind.one;

import algoriths.helpers.Helpers;

public class Union extends UnionFind {
	public Union(int rows, int columns, int n1, int n2) {
		super(rows, columns);
		this.union(n1, n2);
	}

	public int[] getList(int n) {
		int[] doesNotExist = {-1};
		for(int i=0; i < this.mainList.size(); i++) {
			if(this.mainList.get(i) != null) {
				for(int j=0; j < this.mainList.get(i).length; j++) {
					if(this.mainList.get(i)[j] == n) {
						return this.mainList.get(i);
					}
				}
			}
		}
		return doesNotExist;
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

	public void union(int n1, int n2) {
		
		if(this.isBordered(n1, n2)) {
			int[] list1 = this.getList(n1);
			int[] list2 = this.getList(n2);
			
			if(list1[0] == -1 && list2[0] == -1) {
				int[] newList = { n1, n2 };
				
				this.mainList.add(newList);
			} else if(list1[0] == -1) {
				Helpers helpers = new Helpers();
				int[] listForm = { n1 };
				int[] combinedList = helpers.concatIntArr(list2, listForm);
				int listIndex = this.getListIndex(n2);
				
				this.mainList.add(combinedList);
				this.mainList.remove(listIndex);
			} else if(list2[0] == -1) {
				Helpers helpers = new Helpers();
				int[] listForm = { n2 };
				int[] combinedList = helpers.concatIntArr(list1, listForm);
				int listIndex = this.getListIndex(n1);
				
				this.mainList.add(combinedList);
				this.mainList.remove(listIndex);
				
			} else {
				Helpers helpers = new Helpers();
				int[] combinedList = helpers.concatIntArr(list1, list2);
				int listIndex1 = this.getListIndex(n1);
				int listIndex2 = this.getListIndex(n2);
				
				this.mainList.add(combinedList);
				this.mainList.remove(listIndex1);
				
				if(listIndex1 < listIndex2) {
					listIndex2--;
				}
				
				this.mainList.remove(listIndex2);
			}
			System.out.println("DO");
			
		}
		else {
			System.out.println("DO NOT DO");
		}
		
		this.askQuestion();
	}
}
