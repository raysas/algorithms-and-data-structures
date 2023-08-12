package exercise_2;
/*
 * 						--------------------------------------
 * 									Rayane Adam
 * 									202100578
 * 									Assignment 1 :)
 * 							
 * 						---------------------------------------
 * The stable marriage problem: implemented using a queue
 * the queue has several methods that help with the problem like:
 * 		overloaded enqueues for several types of enqueue (one for initialization, one that help in the omne for initialization,  one for pref list queue and one for enqueuing a no longer engaged man)
 * 		find that returns the node with all the attributes that belong to one name in a preference list (nodes in pref list queue do not hold all attributes, because changing one will require changing everything)
 * 		findRank to find the # of a preference of a man or woman for a particular woman or man respectively
 * 		everyoneMarried checks if there's any single men or women
 * 		that's it for the unusual queue methods :)
 * 		
 */

public class Queue {

	private Node header ;
	
	public Queue() {
		//initialize 
		header=null;
	}

	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}
	
	//enqueue takes O(n)
	public void enqueue(char c) {
		//simple enqueue for preference list
		
		Node n=new Node(c);
		if (header==null) {
			header=n;
		}
		else {
			Node current=header;
			while (current.getNext()!=null)
				current=current.getNext();
			current.setNext(n);
		}
	}
	public void enqueue(Node n) {
		if (header==null) {
			header=n;
		}
		else {
			Node current=header;
			while (current.getNext()!=null)
				current=current.getNext();
			current.setNext(n);
		}
	}
	public void enqueue(char c,Queue q) {
		Node n=new Node (c,q);
		//System.out.println(n);
		enqueue(n);
	}
	public void enqueue(char[] pref) {
		//to enqueue in pref list
		for (char person:pref) {
			enqueue(person);
		}
	}
	public Node dequeue() {
		//O(1)
		Node save=header;
		header=header.getNext();
		return save;
	}
		
	
	public Node find(char c) {
		Node current=header;
		if (header==null)return null;
		else if (c=='-')
			return null;
		else {
			while (current!=null) {
				if (current.getName()==c) {
					return current;
				}
				current=current.getNext();
			}
			return null;
		}
	}
	public int findRank(char c) {
		int i=1;
		Node current=header;
		if (header==null)return 0;
		else {
			while (current.getNext()!=null) {
				if (current.getName()==c)
					return i;
				current=current.getNext();
				i+=1;
			}
			return 99;
		}
	
	}
	
	public boolean everyoneMarried() {
		//takes O(n)
		Node current=header;
		while(current!=null) {
			if (current.getMarried_to()=='-')
				return false;
			current=current.getNext();
		}
		return true;
	}
	
	public String toString() {
		//O(n)
		String s="";
		Node current=header;
		while (current!=null) {
			s+=current.toString()+"\n";
			current=current.getNext();
			//System.out.println(s);
		}
		return s;
	}
	
}
