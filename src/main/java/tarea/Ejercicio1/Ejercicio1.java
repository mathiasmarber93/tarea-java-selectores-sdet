package tarea.Ejercicio1;

import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 - Fibonacci: ");
        Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0]+f[1]})
                .limit(10)
                .map(n -> n[0])
                .forEach(fibNum -> System.out.print(fibNum + " "));
    }
}
