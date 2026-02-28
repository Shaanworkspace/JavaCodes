package Collections.Generics.MethodGenerics;

import java.sql.SQLOutput;

public class Printer {
	public <T> void print(T data){
		System.out.println(data);
		System.out.println(((Object) data)); // Object is the pure value
		System.out.println(((Object) data).getClass()); // --> " class java.lang.Integer " OR " class java.lang.String "
		System.out.println(((Object) data).getClass().getName()); // --> " java.lang.Integer " OR "java.lang.String"
		System.out.println(data.getClass().getSimpleName()); //-> Double

		System.out.println(data.getClass().getName()); //->> java.lang.Double
		System.out.println("+++++====================================================+++++++");
	}

	public static void main(String[] args) {

		Printer p = new Printer();

		p.print(100);          // Integer


		p.print("Java");       // String
		p.print(12.5);         // Double
	}
}
