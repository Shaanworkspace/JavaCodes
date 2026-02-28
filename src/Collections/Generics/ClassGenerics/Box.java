package Collections.Generics.ClassGenerics;

public class Box<T> {
	T data;

	void setData(T data) {
		this.data = data;
	}

	T getData() {
		return data;
	}

	public static void main(String[] args) {
		Box<Integer> intBox = new Box<>();
		intBox.setData(10);
		System.out.println(intBox.getData());

		Box<String> strBox = new Box<>();
		strBox.setData("Hello");
		System.out.println(strBox.getData());
	}
}
