/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author degty
 */

import java.util.ArrayList;
import java.util.List;
public class WarPlayer extends Player {
    
    private GroupOfCards hand;
    
    public WarPlayer(String name, GroupOfCards hand) {
        super(name);
        this.hand = hand;
    }
    
    public Card drawCard() {
        return hand.removeCard(0);
    }

    public void collectCards(ArrayList<Card> cardsWon) {
        this.hand.addCards(cardsWon);
    }
    
    public List<Card> drawFourCards() {
        List<Card> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card c = hand.removeCard(0);
            if (c == null) break;
            result.add(c);
        }
        return result;
    }
    
    public boolean hasEnoughCards(int count) {
        return hand.getSize() >= count;
    }
    
    public int getHandSize() {
        return hand.getSize();
    }
    
    public boolean hasCards() {
        return hand.getSize()>0;
    }
    
    @Override
    public void play(){
        
    }
}
