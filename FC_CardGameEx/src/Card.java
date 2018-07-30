

public class Card{
	//variables
	private String suit;
	private int suitVal;
	private int rank;
	private String symbol;
	
	//constructor
	public Card(String s, int r){
		this.suit=s;
		assignValFromSuit();
		this.rank=r;
		assignSym();				
	} //end constructor
	
	public Card() {
		double s=Math.random()*4;
		//this.suitVal=Math.random()*4;
		assignSuitFromNum(s);
		assignValFromSuit();
		double r=Math.random()*12;
		assignRankFromNum(r);
		//this.rank=1+(int)Math.random()*12;
		assignSym();
	}
	
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
	
	public void assignValFromSuit() {
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
	
	public void assignSuitFromNum(double s) {
		if(s<1) {
			this.suit="Spade";
		} else if(s<2) {
			this.suit="Heart";
		} else if(s<3) {
			this.suit="Club";
		} else {
			this.suit="Diamond";
		}
	}
	
	public void assignRankFromNum(double r) {
		if(r<1) {
			this.rank=1;
		} else if(r<2) {
			this.rank=2;
		} else if(r<3) {
			this.rank=3;
		} else if(r<4) {
			this.rank=4;
		} else if(r<5) {
			this.rank=5;
		} else if(r<6) {
			this.rank=6;
		} else if(r<7) {
			this.rank=7;
		} else if(r<8) {
			this.rank=8;
		} else if(r<9) {
			this.rank=9;
		} else if(r<10) {
			this.rank=10;
		} else if(r<11) {
			this.rank=11;
		} else if(r<12) {
			this.rank=12;
		} else {
			this.rank=13;
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
