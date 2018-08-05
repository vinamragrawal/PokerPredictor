
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
 * Created by vinamraagrawal on 04/08/2018.
 */

public class ComparatorTests {
    @Test
    public void HighCardGeneralTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Three));
        array1.add(new Card(Suit.Heart, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Two));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void HighCardAceTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Three));
        array1.add(new Card(Suit.Heart, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Two));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void HighCardOneCompoundedTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Three));
        array1.add(new Card(Suit.Heart, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Ace));
        array1.add(new Card(Suit.Club, Value.Four));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Queen));
        array2.add(new Card(Suit.Heart, Value.Two));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void HighCardThreeCompoundedTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Eight));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Diamond, Value.Ten));
        array1.add(new Card(Suit.Spade, Value.Jack));
        array1.add(new Card(Suit.Heart, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Two));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.King));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void ExactlySameValueTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Jack));
        array1.add(new Card(Suit.Club, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Diamond, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Two));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),0);
    }

    @Test
    public void HighCardAndPairTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Three));
        array1.add(new Card(Suit.Heart, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void PairCompareGeneralTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Three));
        array1.add(new Card(Suit.Heart, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void PairCompareAceTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Ace));
        array1.add(new Card(Suit.Heart, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void TwoPairOnePairTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Ace));
        array1.add(new Card(Suit.Heart, Value.Five));
        array1.add(new Card(Suit.Diamond, Value.Three));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void TwoPairCompareGeneralTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Seven));
        array1.add(new Card(Suit.Heart, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Three));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void TwoPairTest() {
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Seven));
        array1.add(new Card(Suit.Heart, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Three));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1, sequence2), 1);
    }

    @Test
    public void TwoPairCompareAceTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Ace));
        array1.add(new Card(Suit.Heart, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Three));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void TwoPairCompoundedTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Six));
        array1.add(new Card(Suit.Heart, Value.Jack));
        array1.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void TwoPairHighCardTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Ten));
        array1.add(new Card(Suit.Heart, Value.Jack));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void ThreeOfAKindGeneralTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ten));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        array2.add(new Card(Suit.Heart, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void ThreeOfAKindAceTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ace));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void ThreeOfAKindTwoPairTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Club, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Six));
        array1.add(new Card(Suit.Club, Value.Three));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ace));
        array2.add(new Card(Suit.Club, Value.Two));
        array2.add(new Card(Suit.Club, Value.Three));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void ThreeOfAKindOnePairTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Eight));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ace));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void ThreeOfAKindHighCardTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Eight));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ace));
        array2.add(new Card(Suit.Club, Value.Six));
        array2.add(new Card(Suit.Diamond, Value.Ace));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void SequenceGeneralTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Nine));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Ten));
        array1.add(new Card(Suit.Club, Value.Jack));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ace));
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Diamond, Value.Eight));
        array2.add(new Card(Suit.Heart, Value.Nine));
        array2.add(new Card(Suit.Diamond, Value.Ten));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void SequenceAceTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Ten));
        array1.add(new Card(Suit.Club, Value.Jack));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Nine));
        array2.add(new Card(Suit.Spade, Value.Ten));
        array2.add(new Card(Suit.Club, Value.Jack));
        array2.add(new Card(Suit.Diamond, Value.King));
        array2.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),1);
    }

    @Test
    public void SequenceThreeOfAKindTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Six));
        array1.add(new Card(Suit.Spade, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        array1.add(new Card(Suit.Diamond, Value.Queen));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ten));
        array2.add(new Card(Suit.Club, Value.Queen));
        array2.add(new Card(Suit.Diamond, Value.King));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void SequenceTwoPairTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Spade, Value.Eight));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Eight));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Ten));
        array2.add(new Card(Suit.Club, Value.Queen));
        array2.add(new Card(Suit.Diamond, Value.King));
        array2.add(new Card(Suit.Heart, Value.Ace));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

    @Test
    public void SequenceHighCardTest(){
        ArrayList<Card> array1 = new ArrayList<>();
        array1.add(new Card(Suit.Club, Value.Seven));
        array1.add(new Card(Suit.Diamond, Value.Ace));
        array1.add(new Card(Suit.Spade, Value.Two));
        array1.add(new Card(Suit.Diamond, Value.King));
        array1.add(new Card(Suit.Diamond, Value.Eight));
        Sequence sequence1 = new Sequence(array1);

        ArrayList<Card> array2 = new ArrayList<>();
        array2.add(new Card(Suit.Club, Value.Seven));
        array2.add(new Card(Suit.Club, Value.Eight));
        array2.add(new Card(Suit.Diamond, Value.Nine));
        array2.add(new Card(Suit.Heart, Value.Ten));
        array2.add(new Card(Suit.Diamond, Value.Jack));
        Sequence sequence2 = new Sequence(array2);

        assertEquals(Comparator.compareSequence(sequence1,sequence2),-1);
    }

}
