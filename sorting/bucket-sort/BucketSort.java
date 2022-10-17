package lab4;

public class BucketSort {

	private LL[] buckets;
	private int size;
	
	public BucketSort(double[] a) {
		size=a.length;
		//instanciating the array of linkedlists
		buckets=new LL[10];
		for (double i:a) {
			//takes linear time O(n)
			buckets[(int) (i/0.1)].add(i);
		}
	}
	
	public double[] sort() {
		double [] a=new double[size];
	}
	
}

class Node{
	private double info;
	private Node next;
	public double getInfo() {
		return info;
	}
	public void setInfo(double info) {
		this.info = info;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(double info) {
		this.info = info;
	}
	
}

class LL{
	private Node header;
	private int size;

	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}
	
	public void sort() {
		if (header==null || header.getNext()==null) return;
		Node current=header.getNext();
		
		
	}
	
	public Node getElement(int i) {
		Node current=header;
		int count=0;
		while(current!=null && count<i) {
			current=current.getNext();
			count++;
		}
		return current;
	}
	
	public void add(double d) {
		if (header==null)
		{
			header =new Node(d);
			size++;
		}
		else {
			Node current=header;
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(new Node(d));
			size++;
		}
	}
}
