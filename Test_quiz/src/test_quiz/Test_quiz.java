/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_quiz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author samarth
 */
public class Test_quiz {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
      //  int a[] ;
      // int l= a.length;
       int[] num = new int[5];
      // a.add;
      ArrayList<String> list = new ArrayList<String>() ;

list.add( "Andy" );
list.add( "Bart" );
list.add( "Carl" );
list.add( "Doug" );
list.add( "Elmo" );

String s = "Hello";
String Reverse ="";
ArrayList<String> word = new ArrayList();
int wordLength = s.length();
for(int i=0; i<wordLength;i++)
{
    word.add(s.substring(i,1));
}
for(int j=wordLength ; j>0;j--)
{
    Reverse=Reverse+word.get(j-1);
    
}
System.out.print(Reverse);



//list.add(4,"sfgsfg");
//list.add("sandhy");
//list.set(2,"divta");
list.remove(2);
             System.out.print(" " + 12);     

System.out.print(list);
         
                
        // TODO code application logic here
        
        
    }
    
}
