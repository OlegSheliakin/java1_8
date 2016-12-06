package lection_first.lambda.closure;

/**
 * Created by Oleg on 12.11.2016.
 */
public class ClosureVariable <T>{

    private T t;

    public ClosureVariable(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static <T> ClosureVariable<T> of (T t){
        return new ClosureVariable<>(t);
    }
}
