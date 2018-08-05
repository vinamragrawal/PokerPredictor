/**
 * Created by vinamraagrawal on 04/08/2018.
 */

enum Suit
{
    Spade, Heart, Diamond, Club
}

enum Value
{
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
}

public class Card {

    private final Suit suit;
    private final Value value;

    Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    Value getValue() {
        return value;
    }
}
