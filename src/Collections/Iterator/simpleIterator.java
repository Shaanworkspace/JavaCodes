package Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class simpleIterator {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);

		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int val = it.next();
			System.out.println(val);
		}


		ListIterator<Integer> integerListIterator = list.listIterator(); //<<-- different method used

		while (integerListIterator.hasPrevious()) {
			System.out.println(integerListIterator.previous());
		}
	}
}
