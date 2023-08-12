package Ex1;

public class Stack {
	
	private char[] s;
	private int count;

	public Stack(int l) {
		//the stack's size is set before since the maximum it can hold is all the vertices
		s=new char[l];
		count=0;
	}
	
	public void push(char c) {
		if (count<s.length) {
			s[count]=c;
			count++;
		}
	}
	public char pop() {
		if (count<=0) {
			return ' ';
		}
		count--;
		char a=s[count];
		s[count]=' ';
		return a;
	}
	public char peek() {
		if (count<=0) {
			return ' ';
		}
		char a=s[count-1];
		return a;
	}
	public boolean isEmpty() {
		return count==0;
	}
}
