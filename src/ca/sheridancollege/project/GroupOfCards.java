
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 *
 * @author Ali
 * @author degtiare
 */
public class GroupOfCards implements CardsInterface{

    //The group of cards stored in an ArrayList
    private final ArrayList<Card> cards;
    

    public GroupOfCards(int size) {
        this.cards = new ArrayList<>(size);
    }
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }
    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override 
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card removeCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
//    
//    public Card removeCard(int index) {
//        
//        return cards.remove(index);
//
//    }
    @Override
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void addCards(List<Card> newCards) {
        cards.addAll(newCards);
    }
    
}
