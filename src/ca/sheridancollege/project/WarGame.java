package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class WarGame extends Game {

    private static final int MAX_ROUNDS = 3;
    private boolean gameOver = false;
    private WarPlayer forcedWinner= null;

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
            
            deck.shuffle();

            GroupOfCards hand1 = new GroupOfCards(26);
            GroupOfCards hand2 = new GroupOfCards(26);
            
            boolean toFirst = true;
            
            while (!deck.isEmpty()) {
            if (toFirst) {
                hand1.addCard(deck.removeCard());
            } else {
                hand2.addCard(deck.removeCard());
            }
            toFirst = !toFirst;
        }

        ArrayList<Player> players = new ArrayList<>();
        players.add(new WarPlayer("Player 1", hand1));
        players.add(new WarPlayer("Player 2", hand2));
        setPlayers(players);
    }
//            
//            
//            List<Card> deckCards = deck.getCards();
//            
//            for (int i = 0; i < 26; i++) {
//            hand1.getCards().add(deckCards.get(i));
//        }
//
//        // Player 2 gets the remaining 26 cards
//        for (int i = 26; i < 52; i++) {
//            hand2.getCards().add(deckCards.get(i));
//        }
//
//        // Player Assignment
//        setPlayers(new ArrayList<>(List.of(
//            new WarPlayer("Player 1", hand1), 
//            new WarPlayer("Player 2", hand2)
//        )));
//        }

    /**
     * Executes a single round of play.
     */
    private void playRound(WarPlayer p1, WarPlayer p2, List<Card> table) {
        
        if (!p1.hasCards() || !p2.hasCards()) {
            gameOver = true;
            return;
        }
        PlayingCard c1 = (PlayingCard) p1.drawCard();
        PlayingCard c2 = (PlayingCard) p2.drawCard();
        
        if (c1==null || c2==null) {
            gameOver=true;
            return;
        }


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

        if (!p1.hasEnoughCards(4) || !p2.hasEnoughCards(4)) {
            System.out.println("A player does not have enough cards for WAR.");
            forcedWinner = (p1.getHandSize() > p2.getHandSize()) ? p1 : p2;
            gameOver = true;
            return;
        }

        // Add 3 face-down cards each
        for (int i = 0; i < 3; i++) {
            table.add(p1.drawCard());
            table.add(p2.drawCard());
        }

        // Face-up cards
        PlayingCard warC1 = (PlayingCard) p1.drawCard();
        PlayingCard warC2 = (PlayingCard) p2.drawCard();

        table.add(warC1);
        table.add(warC2);

        System.out.println(p1.getName() + " WAR card: " + warC1);
        System.out.println(p2.getName() + " WAR card: " + warC2);

        if (warC1.getValue() > warC2.getValue()) {
            System.out.println(p1.getName() + " wins the WAR!");
            p1.collectCards(new ArrayList<>(table));
            table.clear();
        } else if (warC2.getValue() > warC1.getValue()) {
            System.out.println(p2.getName() + " wins the WAR!");
            p2.collectCards(new ArrayList<>(table));
            table.clear();
        } else {
            System.out.println("WAR tied again — another war!");
            handleWar(p1, p2, table);
        }
    }
    
    
    
    @Override
    public void play() {
        setupGame();

        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);

        List<Card> table = new ArrayList<>();
        int round = 1;

        while (!gameOver && p1.hasCards() && p2.hasCards() && round <= MAX_ROUNDS) {
            System.out.println("\n------ ROUND " + round + " ------");
            playRound(p1, p2, table);
            System.out.println("Card Count:  " + p1.getName() + "=" + p1.getHandSize() +
                               " | " + p2.getName() + "=" + p2.getHandSize());
            round++;
        }

        System.out.println("\n----- GAME OVER ------");
        declareWinner();
    }

    /**
     * Declares the winner based on remaining cards or maximum rounds reached.
     */
    @Override
    public void declareWinner() {
        WarPlayer p1 = (WarPlayer) getPlayers().get(0);
        WarPlayer p2 = (WarPlayer) getPlayers().get(1);
        
        if (forcedWinner != null) {
            System.out.println("Winner if you are out of cards: " + forcedWinner.getName());
            return;
        }

        if (!p1.hasCards() && !p2.hasCards()) {
            System.out.println("It's a DRAW — you are both out of cards.");
        } else if (!p1.hasCards()) {
            System.out.println("Winner: " + p2.getName());
        } else if (!p2.hasCards()) {
            System.out.println("Winner: " + p1.getName());
        } else if (p1.getHandSize() > p2.getHandSize()) {
            System.out.println("Winner: " + p1.getName() + ", you have the most number of cards");
        } else if (p2.getHandSize() > p1.getHandSize()) {
            System.out.println("Winner: " + p2.getName() + ", you have the most number of cards");
        } else {
            System.out.println("It's a tie");
        }
    }
}