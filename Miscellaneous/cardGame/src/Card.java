
public class Card {

        String suit;
        String special;
        int number;

        @Override
        public String toString() {
                return "Card{" +
                        "suit='" + suit + '\'' +
                        ", special='" + special + '\'' +
                        ", number=" + number +
                        '}';
        }

        public Card(String suit, int number){
                this.suit = suit;
                this.number = number;
        }
        public Card(String suit, String special){
                this.suit = suit;
                this.special = special;
        }
        public int getNumber(){
                return number;
        }
        public String getSuit() {
                return suit;
        }
        public String getSpecial() {
                return special;
        }

}
