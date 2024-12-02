import java.util.*;
import java.lang.*;


public class Main {


	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);



		HashTable h=new HashTable();

		int option;
		do {
			String name,phone;
			System.out.println("Enter 1 to add contact:");
			System.out.println("Enter 2 to delete contact:");
			System.out.println("Enter 3 to update contact:");
			System.out.println("Enter 4 to diplay contacts:");
			System.out.println("Enter 5 to search contact:");
			System.out.println("Enter 6 to exit:");
			option=in.nextInt();
			if(option>6 || option<1){
				System.out.println("Invalid Option!");
				continue;
			}
			else if(option==1){
				System.out.println("Enter the name and th phone number:");
				name=in.next();
				phone=in.next();
				h.AddContact(name,phone);
			}
			else if(option==2){
				System.out.println("Enter the name:");
				name=in.next();
				h.DeleteContact(name);
			}
			else if(option==3){
				System.out.println("Enter the name and the new phone number:");
				name=in.next();
				phone=in.next();
				h.Update(name,phone);
			}
			else if(option==4){
				h.display();
			}
			else{
				System.out.println("Enter the name of the contact:");
				name=in.next();
				System.out.println(h.Search(name));
			}
			System.out.println("*****************************");

		}while (option!=6);






























	}

}







