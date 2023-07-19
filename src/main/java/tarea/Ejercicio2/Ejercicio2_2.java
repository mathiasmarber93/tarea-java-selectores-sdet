package tarea.Ejercicio2;

import java.util.stream.IntStream;

public class Ejercicio2_2 {

    //Imperativa
    public static void fizzBuzzImperative(){
        for(int i = 1; i <= 40; i++){
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Fizz");
            } else if (i % 7 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
    //Declarativa
    public static void fizzBuzzDeclarative(){
        int end = 40;
        IntStream.rangeClosed(1, end)
                .mapToObj(
                        i -> i % 5 == 0 ?
                                (i % 7 == 0 ? "FizzBuzz" : "Fizz") :
                                (i % 7 == 0 ? "Buzz" : i))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        //IMPERATIVA
        fizzBuzzImperative();
        System.out.println("-----------------------------");
        //DECLARATIVA
        fizzBuzzDeclarative();
    }
}
