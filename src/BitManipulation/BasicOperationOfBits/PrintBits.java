package BitManipulation.BasicOperationOfBits;

public class PrintBits {
	public void printBits(int a ){
		int temp = a ;
		System.out.print("Bits of "+a+": ");
		StringBuilder bits  = new StringBuilder();
		while(temp>0){
			bits.append(temp&1);
			temp>>=1;
		}
		System.out.print(bits.reverse().toString());
		System.out.println();
	}
}
