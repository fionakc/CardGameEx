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
	
	public void addCard(Card cNew) {
		if(this.canResize) {
			this.cards.add(cNew);
		}
		updateSize();
	}
	
	public void replaceCard(int i, Card cNew) {
		if(this.canReplace && i>=0 && i<this.size) {
			this.cards.set(i, cNew);
		}
		updateSize();
	}
	
}
