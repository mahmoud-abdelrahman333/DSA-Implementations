 class queue {
	 class node{
		int item;
		node next;
	};
	node first, last;
	int length;
	public queue(){
		System.out.println("happy queue");
		first=last=null;
		length=0;
	}

	void enqeue(int element){
		node newPtr= new node();
		if(isEmpty()){
			first=last=newPtr;
			newPtr.next=null;
			newPtr.item=element;
		}
		else {
			last.next=newPtr;
			newPtr.item=element;
			newPtr.next=null;
			last=newPtr;
		}
		length++;
	}
	void pop(){
		node remove=first;
		first=first.next;
		 remove=null;
		length--;
	}

	void print(){
		node cur=first;
		while(cur!=null){
			System.out.println(cur.item);
			cur=cur.next;
		}
		System.out.println();
	}
	boolean isEmpty(){
		return length==0;
	}
	int getLength() {
		return length;
	}

};

