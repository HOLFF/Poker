package resources;

import cards.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class PokerController {
    public Button go;
    public TextField amcol;
    public TextField amval;
    public TextField amruns;
    public TextField amhand;
    public TextField inf;
    public TextField am0;
    public TextField am1;
    public TextField am2;
    public TextField am3;
    public TextField am4;
    public TextField am5;
    public TextField am6;
    public TextField am7;
    public TextField am8;
    public TextField am9;

    public TextField p0;
    public TextField p1;
    public TextField p2;
    public TextField p3;
    public TextField p4;
    public TextField p5;
    public TextField p6;
    public TextField p7;
    public TextField p8;
    public TextField p9;

    private int numhand;
    private int numcols;
    private int numvals;
    private int runs;



    public void start(){
        try {
            numhand = Integer.parseInt(amhand.getText());
            numcols = Integer.parseInt(amcol.getText());
            numvals = Integer.parseInt(amval.getText());
            runs = Integer.parseInt(amruns.getText());
            inf.setText("");
        }
        catch(Exception E){
            amhand.setText("5");
            amcol.setText("4");
            amval.setText("13");
            amruns.setText("1000000");
            inf.setText("You did something wrong, changed to default values.");
        }
        int[] numofocc=new int[10];
        card[] cards=card.cardarray(numcols,numvals);
        for(int i = 0; i<runs;i++) {
            card[] randcards = card.randcard(cards, numhand);
            hand drawn = new hand(randcards);
            int comb = hand.getcomb(drawn);
            numofocc[comb]+=1;
        }
        am0.setText(Integer.toString(numofocc[0]));
        am1.setText(Integer.toString(numofocc[1]));
        am2.setText(Integer.toString(numofocc[2]));
        am3.setText(Integer.toString(numofocc[3]));
        am4.setText(Integer.toString(numofocc[4]));
        am5.setText(Integer.toString(numofocc[5]));
        am6.setText(Integer.toString(numofocc[6]));
        am7.setText(Integer.toString(numofocc[7]));
        am8.setText(Integer.toString(numofocc[8]));
        am9.setText(Integer.toString(numofocc[9]));

        p0.setText(Double.toString((double)numofocc[0]/runs*100.0));
        p1.setText(Double.toString((double)numofocc[1]/runs*100.0));
        p2.setText(Double.toString((double)numofocc[2]/runs*100.0));
        p3.setText(Double.toString((double)numofocc[3]/runs*100.0));
        p4.setText(Double.toString((double)numofocc[4]/runs*100.0));
        p5.setText(Double.toString((double)numofocc[5]/runs*100.0));
        p6.setText(Double.toString((double)numofocc[6]/runs*100.0));
        p7.setText(Double.toString((double)numofocc[7]/runs*100.0));
        p8.setText(Double.toString((double)numofocc[8]/runs*100.0));
        p9.setText(Double.toString((double)numofocc[9]/runs*100.0));



    }
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
        *
*/
