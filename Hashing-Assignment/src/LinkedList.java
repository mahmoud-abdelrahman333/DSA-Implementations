public class LinkedList {

	HashTable.Contact head,tail;

	public LinkedList(){
		head=tail=null;
	}

	public boolean Empty(){
		return head==null;
	}

	public void add(String Key,String Value){
		HashTable.Contact c=new HashTable.Contact(Key,Value);
		if(head==null){
			head=tail=c;
		}
		else {
			tail.next=c;
			tail=c;
		}
	}
	public String delete(String key) {
		if (Empty()) {
			return "NotFound";

		}

		if (head.name.equals(key)) {
			head = head.next;
			if (head == null){
				tail = null;
			}
			return null;
		}

		HashTable.Contact curr = head;
		while (curr.next != null && !curr.next.name.equals(key)) {
			curr = curr.next;
		}

		if (curr.next == null) {
			return "NotFound";
		}

		if (curr.next == tail)
		{
			tail = curr;
		}
		curr.next = curr.next.next;
		return null;
	}


	public String Search(String Key){
          if (Empty()){
			  return "The List Is Empty!";
		  }
		HashTable.Contact Curr=head;
		while(Curr!=null){
			if(Curr.name.equals(Key)){
				return Curr.phone;
			}
			Curr=Curr.next;
		}

		return "Contact not found!";
	}










}
