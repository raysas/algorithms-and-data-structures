package Ex1;

public class LL {
	
	private Node header;
	
	public LL() {
		header=null;
	}

	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}

	public void add(char c) {
		Node n=new Node(c);
		if (header==null) {
			header=n;
		}
		else {
			Node current=header;
			while (current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(n);
		}
	}
	

	public boolean find(char c) {
		if (header==null) return false;
		Node n=header;
		while (n!=null) {
			if (n.getInfo()==c)
				return true;
			n=n.getNext();
		}
		return false;
	}
	
	public String toString() {
		String s="";
		Node n=header;
		while (n!=null) {
			s+=n.getInfo()+"\t";
			n=n.getNext();
		}
		return s;
	}
}
