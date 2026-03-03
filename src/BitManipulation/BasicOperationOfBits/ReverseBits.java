package BitManipulation.BasicOperationOfBits;

public class ReverseBits {


	public int reverseBits(int n){
		int res = 0;

		while(n > 0){
			res = res << 1;      // make space
			res |= (n & 1);      // add last bit of n
			n >>= 1;             // move to next bit
		}

		return res;
	}
	void main(){
		PrintBits p = new PrintBits();
		int a = 16;
		p.printBits(a);
		System.out.println(reverseBits(a));
	}

}
