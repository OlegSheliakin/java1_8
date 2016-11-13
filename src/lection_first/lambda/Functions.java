package lection_first.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Oleg on 13.11.2016.
 */
public class Functions {

    public static void main(String[] args) {

        //Predicates are boolean-valued functions of one argument. The interface contains various default methods for composing predicates to complex logical terms (and, or, negate)
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        //Functions accept one argument and produce a result. Default methods can be used to chain multiple functions together (compose, andThen)
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"

        //Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.
        Supplier<Actor> personSupplier = Actor::new;
        personSupplier.get();   // new Actor

        //Consumers represents operations to be performed on a single input argument.
        Consumer<Actor> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Actor("any actor"));

        //Comparators are well known from older versions of Java. Java 8 adds various default methods to the interface.
        Comparator<Actor> comparator = (actor1, actor2) -> actor1.getName().compareTo(actor2.getName());

        Actor actor1 = new Actor("Tom Hardy");
        Actor actor2 = new Actor("Christian Bale");

        comparator.compare(actor1, actor2);             // > 0
        comparator.reversed().compare(actor1, actor2);  // < 0
    }

}
