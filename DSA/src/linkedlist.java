class linkedlist
{
	class Node{
		int item;
		Node next;
	};
	Node first,last;
	int length;


	public linkedlist(){
		first=last=null;
		length=0;
	}
	boolean isEmpty(){
		return length==0;
	}
	void insertFirst(int element){
		Node newNode = new Node();
		newNode.item=element;
		if (length == 0) {
			first = last = newNode;
			newNode.next = null;
		} else {
			newNode.next = first;
			first = newNode;
		}
		length++;
	}
	void insertLast(int element){
		Node newNode=new Node();
		newNode.item=element;
		if(length==0){
			first=last=newNode;
			newNode.next=null;
		}
		else {
			last.next=newNode;
			newNode.next=null;
			last=newNode;
		}
		length++;
	}
	void insertAtPos(int pos,int element){
		if(pos<0 || pos>length){
			System.out.println("out of range");
		}
		else {
			Node newNode=new Node();
			newNode.item=element;
			if(pos==0){
				insertFirst(element);
			}
			else if(pos==length){
				insertLast(element);
			}
			else {
				Node cur=first;
				for (int i = 1; i < pos; ++i) {
					cur=cur.next;
				}
				newNode.next=cur.next;
				cur.next=newNode;
				length++;
			}
		}

	}
	void print(){
		Node cur=first;
		while(cur!=null){
			System.out.print(cur.item+" ");
			cur=cur.next;
		}
	}

	void removeFirst() {
		if (length == 0) {
			return;
		} else if (length == 1) {
			last=first=null;
			length--;
		} else {
			Node  cur = first;
			first=first.next;
			cur=null;
			length--;
		}
	}
	void removeLast() {
		if (length == 0) {
			return;
		} else if (length == 1) {
			last=first=null;
			length--;
		} else {
			Node cur=first.next;
			Node prev=first;
			while(cur!=last){
				prev=cur;
				cur=cur.next;
			}
			 cur=null;
			prev.next=null;
			last=prev;
			length--;
		}
	}
	void remove(int element){
		if(isEmpty()) return;
		Node cur, prev;
		if(first.item==element){
			cur=first;
			first=first.next;
			 cur=null;
			length--;
			if(length==0)
				last=null;
		}
		else {
			cur=first.next;
			prev=first;
			while(cur!=null){
				if(cur.item==element) break;
				prev=cur;
				cur=cur.next;
			}
			if(cur==null) {
				System.out.println("not found.");;
			}
			else{
				prev.next=cur.next;
				if(last==cur) last=prev;
				 cur=null;
				length--;
			}
		}

	}
	void reverse(){
		Node prev,cur,next;
		prev=null;
		cur=first;
		next=cur.next;
		while(next!=null){
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		first=prev;
	}
	int search(int element){
		Node cur=first;
		int pos=1;
		while(cur!=null){
			if(cur.item==element){
				return pos;
			}
			cur=cur.next;
			pos++;
		}
		return -1;

	}

	int getLength() {
		return length;
	}
};
