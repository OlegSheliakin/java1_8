package lection_first.optional;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Oleg on 14.11.2016.
 */
public class ExampleOptional {

    public static void main(String[] args) {

        Optional<String> empty = Optional.empty();

        nullExample(null);
        notNullExample();
        outerExample();
    }

    private static void nullExample (String s){
        Optional<String> stringNull = Optional.ofNullable(s);
        System.out.println(stringNull.orElse("null"));
        System.out.println(stringNull.orElseGet(() -> "null"));

        try {
            stringNull.orElseThrow(() -> new NoSuchElementException("Exception: string is null"));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

    }

    private static void notNullExample (){
        String string = "non null";
        Optional<String> optional = Optional.of(string);
        optional.ifPresent(System.out::println);
    }

    private static void outerExample (){
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);

        Optional.of(createOuter())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    private static Outer createOuter (){
        Outer outer = new Outer();
        Nested nested = new Nested();
        Inner inner = new Inner();
        inner.setFoo("foo");
        nested.setInner(inner);
        outer.setNested(nested);
        return outer;
    }
}
