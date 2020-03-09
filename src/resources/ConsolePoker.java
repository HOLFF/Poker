package resources;

import cards.card;
import cards.hand;

import java.util.Scanner;

public class ConsolePoker {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int numhand;
        int numcols;
        int numvals;
        int runs;

        try {
            System.out.println("Input number of cards in hand:");
            numhand = s.nextInt();
            System.out.println("Input number of colors:");
            numcols = s.nextInt();
            System.out.println("Input number of values per color:");
            numvals = s.nextInt();
            System.out.println("Input number of runs:");
            runs = s.nextInt();
        }
        catch(Exception E){
            numhand = 5;
            numcols = 4;
            numvals = 13;
            runs = 10000000;
            System.out.println("u did sth wrong used default values");
        }

        s.close();

        int[] numofocc=new int[10];

        card[] cards=card.cardarray(numcols,numvals);
        for(int i = 0; i<runs;i++) {
            card[] randcards = card.randcard(cards, numhand);
            hand drawn = new hand(randcards);
            int comb = hand.getcomb(drawn);
            numofocc[comb]+=1;
        }

        for (int i: numofocc) {
            System.out.print((i/(double)runs)*100);
            System.out.print("% , ");
        }
        System.out.println();
        System.out.println("50,12% , 42,26 % , 4,75 % , 2,11 % , 0,392 % , 0,197 % , 0,144 % , 0,0240 % , 0,00139 % , 0,000154 %");
    }
}
