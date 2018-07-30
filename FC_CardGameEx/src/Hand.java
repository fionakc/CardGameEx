import java.util.ArrayList;

//A Hand consists of one or more cards. 
//Depending on the game, hands may have different sizes, 
//might be able to change size or not, and might be able to have cards replaced or not. 
//Create a type to represent a hand generally.
public class Hand {

	private int size;
	private boolean canReplace;
	private boolean canResize;
	private ArrayList<Card> cards=new ArrayList<Card>();
	
	public Hand(boolean replace, boolean resize) {
		this.canReplace = replace;
		this.canResize = resize;
	}
	
	private void updateSize() {
		this.size=this.cards.size();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int s) {
		this.size=s;
	}
	
	public void addCardRand() { //need to check if any the same
		if(this.canResize) {
			Card temp=new Card();
			
			while(checkCollide(temp)) {
				Card t=new Card();
				temp=t;
			}
			this.cards.add(temp);
		}
		updateSize();
	}
	
	public void addCard(String s, int r) {
		if(this.canResize) {
			Card temp=new Card(s,r);
			this.cards.add(temp);
		}
		updateSize();
	}
	
	public void replaceCard(int i, Card cNew) {
		if(this.canReplace && i>=0 && i<this.size) {
			this.cards.set(i, cNew);
		}
		updateSize();
	}
	
	public boolean checkCollide(Card c) {
			
		boolean collides=false;
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getRank()==c.getRank() && cards.get(i).getSuitVal()==c.getSuitVal()) {
				collides =true;
				break;
			}
		}
		return collides;
	}
	
	public ArrayList<Card> returnList(){
		return cards;
	}
}
