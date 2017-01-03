import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jeff on 1/3/17.
 */
public class Deck {
    List<Card> cards = new ArrayList<Card>();

    public Deck(){}

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public static Deck createStandardDeck(){
        Deck deck = new Deck();
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                deck.addCard(new Card(suit, rank));
            }
        }

        return deck;
    }
}
