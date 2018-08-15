import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private final int[] suitArray = new int[Suit.values().length];
    private final WinningOrder winningOrder;
    private final ArrayList<Card> winningOrderCards;

    Sequence(ArrayList<Card> cards) {
        this.cards = cards;

        //Initialise and populate value and suit array of Cards
        for (Card card : cards) {
            int value = card.getValue().ordinal();
            valueArray[value] = valueArray[value] + 1;

            int suit = card.getSuit().ordinal();
            suitArray[suit] = suitArray[suit] + 1;
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
            if (aValueArray >= 1)
                sequenceLenght++;
            else sequenceLenght = 0;

            if (sequenceLenght >= Comparator.POKER_MAX_CARD_SEQUENCE)
                return true;
        }

        //Check for Ace-Five Case
        return isAceFiveCase();
    }

    private boolean isFlush(){
        for (int suit : suitArray) {
            if (suit >= Comparator.POKER_MAX_CARD_SEQUENCE)
                return true;
        }
        return false;
    }

    private boolean isFullHouse(){
        if (!isThreeOfAKind())
            return false;
        int cards = 0;
        for (int i = valueArray.length - 1; i >= 0; i--) {
            if (valueArray[i] > 1)
                cards += valueArray[i];
            if (cards >= Comparator.POKER_MAX_CARD_SEQUENCE)
                return true;
        }
        return false;
    }

    private boolean isFourOfAKind(){
        for (int aValueArray : valueArray) {
            if (aValueArray == 4)
                return true;
        }
        return false;
    }

    private boolean isStraightFlush(){
        if (isStraight() && isFlush()){
            ArrayList<Card> straightCards = getStraightCards();
            ArrayList<Card> flushCards = getFlushCards();
            for( int i = 0; i < straightCards.size(); i++){
                if (!straightCards.get(i).equals(flushCards.get(i)))
                    return false;
            }
            return true;
        }
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

    private boolean isAceFiveCase(){
        boolean isAceFiveCase = true;
        for (int i = 0; i < Comparator.POKER_MAX_CARD_SEQUENCE - 1; i++) {
            if (valueArray[i] == 0)  isAceFiveCase = false;
        }
        if (valueArray[valueArray.length - 1] == 0)
            isAceFiveCase = false;
        return isAceFiveCase;
    }

    private ArrayList<Card> getStraightCards(){
        ArrayList<Card> winningOrderCards = new ArrayList<>();
        //Check for Ace-Five Case
        if(isAceFiveCase()){
            for (int i = 0; i < Comparator.POKER_MAX_CARD_SEQUENCE - 1; i++){
                for (Card card : cards)
                    if (card.getValue().ordinal() == i) {
                        winningOrderCards.add(card);
                        break;
                    }
            }
            for (Card card : cards)
                if (card.getValue().ordinal() == valueArray.length - 1) {
                    winningOrderCards.add(card);
                    break;
                }
            Collections.reverse(winningOrderCards);

            return winningOrderCards;
        }

        int sequenceLenght = 0;
        int minCardValue = -1;
        for (int i = valueArray.length - 1; i >= 0; i--) {
            if (valueArray[i] >= 1)
                sequenceLenght++;
            else sequenceLenght = 0;

            if (sequenceLenght >= Comparator.POKER_MAX_CARD_SEQUENCE){
                minCardValue = i;
                break;
            }
        }
        for (int i = minCardValue + Comparator.POKER_MAX_CARD_SEQUENCE - 1; i >= minCardValue; i--){
            for (Card card : cards)
                if (card.getValue().ordinal() == i) {
                    winningOrderCards.add(card);
                    break;
                }
        }

        return winningOrderCards;
    }

    private ArrayList<Card> getFlushCards(){
        ArrayList<Card> winningOrderCards = new ArrayList<>();
        int flushSuit = 0;
        for (int i = 0; i < suitArray.length; i++) {
            if (suitArray[i] >= Comparator.POKER_MAX_CARD_SEQUENCE)
                flushSuit = i;
        }
        for (int i = valueArray.length - 1; i >= 0; i--){
            if (valueArray[i] > 0)
                for (Card card : cards) {
                    if (card.getValue().ordinal() == i && card.getSuit().ordinal() == flushSuit)
                        winningOrderCards.add(card);
                }
        }
        return winningOrderCards;
    }

    //Returns winning card in highest to lowest order
    private ArrayList<Card> createWinningOrderCards(){
        ArrayList<Card> winningOrderCards = new ArrayList<>();
        switch (winningOrder){

            case StraightFlush:
                winningOrderCards.addAll(intersection(getFlushCards(), getStraightCards()));
                break;
            case FourOfAKind:
                for (Card card : cards) {
                    if (valueArray[card.getValue().ordinal()] == 4)
                        winningOrderCards.add(card);
                }
                break;

            case FullHouse:
                for (int i = valueArray.length - 1; i >= 0; i--)
                    if (valueArray[i] == 3)
                        for (Card card : cards)
                            if (card.getValue().ordinal() == i)
                                winningOrderCards.add(card);

                for (int i = valueArray.length - 1; i >= 0; i--){
                    if (valueArray[i] > 1)
                        for (Card card : cards) {
                            if (card.getValue().ordinal() == i && card.getValue().ordinal() != winningOrderCards.get(0).getValue().ordinal())
                                winningOrderCards.add(card);
                        }
                }
                break;

            case Flush:
                winningOrderCards = getFlushCards();
                break;

            case Straight:
                winningOrderCards = getStraightCards();
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

    private ArrayList<Card> intersection(List<Card> list1, List<Card> list2) {
        ArrayList<Card> list = new ArrayList<>();

        for (Card t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
