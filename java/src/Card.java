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

    Suit getSuit() {
        return suit;
    }

    Value getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Card other = (Card) obj;
        if (this.suit.ordinal() != other.suit.ordinal())
            return false;

        return this.value.ordinal() == other.value.ordinal();
    }
}
