import java.util.*;

public class AceHigh implements Comparator<Card>{

	public AceHigh() {
		
	}
	
	//Create a class implementing Comparator<Card> that ranks an ace low, 
	//and another that ranks an ace high. Create one that separates cards by suit. 
	//Comparator<T> has one method, int compare(T a, T b), 
	//which returns -1 if a should rank before b, 
	//1 if a should rank after b, and 0 if they are equivalent
	
	/**AbstractList method*/
	public int compare(Card c1, Card c2) {
		int c1Rank=c1.getRank();
		int c2Rank=c2.getRank();
		if(c1Rank==1) {
			return 1;
		} else if(c2Rank==1) {
			return -1;
		} else if(c1Rank<c2Rank) {  //a lower than b
			return -1;
		} else if(c1Rank>c2Rank) { //a higher than b
			return 1;
		} else {		
			return 0; //equal value
		}
	} //end compare
	
	
	/**AbstractList method*/
	public boolean equals(Object obj) {
		return false;
	}
	
}
