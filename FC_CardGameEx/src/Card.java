
public class Card{
	//variables
	private String suit;
	private int rank;
	private String symbol;
	
	//constructor
	public Card(String s, int r){
		this.suit=s;
		this.rank=r;
		assignSym();				
	} //end constructor
	
	public void assignSym() {
		if(this.rank==1) {
			this.symbol="A";
		} else if(this.rank==11) {
			this.symbol="J";
		} else if(this.rank==12) {
			this.symbol="Q";
		} else if(this.rank==13) {
			this.symbol="K";
		} else {
			this.symbol=Integer.toString(this.rank);
		}
	} //end assignSym

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
		assignSym();
	}

	public String getSymbol() {
		return symbol;
	}

	//public void setSymbol(String symbol) {
	//	this.symbol = symbol;
	//}
	
	
	
	
} //end class
