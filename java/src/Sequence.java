import java.util.ArrayList;

/**
 * Created by vinamraagrawal on 04/08/2018.
 */
enum WinningOrder
{
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush
}

class Sequence {
    private final ArrayList<Card> cards;
    private final int[] valueArray = new int[Value.values().length];
    private final WinningOrder winningOrder;
    private final ArrayList<Card> winningOrderCards;

    Sequence(ArrayList<Card> cards) {
        this.cards = cards;

        //Initialise and populate value array of Cards
        for (Card card : cards) {
            int value = card.getValue().ordinal();
            valueArray[value] = valueArray[value] + 1;
        }

        //Get Winning Order and Winning Cards
        winningOrder = createWinningOrder();
        winningOrderCards = createWinningOrderCards();
    }

    ArrayList<Card> getCards() {
        return cards;
    }

    WinningOrder getWinningOrder() {
        return winningOrder;
    }

    ArrayList<Card> getWinningOrderCards() {
        return winningOrderCards;
    }

    private boolean isPair(){
        for (int aValueArray : valueArray) {
            if (aValueArray == 2)
                return true;
        }
        return false;
    }

    private boolean isTwoPair(){
        boolean firstPair = false;
        for (int aValueArray : valueArray) {
            if (aValueArray == 2) {
                if (!firstPair)
                    firstPair = true;
                else return true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(){
        for (int aValueArray : valueArray) {
            if (aValueArray == 3)
                return true;
        }
        return false;
    }

    private boolean isStraight(){
        int sequenceLenght = 0;
        for (int aValueArray : valueArray) {
            if (aValueArray == 1)
                sequenceLenght++;
            else sequenceLenght = 0;

            if (sequenceLenght == Comparator.POKER_MAX_CARD_SEQUENCE)
                return true;
        }
        return false;
    }

    private boolean isFlush(){
        return false;
    }

    private boolean isFullHouse(){
        return false;
    }

    private boolean isFourOfAKind(){
        return false;
    }

    private boolean isStraightFlush(){
        return false;
    }

    private WinningOrder createWinningOrder(){
        if(isStraightFlush())
            return WinningOrder.StraightFlush;
        if(isFourOfAKind())
            return WinningOrder.FourOfAKind;
        if(isFullHouse())
            return WinningOrder.FullHouse;
        if(isFlush())
            return WinningOrder.Flush;
        if(isStraight())
            return WinningOrder.Straight;
        if(isThreeOfAKind())
            return WinningOrder.ThreeOfAKind;
        if(isTwoPair())
            return WinningOrder.TwoPair;
        if(isPair())
            return WinningOrder.OnePair;
        return WinningOrder.HighCard;
    }

    Card getHighestCard() {
        if (cards.size() == 0) {
            System.out.println("No cards in the Sequence");
            return null;
        }
        Card highestCard = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
            if( highestCard.getValue().ordinal() < cards.get(i).getValue().ordinal())
                highestCard = cards.get(i);
        }
        return highestCard;
    }

    //Returns winning card in highest to lowest order
    private ArrayList<Card> createWinningOrderCards(){
        ArrayList<Card> winningOrderCards = new ArrayList<>();
        switch (winningOrder){
            case StraightFlush:
                break;
            case FourOfAKind:
                break;
            case FullHouse:
                break;
            case Flush:
                break;
            case Straight:
                int sequenceLenght = 0;
                int minCardValue = -1;
                for (int aValueArray : valueArray) {
                    if (aValueArray == 1)
                        sequenceLenght++;
                    else sequenceLenght = 0;

                    if (sequenceLenght == Comparator.POKER_MAX_CARD_SEQUENCE)
                        minCardValue = aValueArray;
                }
                for (int i = minCardValue + Comparator.POKER_MAX_CARD_SEQUENCE - 1; i >= minCardValue; i--){
                    for (int j = 0; j < cards.size(); j++)
                        if (j == i)
                            winningOrderCards.add(cards.get(i));
                }
                break;
            case ThreeOfAKind:
                for (Card card : cards) {
                    if (valueArray[card.getValue().ordinal()] == 3)
                        winningOrderCards.add(card);
                }
                break;
            case TwoPair:
                for (int i = valueArray.length - 1; i >= 0; i--){
                    if (valueArray[i] == 2)
                        for (Card card : cards) {
                            if (card.getValue().ordinal() == i)
                                winningOrderCards.add(card);
                        }
                }
                break;
            case OnePair:
                for (Card card : cards) {
                    if (valueArray[card.getValue().ordinal()] == 2)
                        winningOrderCards.add(card);
                }
                break;
            case HighCard:
                winningOrderCards.add(getHighestCard());
        }
        return winningOrderCards;
    }
}
