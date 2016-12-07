package lection_first.default_static_method;

import java.util.Comparator;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * Created by olegsheliakin on 02/12/16.
 */
interface Printer {
    static void print(){
        System.out.println("print in interface");
    }
}

class PrinterImpl {

    public void print (){
        System.out.println("print in class");
    }
}

public class UsingStaticMethod {

    public static void main(String[] args) {

        PrinterImpl printer = new PrinterImpl();
        printer.print();


        Predicate<String> isEqualHello = Predicate.isEqual("Hello");

        Function<String, String> identity = Function.identity();
        Comparator<String> naturalOrder = Comparator.naturalOrder();
        Comparator<String> reverseOrder = Comparator.reverseOrder();


        Comparator<String> nullLessThanNonNull = Comparator.nullsFirst(String::compareToIgnoreCase);
        Comparator<String> nullGreaterThanNonNull = Comparator.nullsLast(String::compareToIgnoreCase);

        System.out.println(isEqualHello.test("Hello"));
        System.out.println(identity.apply("identity"));
        System.out.println(naturalOrder.compare("a", "b"));
        System.out.println(reverseOrder.compare("a", "b"));
        System.out.println(nullLessThanNonNull.compare(null, ""));
        System.out.println(nullGreaterThanNonNull.compare(null, ""));
    }

}
