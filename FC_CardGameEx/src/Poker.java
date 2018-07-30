import java.util.ArrayList;
import java.util.Collections;

public class Poker {

	private int handRank=0;
	private Hand hand=new Hand(false,true); //can't replace, but can resize
	AceLow aceLow=new AceLow();
	AceHigh aceHigh=new AceHigh();
	SuitRank suitRank=new SuitRank();
	
	public Poker() {
		for(int i=0;i<5;i++) { //only 5 cards in the hand
			hand.addCardRand();
		}
		calcHandRank();
	}
	
	public void play() {
		ArrayList<Card> cards=hand.returnList();
		System.out.println("Your poker hand is: ");
		for(int i=0;i<cards.size();i++) {
			System.out.println(cards.get(i).getRank() +" "+ cards.get(i).getSuit());
		}
		System.out.print("This means you have a ");
		if(this.handRank<2) {
			System.out.println("Straight Flush - same suit, sequential ranks");
		} else if(this.handRank<3) {
			System.out.println("Four of a Kind - same ranks x4");
		} else if(this.handRank<4) {
			System.out.println("Full House - 3 ranks, 2 ranks");
		} else if(this.handRank<5) {
			System.out.println("Flush - same suit");
		} else if(this.handRank<6) {
			System.out.println("Straight - sequential ranks");
		} else if(this.handRank<7) {
			System.out.println("Three of a Kind - 3 ranks");
		} else if(this.handRank<8) {
			System.out.println("Two Pair - 2 ranks, 2 ranks");
		} else if(this.handRank<9) {
			System.out.println("Pair - 2 ranks");
		} else {
			System.out.println("High Card");
		} 
		
	} //end play
	
	public void calcHandRank() {
		ArrayList<Card> cards=hand.returnList();
		boolean handMatch=false;
		handMatch=checkStraightFlush(cards);
		if(handMatch) {
			this.handRank=1;
		} else {
			handMatch=checkFourOfAKind(cards);
			if(handMatch) {
				this.handRank=2;
			} else {
				handMatch=checkFullHouse(cards);
				if(handMatch) {
					this.handRank=3;					
				} else {
					handMatch=checkFlush(cards);
					if(handMatch) {
						this.handRank=4;
					} else {
						handMatch=checkStraight(cards,0);
						if(handMatch) {
							this.handRank=5;
						} else {
							handMatch=checkStraight(cards,1);
							if(handMatch) {
								this.handRank=5;
							} else {
								handMatch=checkThreeOfAKind(cards);
								if(handMatch) {
									this.handRank=6;
								} else {
									handMatch=checkTwoPair(cards);
									if(handMatch) {
										this.handRank=7;
									} else {
										handMatch=checkPair(cards);
										if(handMatch) {
											this.handRank=8;
										} else {
											this.handRank=9;
										}
									}
								}							
							}								
						}
					}
				}
			}
		}
		
	} //end calcHandRank
	
	public boolean checkStraightFlush(ArrayList<Card> c) {
		Collections.sort(c, suitRank);
		boolean flush=false;
		if(c.get(0).getSuitVal()==c.get(4).getSuitVal()) { //if first and last suit are the same after sorting
			flush = checkStraight(c,0); //check if Straight with aceLow
			if(!flush) {				//if not
				flush=checkStraight(c,1); //check if Straight with aceHigh
			}
		} 
		return flush;
	} //end checkStraightFlush
	
	public boolean checkFourOfAKind(ArrayList<Card> c) { //4 with same rank
		Collections.sort(c,aceHigh);
		boolean row=false;		
		if((c.get(0).getRank()==c.get(3).getRank()) && (c.get(3).getRank()!=c.get(4).getRank())) {
			row=true;
		} else if((c.get(1).getRank()==c.get(4).getRank()) && (c.get(1).getRank()!=c.get(0).getRank())) {
			row = true;
		} else {
			row=false;
		}
		return row;
	} //end checkFourOfAKind
	
	public boolean checkFullHouse(ArrayList<Card> c) {
		boolean full=false;
		Collections.sort(c, aceHigh);
		if((c.get(0).getRank()==c.get(2).getRank()) && (c.get(3).getRank()==c.get(4).getRank())
				&& (c.get(2).getRank()!=c.get(3).getRank())) {
			full=true;
		} else if((c.get(0).getRank()==c.get(1).getRank()) && (c.get(2).getRank()==c.get(4).getRank()) 
				&& (c.get(1).getRank()!=c.get(2).getRank())) {
			full=true;
		}		
		return full;
	} //end checkFullHouse
	
	public boolean checkFlush(ArrayList<Card> c) {
		boolean same=false;
		Collections.sort(c, suitRank); //sort suits
		if(c.get(0).getSuitVal()==c.get(4).getSuitVal()) { //if first and last are same suit
			same=true;
		}
		return same;
	} //end checkFlush
	
	public boolean checkStraight(ArrayList<Card> c, int a) {	//5 in a row, any suit	
		boolean same=false;
		if(a==0) {
			Collections.sort(c, aceLow);
		} else {
			Collections.sort(c, aceHigh);
		}
		for(int i=0;i<c.size()-1;i++) {
			if(c.get(i).getSuitVal()==(c.get(i+1).getSuitVal()-1)) { //if c(i) = c(i)-1
				same=true;
			} else {
				same=false;
				break;
			}
		}		
		return same;
	} //end checkStraight
	
	public boolean checkThreeOfAKind(ArrayList<Card> c) {
		Collections.sort(c, aceHigh);
		boolean trip=false;
		//if 0=2 and not 3 or 4
		if((c.get(0).getRank()==c.get(2).getRank()) &&(c.get(0).getRank()!=c.get(3).getRank()) 
				&& (c.get(0).getRank()!=c.get(4).getRank())) {
			trip=true;
		}
		//if 1=3 and not 1 or 4
		if((c.get(1).getRank()==c.get(3).getRank()) &&(c.get(1).getRank()!=c.get(0).getRank()) 
				&& (c.get(1).getRank()!=c.get(4).getRank())) {
			trip=true;
		}
		//if 2=4 and not 0 or 1
		if((c.get(2).getRank()==c.get(4).getRank()) &&(c.get(2).getRank()!=c.get(0).getRank()) 
				&& (c.get(2).getRank()!=c.get(1).getRank())) {
			trip=true;
		}				
		return trip;
	} //end check 3 of a kind
	
	public boolean checkTwoPair(ArrayList<Card> c) {
		boolean pair=false;
		Collections.sort(c, aceHigh);
		//if 0=1 & 2=3 & 0!=4 & 2!=4
		if((c.get(0).getRank()==c.get(1).getRank())&&(c.get(2).getRank()==c.get(3).getRank())
				&&(c.get(0).getRank()!=c.get(4).getRank())&&(c.get(2).getRank()!=c.get(4).getRank())) {
			pair=true;		
		}
		//if 0=1 & 3=4 & 0!=2 & 3!=2
		if((c.get(0).getRank()==c.get(1).getRank())&&(c.get(3).getRank()==c.get(4).getRank())
				&&(c.get(0).getRank()!=c.get(2).getRank())&&(c.get(3).getRank()!=c.get(2).getRank())) {
			pair=true;		
		}
		//if 1=2 & 3=4 & 1!=0 & 3!=0
		if((c.get(1).getRank()==c.get(2).getRank())&&(c.get(3).getRank()==c.get(4).getRank())
				&&(c.get(1).getRank()!=c.get(0).getRank())&&(c.get(3).getRank()!=c.get(0).getRank())) {
			pair=true;		
		}
		return pair;
	} //end check 2 pair
	
	public boolean checkPair(ArrayList<Card> c) {
		//assume by this point it's not any other kind of pair
		Collections.sort(c, aceHigh);
		boolean pair=false;
		for(int i=0;i<c.size()-1;i++) {
			if(c.get(i).getRank()==c.get(i+1).getRank()) {
				pair=true;
				break;
			}
		}
		return pair;
	} //end checkPair
}
