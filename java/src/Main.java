import java.util.ArrayList;

/**
 * Created by vinamraagrawal on 04/08/2018.
 */
public class Main {

    private static ArrayList<Card> getAllCards(){
        ArrayList<Card> allCards = new ArrayList<>();
        for (Suit suit: Suit.values())
            for (Value value: Value.values())
                allCards.add(new Card(suit, value));
         return allCards;
    }
    public static void main(String[] args){
        ArrayList<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Suit.Spade, Value.Ace));
        tableCards.add(new Card(Suit.Spade, Value.King));
        tableCards.add(new Card(Suit.Spade, Value.Queen));
        tableCards.add(new Card(Suit.Club, Value.Two));
        tableCards.add(new Card(Suit.Club, Value.Three));

        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(new Card(Suit.Spade, Value.Jack));
        handCards.add(new Card(Suit.Spade, Value.Nine));

        ArrayList<Card> myCards = new ArrayList<>();
        myCards.addAll(tableCards);
        myCards.addAll(handCards);
        Sequence mySequence = new Sequence(myCards);

        ArrayList<Card> remainingCards = getAllCards();
        remainingCards.removeAll(tableCards);

        for(int i = 0; i < remainingCards.size(); i++)
            for(int j = i + 1; j < remainingCards.size(); j++){
                ArrayList<Card> possibleCards = new ArrayList<>();
                possibleCards.add(remainingCards.get(i));
                possibleCards.add(remainingCards.get(j));
                possibleCards.addAll(tableCards);
                Sequence possibleSequence = new Sequence(possibleCards);
                if (remainingCards.get(i).equals(myCards.get(0)) && remainingCards.get(j).equals(myCards.get(1)))
                    continue;
                if (remainingCards.get(j).equals(myCards.get(0)) && remainingCards.get(i).equals(myCards.get(1)))
                    continue;
                if (Comparator.compareSequence(possibleSequence,mySequence) > 0){
                    System.out.println(remainingCards.get(i).getSuit() + " " + remainingCards.get(i).getValue());
                    System.out.println(remainingCards.get(j).getSuit() + " " + remainingCards.get(j).getValue());
                    System.out.println();
                }
            }
    }
}
