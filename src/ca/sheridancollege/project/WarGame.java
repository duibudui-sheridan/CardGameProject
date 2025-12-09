package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class WarGame extends Game {

    private static final int MAX_ROUNDS = 3;

    public WarGame(String name) {
        super(name);
    }

    /**
     * Initializes the standard 52-card deck and deals it to two players.
     */
        private void setupGame() {
            GroupOfCards deck = new GroupOfCards(52);
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    deck.getCards().add(new PlayingCard(r, s));
                }
            }

            GroupOfCards hand1 = new GroupOfCards(26);
            GroupOfCards hand2 = new GroupOfCards(26);
            List<Card> deckCards = deck.getCards();
            
            for (int i = 0; i < 26; i++) {
            hand1.getCards().add(deckCards.get(i));
        }

        // Player 2 gets the remaining 26 cards
        for (int i = 26; i < 52; i++) {
            hand2.getCards().add(deckCards.get(i));
        }

        // Player Assignment
        setPlayers(new ArrayList<>(List.of(
            new WarPlayer("Player 1", hand1), 
            new WarPlayer("Player 2", hand2)
        )));
        }

    /**
     * Executes a single round of play.
     */
    private void playRound(WarPlayer p1, WarPlayer p2, List<Card> table) {
        PlayingCard c1 = (PlayingCard) p1.drawCard();
        PlayingCard c2 = (PlayingCard) p2.drawCard();


        System.out.println(p1.getName() + " plays " + c1);
        System.out.println(p2.getName() + " plays " + c2);

        table.add(c1);
        table.add(c2);

        if (c1.getValue() > c2.getValue()) {
            System.out.println( p1.getName() + " wins the round!");
            p1.collectCards(new ArrayList<>(table)); // player take the cards to his hands
            table.clear();
            
            
        } else if (c2.getValue() > c1.getValue()) {
            System.out.println( p2.getName() + " wins the round!");
            p2.collectCards(new ArrayList<>(table)); // player 2 takes the cards
            table.clear();
        } else {
            System.out.println("!!! WAR !!!"); // if draw we call war
            handleWar(p1, p2, table);
        }
    }

    
     //Handles the war
         
    private void handleWar(WarPlayer p1, WarPlayer p2, List<Card> table) {
    }
    
    
    
    @Override
    public void play() {
        setupGame();

        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);

        
    }

    /**
     * Declares the winner based on remaining cards or maximum rounds reached.
     */
    @Override
    public void declareWinner() {
        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);

    }
}