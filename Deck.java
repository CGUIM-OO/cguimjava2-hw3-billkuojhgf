package HW3;

import java.util.*;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed = 0;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		usedCard =new ArrayList<Card>();
		for (int i = 1; i <= nDeck; i++) {
			for (Card.Suit j : Card.Suit.values()) {
				for (int k = 1; k <= 13; k++) {
					Card card = new Card(j, k);
					cards.add(card);
				}
			}
		}
	}

	public void printDeck() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();
		}
	}

	public Card getOneCard() {
		
		nUsed+=1;
		if(nUsed == 52){
			usedCard.clear();
			shuffle();
		}
		
		usedCard.add(cards.get(nUsed));
		return cards.get(nUsed);
		
	}

	public void shuffle() {
		ArrayList<Card> NewCard = new ArrayList<Card>();
		Random rnd = new Random();
		Card c;
		for (int i = 1; i <= 52; i++) {
			do {
				c = cards.get(rnd.nextInt(52));
			} while (NewCard.contains(c));
			NewCard.add(c);
		}
		cards.clear();
		cards = NewCard;

		nUsed = 0;

	}

	public ArrayList<Card> getAllCards() {
		// TODO Auto-generated method stub
		return cards;
	}

}
