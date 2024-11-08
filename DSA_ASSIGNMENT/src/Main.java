import java.util.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {

		PhoneList ph=new PhoneList();
		ph.AddContact("Alice","123-456-7890");
		ph.AddContact("mahmoud","144-456-7890");
		ph.AddContact("malak","155-456-7890");
	   ph.deleteContact("mahmoud");
       ph.displayList();



	}
}