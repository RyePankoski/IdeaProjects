import java.util.Arrays;

public class Main {
    public static void printDeck(Deck deckOfCards){

        Card[] look = deckOfCards.getDeck();

        for (int i = 0; i < 36; ++i) {
            System.out.println(look[i].getNumber() + " of " + look[i].getSuit());
        }
        for (int i = 36; i < 52; ++i){
            System.out.println(look[i].getSpecial() + " of " + look[i].getSuit());
        }
    }
    public static Card[] deckMaker() {

        String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades"};
        String[] heads = {"Jack", "Queen", "King", "Ace"};
        Card[] deck = new Card[52];
        int deckIndex = 0;

        for (int i = 0; i < 4; ++i) {
            for (int j = 1; j < 10; ++j) {
                Card newCard = new Card(suits[i], j);
                deck[deckIndex] = newCard;
                deckIndex++;
            }
        }

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                Card newCard = new Card(suits[i], heads[j]);
                System.out.println(newCard.suit + newCard.getSpecial());
                deck[deckIndex] = newCard;
                deckIndex++;
            }
        }
        System.out.println(Arrays.toString(deck));
        return deck;
    }

    public static void main(String[] args) {

        Deck deckOfCards = new Deck(deckMaker());

        printDeck(deckOfCards);


    }
}