public class HashTable  {

	LinkedList[] arr;
	int size=1009;
	int ListSize=0;

	public HashTable()
	{
		arr=new LinkedList[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new LinkedList();
		}
	}

	public static class Contact
	{
		String name;
		String phone;
		Contact next;
		public Contact(String name, String phone) {
			this.name = name;
			this.phone = phone;
		}
	}


//	Hash function
	private  int calcHash(String key) {
		int l = key.length();
		long hash = 0;

		for (int i = 0; i < l; i++) {
			hash += Character.getNumericValue(key.charAt(i));
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);
		return (int) Math.abs(hash %size);
	}

	// Add Contact
	public void AddContact(String name,String phone){
		int index=calcHash(name);
		arr[index].add(name,phone);
		ListSize++;
	}

	//search
	public String Search(String name)
	{
		if(ListSize==0){
			return "The List is Empty!";
		}
		int index=calcHash(name);
		String phone=arr[index].Search(name);
		if(phone==null){
			return "The Contact Doesn't Exist!";
		}
		return phone;
	}

	//Delete Contact
	public void DeleteContact(String name){
		if(ListSize==0){
			System.out.println("The List is Empty!");
			return;
		}
		int index=calcHash(name);

		//to maintain size of the list
		String Deleted=arr[index].delete(name);
		if(Deleted==null)
		{
			ListSize--;
			System.out.println("Contact Deleted.");
		}
		else {
			System.out.println("Contact not found");
		}
	}

	// update contact number
	public void Update(String name,String NewPhone){
		if(ListSize==0){
			System.out.println("The List is Empty!");
			return;
		}
		int index=calcHash(name);
			Contact Curr=arr[index].head;
			while (Curr!=null){
				if(Curr.name.equals(name)){
					Curr.phone=NewPhone;
					return;
				}
				Curr=Curr.next;
			}

		System.out.println("Contact Doesn't exist");
	}


	//display
	public void display(){
		if(ListSize==0){
			System.out.println("The List is Empty!");
			return;
		}
		for(LinkedList a:arr){
			Contact Curr=a.head;
			while (Curr!=null){
				System.out.println("Name: "+Curr.name+"  Phone: "+Curr.phone);
				Curr=Curr.next;
			}
		}
	}






}
