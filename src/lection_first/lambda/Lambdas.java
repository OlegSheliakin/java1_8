package lection_first.lambda;

import sun.applet.Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Oleg on 13.11.2016.
 */
public class Lambdas {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = String::getBytes;
    }
}
