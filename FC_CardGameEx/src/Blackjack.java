import java.util.ArrayList;
import java.util.Scanner;

//In blackjack, the goal is to make a hand coming as close to 21 as possible without going over. 
//A hand has at least two cards, and the player can "hit" to draw an additional card. 
//An ace counts as 11 if possible without going over 21, and as 1 otherwise. 
//10, J, Q, and K all count as 10. 
//Create a class to represent a blackjack hand and compute its score.

public class Blackjack {

	private final int goal=21;
	private int score=0;
	private Hand hand=new Hand(false,true); //can't replace, but can resize
	private boolean gameOver=false;
	
	public Blackjack() {
		hand.addCardRand();
		hand.addCardRand();
		calcScore();
	}
	
	
	public void hit() { 
		hand.addCardRand();
		calcScore();
	}
	
	public void calcScore(){
		ArrayList<Card> cards=hand.returnList();
		for(int i=0;i<cards.size();i++) {
			int rank=cards.get(i).getRank();
			if(rank>=10) {
				this.score+=10;
			} else if(rank==1) {
				if(this.score+11<21) {
					this.score+=11;
				} else {
					this.score+=1;
				}
			} else {
				this.score+=rank;
			}
		} //end for all cards
	} //end calcScore
	
	public void play() {
		while(!gameOver) {
			System.out.println("Your current score is: "+this.score);
			System.out.println("You were trying to get to "+this.goal);
			if(this.score>this.goal) {
				System.out.println("Sorry, you have lost this game");
				gameOver=true;
			} else {
				Scanner scan=new Scanner(System.in);
				System.out.println("Would you like to draw another card? y/n ");
				String word=scan.next();
				if(word.startsWith("Y") || word.startsWith("y")) {
					hit();
				} else {
					gameOver=true;					
				}
				scan.close();
			}
		} //end while
		System.out.println("Thank you for playing");
	}
	
//	Scanner reader = new Scanner(System.in);  // Reading from System.in
//	System.out.println("Enter a number: ");
//	int n = reader.nextInt(); // Scans the next token of the input as an int.
//	//once finished
//	reader.close();
	
}
