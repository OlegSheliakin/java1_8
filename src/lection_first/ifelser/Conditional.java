package lection_first.ifelser;

import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by olegsheliakin on 23/11/16.
 */
public final class Conditional<T> {

    private final T variable;
    private boolean isTerminated;
    private Predicate<T> predicate;

    private Conditional(T variable, Predicate<T> predicate) {
        this.variable = variable;
        this.predicate = predicate;
    }

    private Conditional(T variable, boolean isSatisfied) {
        this.variable = variable;
        this.predicate = t -> isSatisfied;
    }

    private Conditional(T variable, boolean isSatisfied, boolean isTerminated) {
        this.variable = variable;
        this.predicate = t -> isSatisfied;
        this.isTerminated = isTerminated;
    }

    public static <T> Conditional<T> of(@NotNull T variable) {
        return new Conditional<>(variable, true);
    }

    //set condition
    public Conditional<T> isIf(Predicate<T> predicate) {
        this.isTerminated = false;
        this.predicate = predicate;
        return this;
    }

    //set condition
    public Conditional<T> isIfNot(Predicate<T> predicate) {
        this.isTerminated = false;
        this.predicate = predicate.negate();
        return this;
    }

    //set condition
    public Conditional<T> isNotNull() {
        this.isTerminated = false;
        this.predicate = t -> t != null;
        return this;
    }

    //set condition
    public Conditional<T> isNull() {
        this.isTerminated = false;
        this.predicate = t -> t == null;
        return this;
    }

    //if
    public Conditional<T> then(Consumer<T> doThen) {
        Objects.requireNonNull(doThen);
        if (predicate.test(variable)) {
            doThen.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    // if with predicate
    public Conditional<T> thenIf(Predicate<T> predicate, Consumer<T> doThen) {
        Objects.requireNonNull(doThen);
        if (predicate.test(variable)) {
            doThen.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    //add condition
    public Conditional<T> and(Predicate<T> predicate) {
        this.predicate = this.predicate.and(predicate);
        return this;
    }

    //add condition
    public Conditional<T> andNot(Predicate<T> predicate) {
        this.predicate = this.predicate.and(predicate.negate());
        return this;
    }

    //add condition
    public Conditional<T> or(Predicate<T> predicate){
        this.predicate = this.predicate.or(predicate);
        return this;
    }

    //add condition
    public Conditional<T> orNot(Predicate<T> predicate){
        this.predicate = this.predicate.or(predicate.negate());
        return this;
    }

    // irOrElse
    public Conditional<T> ifOrElse(Consumer<T> doIf, Consumer<T> doElse) {
        Objects.requireNonNull(doIf);
        Objects.requireNonNull(doElse);
        if (predicate.test(variable)) {
            doIf.accept(variable);
            isTerminated = true;
        } else {
            doElse.accept(variable);
        }
        return this;
    }

    //else if - can be terminated
    public Conditional<T> orElseThen(Predicate<T> condition, Consumer<T> doElseIf) {
        Objects.requireNonNull(doElseIf);
        if (condition.test(variable) && !isTerminated) {
            doElseIf.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    //else - can be terminated
    public Conditional<T> orElse(Consumer<T> doElse) {
        Objects.requireNonNull(doElse);
        if (!isTerminated) {
            doElse.accept(variable);
        }
        return this;
    }

    public <R> Conditional<R> map(Function<T, R> function) {
        Objects.requireNonNull(function);
        return new Conditional<>(function.apply(variable), predicate.test(variable), isTerminated);
    }

    // if - throw exception
    public <X extends Throwable> Conditional<T> thenThrow(Supplier<? extends X> exceptionSupplier) throws X {
        Objects.requireNonNull(exceptionSupplier);
        if (predicate.test(variable)) {
            isTerminated = true;
            throw exceptionSupplier.get();
        }
        return this;
    }

    //else if - throw exception (can be terminated)
    public <X extends Throwable> Conditional<T> orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        Objects.requireNonNull(exceptionSupplier);
        if (predicate.negate().test(variable) && !isTerminated) {
            isTerminated = true;
            throw exceptionSupplier.get();
        } else {
            return this;
        }
    }

    //if-return - you should call get()
    public Conditional<T> thenReturn() {
        if (predicate.test(variable)) {
            isTerminated = true;
        }
        return this;
    }

    //if-return - you should call get()
    public Conditional<T> thenReturn(Supplier<T> supplier) {
        if (predicate.test(variable)) {
            isTerminated = true;
            Conditional.of(supplier.get());
        }
        return this;
    }

    public Conditional<T> orElseReturn(Supplier<T> doReturn) {
        Objects.requireNonNull(doReturn);
        if (predicate.negate().test(variable) && !isTerminated) {
            isTerminated = true;
            return Conditional.of(doReturn.get());
        }
        return this;
    }

    public T get() {
        return this.variable;
    }
}
