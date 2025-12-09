/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author degty
 */

import java.util.List;

public interface CardsInterface {
    void addCard(Card card);
    
    Card removeCard();
    
    int size();
    
    boolean isEmpty();
    
    void shuffle();
    
    List<Card> getCards();
}
