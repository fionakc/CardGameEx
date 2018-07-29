import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class test {

	public static void main(String[] args) {
		
		List<Card> testList=new ArrayList<>();
		//also need AceLow object
		AceLow aceLow=new AceLow();
		
		
		//create some cards
		Card c1=new Card("Spade", 3);
		Card c2=new Card("Diamond",5);
		Card c3=new Card("Diamond",1);
		Card c4=new Card("Heart",11);
		Card c5=new Card("Club",5);
		Card c6=new Card("Spade",13);
		
		//add cards into arraylist
		testList.add(c1);
		testList.add(c2);
		testList.add(c3);
		testList.add(c4);
		testList.add(c5);
		testList.add(c6);
		
		System.out.println("TestList");
		for(int i=0;i<testList.size();i++) {
			System.out.println(testList.get(i).getRank());
		}
		
		Collections.sort(testList,aceLow);
		
		System.out.println("TestList");
		for(int i=0;i<testList.size();i++) {
			System.out.println(testList.get(i).getRank());
		}
		
	}
	
	
	
	//List<MyType> myList = new ArrayList<>();
	//Wagon<String> wa=new Wagon<>("a",wb);
}
