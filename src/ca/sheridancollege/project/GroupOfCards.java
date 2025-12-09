
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;



/**
 *
 * @author Ali
 */
public class GroupOfCards {

    //The group of cards stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }

    public Card removeCard(int index) {
        
        return cards.remove(index);

    }
public void addCards(ArrayList<Card> newCards) {
    for (Card card : newCards) {
        this.cards.add(card);
    }
}
    
}
