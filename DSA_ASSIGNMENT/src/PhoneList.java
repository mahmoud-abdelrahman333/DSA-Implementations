public class PhoneList {
	 class Node {
		String name;
		String PhoneNumber;
		Node next;
		public Node(String name,String PhoneNumber){
			this.name=name;
			this.PhoneNumber=PhoneNumber;
		}
	}
	Node first;
	Node last;
	public PhoneList(){
		this.first=this.last=null;
	}
	public void AddContact(String name,String PhoneNumber){
		Node NewNode=new Node(name,PhoneNumber);
		if(first==null){
			first=last=NewNode;
		}
		else {
			last.next=NewNode;
			last=NewNode;
			last.next=null;
		}
	}
	public void displayList(){
		if(first==null){
			System.out.println("The List is Empty.");
			return;
		}
		Node Curr=first;
		while(Curr!=null){
			System.out.println("Name: "+Curr.name+' '+"Phone Number: "+Curr.PhoneNumber);
			Curr=Curr.next;
		}
	}

	public void searchContact(String name){
		if(first==null){
			System.out.println("The List is Empty.");
			return;
		}
		Node Curr=first;
		while(Curr!=null){
			if(Curr.name.equals(name)){
				System.out.println("Contact Found");
				System.out.println("Name: "+Curr.name+' '+"Phone Number:"+Curr.PhoneNumber);
				return;
			}
			Curr=Curr.next;
		}
		System.out.println(name+" Contact's Not Found");
	}

	public boolean ContactExists(String name){
		Node Curr=first;
		while(Curr!=null){
			if(Curr.name.equals(name)){
				return true;
			}
			Curr=Curr.next;
		}
		return false;
	}

	public void deleteContact(String name){
		if(first==null){
			System.out.println("The List is Empty.");
			return;
		}
		if(ContactExists(name)){
			Node Curr = first;
			if (Curr.name.equals(name)) {
				if (Curr == last){
					first = last = null;
				} else {
					first = first.next;
				}
			}
			else {
				while (Curr.next != null && !Curr.next.name.equals(name)) {
					Curr = Curr.next;
				}

				if (Curr.next == null) {
					System.out.println(name + " Contact's not found");
				} else {
					if (Curr.next == last) {
						last = Curr;
					}
					Curr.next = Curr.next.next;
				}
			}
			}
		}






}
