package Ex2;

public class Queue {

	private Node header;
	
	public Queue() {
		header=null;
	}
	
	public void enqueue(char c) {
		Node n=new Node(c);
		n.setNext(header);
		header=n;
	}
	
	public char dequeue() {
		if (header==null)
			return ' ';
		else if(header.getNext()==null) {
			char c=header.getInfo();
			header=null;
			return c;
		}
		Node current=header;
		Node prev=null;
		while (current.getNext()!=null) {
			prev=current;
			current=current.getNext();
		}
		prev.setNext(null);
		return current.getInfo();
		
	}
	
	public boolean isEmpty() {
		return header==null;
	}
}
