package tarea.Ejercicio2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2_1 {
    //Imperativa
    public static String reverseWord(String s) {
        // Finding the index of the whitespaces
        int x = s.indexOf("");
        //Base condition
        if(x == -1)
            return s;
        //Recursive call
        return reverse(s.substring(x+1)) +" "+ s.substring(0, x);
    }

    //Declarativa
    public static String reverse(String string) {
        return Stream.of(string)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        //Imperativa
        System.out.println(reverseWord("IMPERATIVA: HOLA"));
        //Declarativa
        System.out.println(reverse("DECLARATIVA: HOLA"));
    }

}
