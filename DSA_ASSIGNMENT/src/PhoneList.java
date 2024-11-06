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
			first.next=last.next=null;
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
			if(Curr.name==name){
				System.out.println("Contact Found");
				System.out.println("Name: "+Curr.name+' '+"Phone Number:"+Curr.PhoneNumber);
			}
			Curr=Curr.next;
		}
		System.out.println(name+" Contact's Not Found");
	}

	public Boolean ContactExists(String name){
		Node Curr=first;
		while(Curr!=null){
			if(Curr.name==name){
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
			if (Curr.name == name) {
				first=last=null;
			} else {
				while (Curr.next.name != name) {
					Curr = Curr.next;
				}
				Curr.next = Curr.next.next;
			}
		}
		else {
			System.out.println(name+" Contact's not found");
		}
	}





}
