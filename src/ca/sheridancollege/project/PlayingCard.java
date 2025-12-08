/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author oaeri
 */
public class PlayingCard extends Card {

    private Suit suit;
    private Rank rank;

    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Returns the numerical value of the card.
     * Uses the enumeration position (ordinal) to determine value.
     * * @return the numerical rank of the card (e.g., ACE might be 0)
     */
    public int getValue() {
        return this.rank.ordinal();
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}