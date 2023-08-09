import java.util.*;

public class gameMain {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        // Make list of playerhand , dealerhand
        List<Card> playerhand = new ArrayList<>();
        List<Card> dealerhand = new ArrayList<>();
        // Make list of deck contain card(suit,rank)
        Deck deck = new Deck();
        deck.shuffle();
        // Create backJack class
        blackJack game = new blackJack(deck, playerhand, dealerhand);
        // Make loop entire game
        while (true) {
            
            System.out.println("=====================================================================");
            System.out.println("");
            System.out.println("                         WELCOME TO BLACKJACK!                       ");
            System.out.println("");
            System.out.println("=====================================================================");

            System.out.println("Dealing hands...");
            game.deal();
            System.out.println("=====================================================================");

            // Player's turn
            while (true) {
                
                game.printPlayerHand();

                System.out.println("Player hand : " + game.getPlayerScore());
                System.out.println("Hits or Stay?" + "\n" + "1 : Hits" + "\n" + "2 : Stay");
                System.out.print("Enter choice : ");
                int input = sc.nextInt();

                //Player's hits logic
                if (input == 1) {
                    game.hitPlayer();
                    System.out.println("Player Hits!");
                    System.out.println("=======================================================================");

                } else if (input == 2) {
                    System.out.println("Player Stay!");
                    break;
                }
            }
            System.out.println("=======================================================================");

            game.printPlayerHand();
            System.out.println("Player hand : " + game.getPlayerScore());

            System.out.println("=======================================================================");

            // Dealer's turn
            while (game.getDealerScore() <= 15) {
                game.hitDealer();
                if(game.getDealerScore() == 21){
                    break;
                }
            }
            game.printDealerHand();
            System.out.println("Dealer score : " + game.getDealerScore());

            System.out.println("=======================================================================");

            System.out.println("*** BlackJack Summary ***");
            game.determineWinner();

            System.out.println("=======================================================================");

            System.out.println("Would you like to play again? Type 1 for yes, 2 for no.");
            System.out.print("Choice : ");
            int input = sc.nextInt();
            if (input == 1) {
                game.resetGame();
                deck = new Deck();
                deck.shuffle();
            } else if (input == 2) {
                System.out.println("Thanks for playing!");
                System.out.println("=====================================================================");
                break;
            }
        }
    }
}
