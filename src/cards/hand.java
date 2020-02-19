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
        public boolean onepair(){
            for(int i =0;i<val.length-1;i++){
                for(int j =i;j<val.length-1;j++){
                    if(val[j]==val[j+1]){
                        return true;
                    }
                    }
                }
            return false;
        }

        public boolean twopair(){
        int numpair=00;
            for(int i =0;i<val.length-1;i++){
                for(int j =i;j<val.length-1;j++){
                    if(val[j]==val[j+1]){
                        j++;
                        numpair+=1;
                    }
                }
            }
            if(numpair==2)return true;
            else return false;
        }


    public boolean tok(){
        for(int i =0;i<val.length-2;i++){
            for(int j =i;j<val.length-2;j++){
                if(val[j]==val[j+2]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fok(){
        for(int i =0;i<val.length-3;i++){
            for(int j =i;j<val.length-3;j++){
                if(val[j]==val[j+3]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fh() {
        boolean tok=false;
        boolean pair=false;
        for (int i = 0; i < val.length - 2; i++) {
            for (int j = i; j < val.length - 2; j++) {
                if (val[j] == val[j + 1]) {
                    j++;
                    pair = true;
                } else if (val[j] == val[j + 2]) {
                    tok=true;
                    j+=2;
                }
            }

        }
        if(tok&&pair) return true;
        else return false;

    }

    public boolean straight(){
        for(int i = 0;i<val.length-1;i++){
            if(val[i]+1!=val[i+1]) return false;
        }
        return true;
    }

    public int getmaxval(){
        return val[val.length-1];
    }

    public boolean flush(){
        for(int i =0;i<col.length-4;i++){
            for(int j =i;j<col.length-4;j++){
                if(col[j]==col[j+4]){
                    return true;
                }
            }
        }
        return false;


    }


    public String getCol() {
        return Arrays.toString(col);


    }

    public String getVal() {
        return Arrays.toString(val);
    }


    public static int getcomb(hand h){
        if(h.onepair()){
            if (h.twopair()){
                return 2;
            }
            else if(h.tok()){
                if (h.fok()){
                    return 7;
                }
                if(h.fh()){
                    return 6;
                }
                else{
                    return 3;
                }
            }
            else{
                return 1;
            }
        }
        else if(h.straight()){
            if(h.flush()){
                if(h.getmaxval()==13){
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
        else{
            return 0;
        }
    }
}
