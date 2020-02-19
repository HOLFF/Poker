import cards.*;

import java.util.Arrays;


public class main {

    public static void main(String[] args){
        final int numhand=5;
        final int numcols=4;
        final int numvals=13;
        final int programruns=100000000;
        int[] numofocc=new int[10];
        final int[] testcol={1,1,1,1,2};    //colors used for testing
        final int[] testval={7,8,9,6,5};    //values used for testing

        card[] cards=card.cardarray(numcols,numvals);
        //card.print(cards);                //printing out cards
        for(int i = 0; i<programruns;i++) {
            card[] randcards = card.randcard(cards, numhand);
            //card.print(randcards);              //printing chosen number of cards picked randomly from full stash
            hand drawn = new hand(randcards);
            //drawn.setCol(testcol);
            //drawn.setVal(testval);
            int comb = hand.getcomb(drawn);
            //System.out.println(drawn.getCol());   //printing out colours of cards in hand
            //System.out.println(drawn.getVal());    //printing out values of cards in hand
            //System.out.println(comb);
            numofocc[comb]+=1;
        }
        System.out.println(Arrays.toString(numofocc));
        for (int i=0;i<10;i++){
            System.out.println(numofocc[i]/(double)programruns*100);
        }

        /*
        * codes for combinations
        * high card                 :0
        * one pair                  :1
        * two pair                  :2
        * three of a kind           :3
        * straight                  :4
        * flush                     :5
        * full house                :6
        * four of a kind            :7
        * straight flush            :8
        * royal flush               :9
        * */



    }
}
