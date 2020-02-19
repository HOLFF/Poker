package cards;

public class card {
    int val;
    int col;
    public card(int val, int col){
        this.val= val;
        this.col = col;
    }

    public int getVal() {
        return val;
    }

    public int getCol() {
        return col;
    }

    public static card[] cardarray(int numcols,int numvals){
        card[] cardarray=new card[numvals*numcols];
        for (byte i = 0;i<=numcols-1;i++){
            for(int j=1;j<=numvals;j++){
                cardarray[i*numvals+j-1]=new card(j,i);
            }
        }
        return cardarray;
    }

    public static card[] randcard(card[]cardlist,int number){
        card[] randcards=new card[number];
        for(int i=0;i<number;i++){
            int rand=(int)(Math.random()*(cardlist.length-1-i));
            randcards[i]=cardlist[rand];
            card temp=cardlist[rand];
            cardlist[rand]=cardlist[cardlist.length-1-i];
            cardlist[cardlist.length-1-i]=temp;
        }
        return randcards;
    }

    public static void print(card[] ca){
        for (int i = 0;i<ca.length;i++){
            System.out.println("Value: "+ca[i].getVal()+" Colour: "+ca[i].getCol());
        }
    }

}
