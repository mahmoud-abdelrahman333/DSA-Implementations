class stack{

	class Node{
		int item;
		Node next;
	};
	Node top;
 public stack(){
		top=null;
	}
	void push(int newItem){
		Node newItemPtr= new Node();
		if(newItemPtr==null)
			System.out.println("stack can not allocate memory");
		newItemPtr.item=newItem;
		newItemPtr.next=top;
		top=newItemPtr;
	}
	boolean isEmpty(){
		return top==null;
	}
	void pop(){
		Node remove=top;
		top=top.next;
		remove=null;
	}
	void getTop(){
		System.out.println(top.item);
	};
	void print(){
		Node cur=new Node();
		cur=top;
		while(cur!=null){
			System.out.print(cur.item+" ");
			cur=cur.next;
		}
		System.out.println();
	}
};
