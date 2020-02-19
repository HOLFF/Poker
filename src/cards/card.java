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

    public static card[] cardarray(){
        card[] cardarray=new card[52];
        for (byte i = 0;i<=3;i++){
            for(int j=1;j<=13;j++){
                cardarray[i*13+j-1]=new card(j,i);
            }
        }
        return cardarray;
    }

    public static card[] randcard(card[]cardlist,int number){
        card[] randcards=new card[number];
        for(int i=1;i<=number;i++){

        }
        return randcards;
    }

    public static void print(card[] ca){
        for (int i = 0;i<ca.length;i++){
            System.out.println("Value: "+ca[i].getVal()+" Colour: "+ca[i].getCol());
        }
    }

}
