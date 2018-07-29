
public class Card{
	//variables
	private String suit;
	private int suitVal;
	private int rank;
	private String symbol;
	
	//constructor
	public Card(String s, int r){
		this.suit=s;
		assignSuitVal();
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
	
	public void assignSuitVal() {
		if(this.suit.startsWith("S")||this.suit.startsWith("s")) {
			this.suitVal=1;
		} else if(this.suit.startsWith("H")||this.suit.startsWith("h")) {
			this.suitVal=2;
		} else if(this.suit.startsWith("C")||this.suit.startsWith("c")) {
			this.suitVal=3;
		} else if(this.suit.startsWith("D")||this.suit.startsWith("d")) {
			this.suitVal=4;
		} else {
			System.out.println("This is not a valid card suit");
		}
		
		
		
	}

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

	public int getSuitVal() {
		return suitVal;
	}
	
	
	
	
} //end class
