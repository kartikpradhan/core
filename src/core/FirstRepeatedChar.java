package core;
public class FirstRepeatedChar {
    public static void main(String[] args) {
        String string = "mgeeksffoorrgeeks";
        int index = 0;
        char fnc = ' ';
       
       if(string.length()==0){
         System.out.println("EMPTY STRING");
       }
       System.out.println();
       
        for (char i : string.toCharArray()) {
            if (string.indexOf(i) != string.lastIndexOf(i)) {
                fnc = i;
                break;
            }
            else {
                index += 1;
            }
        }
        System.out.println(index);
        System.out.println(string.length());
        if (index == string.length()) {
            System.out.println("All characters are repeating");
        }
        else {
            System.out.println("First non-repeating character is " + fnc);
        }
    }
}