import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }
    
    public int size() {
        return cards.size();
    }

    public Card drawCard() {
        Card drawingCard;
        drawingCard = cards.get(0);
        cards.remove(0);
        return drawingCard;
    }

    public List<Card> drawCard(int count) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            drawnCards.add(cards.get(0));
            cards.remove(0);
        }
        return drawnCards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public List<Card> getCardByRank(Card card){
        List<Card> foundCards = new ArrayList<>();

        for(int i = 0 ; i<cards.size(); i++){
            if(card.getRank().equals(cards.get(i).getRank())) {
                System.out.print( "["+cards.get(i) + "]");
                foundCards.add(cards.get(i));
            }
        }
        return foundCards; 
    }

    @Override
    public String toString() {
        return "Deck cards=" + cards;
    }

    public List<Card> getCards() {
        return cards;
    }


}