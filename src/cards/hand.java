package cards;

import java.util.Arrays;

public class hand {
    int[] col;
    int[] val;


    public hand(card[] c) {
        col = new int[c.length];
        val = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            col[i] = c[i].getCol();
            val[i] = c[i].getVal();
        }
            Arrays.sort(val);
            Arrays.sort(col);

    }




        public boolean onepair(){       //searching for one pair in hand
            for(int i =0;i<val.length-1;i++){
                for(int j =i;j<val.length-1;j++){
                    if(val[j]==val[j+1]){
                        return true;
                    }
                    }
                }
            return false;
        }


        public boolean twopair(){       //searching for two pairs in hand
        int numpair=0;
            for(int i =0;i<val.length-1;i++){
                for(int j =i;j<val.length-1;j++){
                    if(val[j]==val[j+1]){
                        i=j+1;
                        j+=2;
                        numpair+=1;
                    }
                }
            }
            if(numpair==2)return true;
            else return false;
        }


    public boolean tok(){           //searching for three of a kind in hand
        for(int i =0;i<val.length-2;i++){
            for(int j =i;j<val.length-2;j++){
                if(val[j]==val[j+2]){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean fok(){           //searching for four of a kind in hand
        for(int i =0;i<val.length-3;i++){
            for(int j =i;j<val.length-3;j++){
                if(val[j]==val[j+3]){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean fh() {           //searching for a full house
        boolean tok=false;
        boolean pair=false;
        int[] sec= val;

        for (int i = 0; i <sec.length-2;i++){
            if (sec[i]==sec[i+2]){
                sec[i]=-97;
                sec[i+1]=-98;
                sec[i+2]=-99;
                tok = true;
            }
        }
        for (int i = 0; i <sec.length-1;i++){
            if (sec[i]==sec[i+1]){
                pair = true;
            }
        }
        if(pair&&tok) return true;
        else return false;
    }


    public boolean straight(){          //searching for a straight in hand
        if (val[0]==1&&val[0]+1==val[1]&&val[0]+2==val[2]&&val[0]+3==val[3]&&val[4]==13) return true;
        for(int i = 0;i<val.length-1;i++){
            if(val[i]+1!=val[i+1]) return false;
        }
        return true;
    }

    public int getmaxval(){             //getting max val--> used to look for royal flush
        return val[val.length-1];
    }

    public int excheck(){             //checking if the special case for straight is occuring
        return val[0];
    }

    public boolean flush(){             //searching for flush in hand
        for(int i =0;i<col.length-4;i++){
            for(int j =i;j<col.length-4;j++){
                if(col[j]==col[j+4]){
                    return true;
                }
            }
        }
        return false;


    }



    public static int getcomb(hand h){      //getting combination in hand
        if(h.straight()){
            if(h.flush()){
                if(h.getmaxval()==13 && h.excheck()!=1){
                    return 9;
                }
                else{
                    return 8;
                }
            }
            else {
                return 4;
            }
        }
        else if(h.flush()){
            return 5;
        }
        else if(h.onepair()){
            if(h.tok()){
                if (h.fok()){
                    return 7;
                }
                else if(h.fh()){
                    return 6;
                }
                else{
                    return 3;
                }
            }
            else if (h.twopair()){
                return 2;
            }
            else{
                return 1;
            }
        }
        else{
            return 0;
        }
    }


    /*
    * following are just getters and setters used for testing
    * */

    public String getCol() {
        return Arrays.toString(col);
    }

    public String getVal() {
        return Arrays.toString(val);
    }

    public void setCol(int[] col) {
        Arrays.sort(col);
        this.col = col;
    }

    public void setVal(int[] val) {
        Arrays.sort(val);
        this.val = val;
    }
}
