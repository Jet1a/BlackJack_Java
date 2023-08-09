    import java.util.*;

    public class blackJack {

        private final Deck cards;
        private List<Card> playerhand;
        private List<Card> dealerhand;

        public blackJack(Deck cards, List<Card> playerhand, List<Card> dealerhand) {
            this.cards = cards;
            this.playerhand = playerhand;
            this.dealerhand = dealerhand;
        }

        public List<Card> getPlayerhand() {
            return playerhand;
        }

        public List<Card> getDealerhand() {
            return dealerhand;
        }

        public void deal() {
            playerhand.add(cards.drawCard());
            playerhand.add(cards.drawCard());
            dealerhand.add(cards.drawCard());
            dealerhand.add(cards.drawCard());
        }

        public void printPlayerHand() {
            System.out.println("Player : " + playerhand);
        }

        public void printDealerHand() {
            System.out.println("Dealer : " + dealerhand);
        }

        public void hitPlayer() {
            playerhand.add(cards.drawCard());
        }

        public void hitDealer() {
            Random rand = new Random();
            int rand_int = rand.nextInt(2);
            if (rand_int == 1) {
                dealerhand.add(cards.drawCard());
                System.out.println("Dealer Hits!");
            } else
                return;
        }

        public int getPlayerScore() {
            int sum = 0;
            for (Card card : playerhand) {
                Rank rank = card.getRank();
                sum += rank.getValue();
            }
            return sum;
        }

        public int getDealerScore() {
            int sum = 0;
            for (Card card : dealerhand) {
                Rank rank = card.getRank();
                sum += rank.getValue();
            }
            return sum;
        }
        public void determineWinner(){
            if(getPlayerScore() == 21){
                System.out.println("Player wins!"+"\n"+"Dealer bust!");
            }else if (getPlayerScore() <=21 && getPlayerScore() > getDealerScore()){
                System.out.println("Player wins!"+"\n"+"Dealer bust!");
            }else if (getPlayerScore() > 21) {
                System.out.println("Player bust!"+"\n"+"Dealer wins!");
            }else if(getDealerScore() == 21){
                System.out.println("Player bust!"+"\n"+"Dealer wins!");
            }else if (getDealerScore() <=21 && getPlayerScore() < getDealerScore()){
                System.out.println("Player bust!"+"\n"+"Dealer wins!");
            }else if (getDealerScore() > 21){
                System.out.println("Player wins!"+"\n"+"Dealer bust!");
            }else if (getDealerScore() == getPlayerScore()){
                System.out.println("Draws!!!");
            }
        }
        public void resetGame() {
            playerhand.clear(); 
            dealerhand.clear(); 
        }
    }
