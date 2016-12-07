package lection_first.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Oleg on 13.11.2016.
 */
public final class MethodReference {

    public static void main(String[] args) {

        MethodReference methodReference = new MethodReference();

        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6, 7);
        List<Character> chars = Arrays.asList('h', 'e', 'l', 'l', 'o');

        //functional interface Consumer<T>
        integers.forEach(methodReference::nonStaticOut);
        System.out.println("");
        integers.forEach(MethodReference::staticOut);
        System.out.println("");

        BinaryOperator<Integer> binaryOperator = methodReference::compare;

        chars.forEach(methodReference::nonStaticOut);
        System.out.println("");
        chars.forEach(MethodReference::staticOut);
        System.out.println("");

        Function<Actor, String> mapToString = Actor::getName;

        PersonFactory<Actor> personFactory = Actor::new;

        List<Actor> actors = Arrays.asList(new Actor("Tom Hardy"), new Actor("Christian Bale"), new Actor("Morgan Freeman"));
        actors.forEach(Actor::printYourself);
    }

    void nonStaticContext(List<Integer> integers) {
        integers.forEach(this::nonStaticOut);
    }

    public String getName() {
        return "";
    }

    static <T> void staticOut(T t) {
        System.out.print(t);
    }

    <T> void nonStaticOut(T integer) {
        System.out.print(integer);
    }

    Integer compare (Integer i1, Integer i2){
        return i2.compareTo(i1);
    }

    @FunctionalInterface
    interface PersonFactory<P> {
        P create(String name);
    }
}

