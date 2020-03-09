package main;

import java.util.Scanner;

public class main{


    public static void main(String [] args)throws Exception{
        Scanner s = new Scanner(System.in);
        String in= "";
        System.out.println("Choose between launching in console [con] or application [app]:");
        try{
            in = s.nextLine();
        }
        catch(Exception e){
            System.out.println("U did wrong!");
        }

        if(in.contains("con")) resources.ConsolePoker.main(args);
        else if(in.contains("app")) resources.Loader_main.main(args);
        s.close();


    }

}
