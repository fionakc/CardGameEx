import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class test {

	public static void main(String[] args) {
		
		List<Card> testList=new ArrayList<>();
		//also need AceLow object
		AceLow aceLow=new AceLow();
		//AceHigh aceHigh=new AceHigh();
		//SuitRank suitRank=new SuitRank();
		
		
		//create some cards
		Card c1=new Card("Spade", 3);
		Card c2=new Card("Diamond",5);
		Card c3=new Card("Diamond",1);
		Card c4=new Card("Heart",11);
		Card c5=new Card("Club",5);
		Card c6=new Card("Spade",13);
		
		//add cards into arraylist
//		testList.add(c1);
//		testList.add(c2);
//		testList.add(c3);
//		testList.add(c4);
//		testList.add(c5);
//		testList.add(c6);
		
//		System.out.println("TestList");
//		for(int i=0;i<testList.size();i++) {
//			System.out.println(testList.get(i).getRank());
//		}
		
		//Collections.sort(testList,aceLow);
		//Collections.sort(testList, aceHigh);
		//Collections.sort(testList, suitRank);
		
		
		
//		for(int i=0;i<20;i++) {
//			Card cTemp=new Card();
//			System.out.println(cTemp.getRank());
//			testList.add(cTemp);
//		}
		
//		Card cTemp1=new Card();
//		System.out.println(cTemp1.getRank());
//		testList.add(cTemp1);
//		Card cTemp2=new Card();
//		System.out.println(cTemp2.getRank());
//		testList.add(cTemp2);
//		Card cTemp3=new Card();
//		System.out.println(cTemp3.getRank());
//		testList.add(cTemp3);
//		Card cTemp4=new Card();
//		System.out.println(cTemp4.getRank());
//		testList.add(cTemp4);
//		
//		
//		System.out.println("TestList");
//		for(int i=0;i<testList.size();i++) {
//			System.out.println(testList.get(i).getRank());
//			System.out.println(testList.get(i).getSuit());
//		}
		
//		Blackjack g1=new Blackjack();
//		g1.play();
		
		Poker p1=new Poker();
		p1.play();
		
	} //end main
	
	
	
	//List<MyType> myList = new ArrayList<>();
	//Wagon<String> wa=new Wagon<>("a",wb);
}
