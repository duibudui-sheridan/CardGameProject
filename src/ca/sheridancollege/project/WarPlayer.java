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
    
    private CardsInterface hand;
    
    public WarPlayer(String name, CardsInterface hand) {
        super(name);
        this.hand = hand;
    }
    
    public Card drawCard() {
        return hand.removeCard();
    }

    public void collectCards(List<Card> cardsWon) {
        for (Card c: cardsWon) {
            hand.addCard(c);
        }
    }
    
    public List<Card> drawFourCards() {
        List<Card> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card c = hand.removeCard();
            if (c == null) break;
            result.add(c);
        }
        return result;
    }
    
    public boolean hasEnoughCards(int count) {
        return hand.size() >= count;
    }
    
    public int getHandSize() {
        return hand.size();
    }
    
    public boolean hasCards() {
        return !hand.isEmpty();
    }
    
    @Override
    public void play(){
        
    }
}
