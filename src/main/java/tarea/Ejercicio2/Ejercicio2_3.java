package tarea.Ejercicio2;

import java.util.stream.LongStream;

public class Ejercicio2_3 {

    public static void factorialImperative(){
        int n=7, fact=1;
        for(int i=1;i<=n;i++) {
            fact=fact*i;
        }
        System.out.println("FACTORIAL IMPERATIVO = " + fact);
    }

    public static void factorialDeclarative() {
        System.out.println("FACTORIAL DECLARATIVO = " + LongStream.rangeClosed(2, 7)
                .reduce(1, (long a, long b) -> a * b));
    }

    public static void main(String[] args) {
        factorialImperative();
        factorialDeclarative();
    }


}
