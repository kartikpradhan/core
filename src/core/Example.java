package core;
import java.util.StringJoiner;  
public class Example extends Adapter{  
    public static void main(String[] args) {  
    	/* Passing comma(,) as delimiter and opening bracket
    	 * "(" as prefix and closing bracket ")" as suffix
    	 */
        StringJoiner mystring = new StringJoiner(",", "(", ")");    
          
        // Joining multiple strings by using add() method  
        mystring.add("Negan");  
        mystring.add("Rick");  
        mystring.add("Maggie");  
        mystring.add("Daryl");  
                  
        // Displaying the output String
        System.out.println(mystring);  
        
    }  
}
interface Intref{
    public void m1();
      public void m2();
      public void m3();
      public void m4();
      public void m5();
      public void m6();
      public void m7();
      public void m8();
      public void m9();
      public void m10();
}
 
abstract class Adapter implements Intref{
      // providing the empty implementation 
    public void m1(){};
      public void m2(){};
    public void m3(){};
    public void m4(){};
    public void m5(){};
    public void m6(){};
    public void m7(){};
    public void m8(){};
    public void m9(){};
    public void m10(){};
}