package Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class removeByIterator {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(3);

		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int val = it.next();
			System.out.println("CurrVal : "+val);
			if(val<10){
				it.remove();
				System.out.println("Deleting: "+val);
			}
			System.out.println(list);

		}

		System.out.println("Final List : "+list);
	}
}
