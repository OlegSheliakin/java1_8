package lection_second;

import java.util.Map;

/**
 * Created by Oleg on 10.12.2016.
 */
public class Utils {

    public static  <K, V> void printMap (Map<K, V> map){
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }

}
