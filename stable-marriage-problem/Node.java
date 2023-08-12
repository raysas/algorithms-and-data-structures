package exercise_2;

/*
 * 						--------------------------------------
 * 									Rayane Adam
 * 									202100578
 * 									Assignment 1 :)
 * 							
 * 						---------------------------------------
 * The stable marriage problem: implemented using a queue
 * here the node takes several attributes to keep count of preference lists for each node, status and name
 */

public class Node {
	private char name;
	private char married_to;
	private Queue pref_list;
	private Node next;
	
	public Node (char n) {
		//this is for pref list nodes
		name=n;
		married_to='-';
		pref_list=null;
		next=null;
	}
	public Node (char n, Queue q) {
		//this one to initialize my main queue with pref lists
		name=n;
		married_to='-';
		pref_list=q;
		next=null;
	}

	public char getName() {
		return name;
	}
	public Node getNext() {
		return next;
	}
	public char getMarried_to() {
		return married_to;
	}

	public void setMarried_to(char married_to) {
		this.married_to = married_to;
	}

	public Queue getPref_list() {
		return pref_list;
	}

	public void setPref_list(Queue pref_list) {
		this.pref_list = pref_list;
	}

	public void setName(char name) {
		this.name = name;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public boolean isEngaged() {
		return married_to!='-';
	}
	
	public boolean loveSpouse(Node m1,Node m2) {
		//m1 is the enaged one, m2 just proposed
		int spouse_rank=pref_list.findRank(m1.getName());
		int proposed_rank=pref_list.findRank(m2.getName());
		return spouse_rank<proposed_rank;
	}
	public String toString() {
		return name+" is married to "+married_to;
	}
	
}
