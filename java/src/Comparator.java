import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinamraagrawal on 04/08/2018.
 */

class Comparator {
    static final int POKER_MAX_CARD_SEQUENCE = 5;

    static int compareSequence(Sequence sequence1, Sequence sequence2){
        if (sequence1.getCards().size() != sequence2.getCards().size()) {
            System.out.println("Error InValid sequence count");
            return 0;
        }

        if (sequence1.getWinningOrder().ordinal() > sequence2.getWinningOrder().ordinal())
            return 1;
        else if (sequence1.getWinningOrder().ordinal() < sequence2.getWinningOrder().ordinal())
            return -1;
        for (int i = 0; i < sequence1.getWinningOrderCards().size(); i++) {
            int val1 = sequence1.getWinningOrderCards().get(i).getValue().ordinal();
            int val2 = sequence2.getWinningOrderCards().get(i).getValue().ordinal();
            if (val1 > val2)
                return 1;
            if (val2 > val1)
                return -1;
        }

        ArrayList<Card> remainingCards1 = getRemainingCards(sequence1, sequence1.getWinningOrderCards());
        ArrayList<Card> remainingCards2 = getRemainingCards(sequence2, sequence2.getWinningOrderCards());

        for (int i = sequence1.getWinningOrderCards().size(); i < POKER_MAX_CARD_SEQUENCE; i++)
        {
            Card highCard1 = (new Sequence(remainingCards1)).getHighestCard();
            Card highCard2 = (new Sequence(remainingCards2)).getHighestCard();

            if (highCard1.getValue().ordinal() > highCard2.getValue().ordinal())
                return 1;
            if (highCard2.getValue().ordinal() > highCard1.getValue().ordinal())
                return -1;

            remainingCards1.remove(highCard1);
            remainingCards2.remove(highCard2);
        }
        return 0;
    }

    private static ArrayList<Card> getRemainingCards(Sequence sequence, List<Card> winningCards){
        ArrayList<Card> allCards = new ArrayList<>(sequence.getCards());
        allCards.removeAll(winningCards);
        return allCards;
    }
}
