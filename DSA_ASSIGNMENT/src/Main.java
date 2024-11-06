import java.util.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {

		PhoneList ph=new PhoneList();
		ph.AddContact("Alice","123-456-7890");
       ph.displayList();
	   ph.deleteContact("Alice");
       ph.displayList();


	}
}