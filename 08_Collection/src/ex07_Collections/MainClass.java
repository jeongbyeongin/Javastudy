package ex07_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainClass {

	public static void printList(List list) {
		
		/*
			int lastIndex = list.size() - 1;
					 
			for(int i = 0; i < lastIndex; i++) {
			system.out.print(list.get(i)) + "→");
			}
			system.out.println(list.get(lastIndex));
		 */
		
		
		
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			Integer number = itr.next();
			System.out.print(number);
			if(number != list.get(list.size()-1)) {
				System.out.print("→");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		List<Integer> list = Arrays.asList(5, 2, 3, 1, 4);
		
		printList(list); // 5 → 2 → 3 → 1 → 4

		Collections.sort(list); // 오름차순 정렬
		
		printList(list);  // 1 → 2 → 3 → 4 → 5
		
		int idx = Collections.binarySearch(list, 4);  // 이진 검색(반드시 정렬이 되어 있어야 한다.) 못찾으면 -값이 나옴
		if(idx >= 0) {
			System.out.println("찾았다.");
		} else {
			System.out.println("못 찾았다.");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
