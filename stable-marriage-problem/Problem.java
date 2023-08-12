package exercise_2;
/*
 * 						--------------------------------------
 * 									Rayane Adam
 * 									202100578
 * 									Assignment 1 :)
 * 							
 * 						---------------------------------------
 * The stable marriage problem: implemented using a queue
 * The logic:
 * 		case 1 if man is engaged-->pass to the other man
 * 		case 2 if man is single and wants to be engaged
 * 			a if woman he likes is not engaged-->marry each other
 * 			b if woman he likes is engaged
 * 				i if his preferred woman does not want him--> dequeue her from list and try next woman
 * 				ii if his preferred woman would rather take him and break engagement--> change all status
 */
public class Problem {
	private Queue M;
	private Queue W;

	public Queue getM() {
		return M;
	}

	public void setM(Queue m) {
		M = m;
	}

	public Queue getW() {
		return W;
	}

	public void setW(Queue w) {
		W = w;
	}

	public Problem() {
		//initialization
		//a, b and c: men
		//e, f and g: women
		M=new Queue();W=new Queue();
		char[] a= {'d','e','f'};
		char[] b= {'e','d','f'};
		char[] c= {'d','e','f'};
		char[] d= {'c','a','b'};
		char[] e= {'b','a','c'};
		char[] f= {'a','b','c'};
		Queue pref_a=new Queue();
		Queue pref_b=new Queue();
		Queue pref_c=new Queue();
		Queue pref_d=new Queue();
		Queue pref_e=new Queue();
		Queue pref_f=new Queue();
		pref_a.enqueue(a);
		pref_b.enqueue(b);
		pref_c.enqueue(c);
		pref_d.enqueue(d);
		pref_e.enqueue(e);
		pref_f.enqueue(f);
		M.enqueue('a',pref_a);
		M.enqueue('b',pref_b);
		M.enqueue('c',pref_c);
		W.enqueue('d',pref_d);
		W.enqueue('e',pref_e);
		W.enqueue('f',pref_f);
	}
	
	public void print() {
		System.out.println(M);
		System.out.println(W);
	}
	
	
	public void solve() {
		Node current_man=M.getHeader();
		
		Node w=current_man.getPref_list().dequeue();//dequeue the first woman on the preference list to propose
		//this way if she rejects him, he never proposes back since she's no longer on the list
		Node pref_woman=W.find(w.getName());
		char m=pref_woman.getMarried_to();
		Node husband_opp=M.find(m);
		
		char last_engaged='-';
		//now the loop
		while (!M.everyoneMarried())
		{
			//my current state
			
			System.out.println("\n\t---------\n");
			//current data:
			System.out.println("my man to be groom is "+current_man.toString()+"\nhis preferred woman is "+pref_woman.toString());
			if (husband_opp!=null) System.out.println("her husband "+husband_opp.toString());
			
			//case 1 if man is engaged-->pass to the other man
			if (current_man.isEngaged())
			{
				
				//not marry- already married :p
				current_man=current_man.getNext();
				pref_woman=W.find(w.getName());
				m=pref_woman.getMarried_to();
				husband_opp=M.find(m);
				Node save=M.dequeue();
				save.setNext(null);
				M.enqueue(save);
				System.out.println(M);
				
			}
			//case 2 if man is single and wants to be engaged
			//case 2-a if woman he likes is not engaged-->marry each other
			else if(!pref_woman.isEngaged()) {
				//marry
				
				current_man.setMarried_to(pref_woman.getName());
				pref_woman.setMarried_to(current_man.getName());
				last_engaged=current_man.getName();//keeps track of the last engagement
				
				System.out.println(last_engaged+" just married!\n");
				
				
				current_man=current_man.getNext();
				
				
				Node save=M.dequeue();
				save.setNext(null);
				M.enqueue(save);
				
				w=current_man.getPref_list().dequeue();
				pref_woman=W.find(w.getName());
				m=pref_woman.getMarried_to();
				husband_opp=M.find(m);
				
			}
			//case 2-b is woman he likes is engaged
			//case 2-b-i if his preferred woman does not want him--> dequeue her from list and try next woman
			else if(pref_woman.isEngaged()&& pref_woman.loveSpouse(husband_opp,current_man))
			{
				//not marry
				System.out.println(w.getName()+" loves her husband :(");
				w=current_man.getPref_list().dequeue();
				pref_woman=W.find(w.getName());
				m=pref_woman.getMarried_to();
				husband_opp=M.find(m);
				//loop again, data is changed
				
			}
			//case 2-b-ii if his preferred woman would rather take him and break engagement--> change all status
			else {
				//marry :D
				System.out.println("hates her husband leaves him :D");
				husband_opp.setMarried_to('-');
				current_man.setMarried_to(pref_woman.getName());
				pref_woman.setMarried_to(current_man.getName());
				last_engaged=current_man.getName();//keeps track of the last engagement
				
				current_man=current_man.getNext();
				
				Node save=M.dequeue();
				save.setNext(null);
				M.enqueue(save);
				
				System.out.println(M);
				
				
				w=current_man.getPref_list().dequeue();
				pref_woman=W.find(w.getName());
				m=pref_woman.getMarried_to();
				husband_opp=M.find(m);
				
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		Problem p=new Problem();
		p.solve();
		p.print();
	}
}
