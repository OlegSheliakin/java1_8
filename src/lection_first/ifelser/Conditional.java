package lection_first.ifelser;

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
    private Predicate<T> condition;

    private Conditional(T variable, Predicate<T> condition) {
        Objects.requireNonNull(variable);
        Objects.requireNonNull(condition);
        this.variable = variable;
        this.condition = condition;
    }

    private Conditional(T variable, boolean isSatisfied) {
        Objects.requireNonNull(variable);
        this.variable = variable;
        this.condition = t -> isSatisfied;
    }

    private Conditional(T variable, boolean isSatisfied, boolean isTerminated) {
        Objects.requireNonNull(variable);
        this.variable = variable;
        this.condition = t -> isSatisfied;
        this.isTerminated = isTerminated;
    }

    public static <T> Conditional<T> of(T variable) {
        Objects.requireNonNull(variable);
        return new Conditional<>(variable, true);
    }

    public static <T> Conditional<T> of(T variable, Predicate<T> condition) {
        Objects.requireNonNull(variable);
        Objects.requireNonNull(condition);
        return new Conditional<>(variable, condition);
    }

    public Conditional<T> toContinue(){
        return new Conditional<>(variable, true, false);
    }

    //set condition
    public Conditional<T> is(Predicate<T> condition) {
        Objects.requireNonNull(condition);
        this.condition = condition;
        return this;
    }

    //set condition
    public Conditional<T> isNot(Predicate<T> condition) {
        Objects.requireNonNull(condition);
        this.condition = condition.negate();
        return this;
    }

    //set condition
    public Conditional<T> isNotNull() {
        this.condition = t -> t != null;
        return this;
    }

    //set condition
    public Conditional<T> isNull() {
        this.condition = t -> t == null;
        return this;
    }

    //if
    public Conditional<T> then(Consumer<T> doThen) {
        Objects.requireNonNull(doThen);
        if (condition.test(variable)) {
            doThen.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    // if with condition
    public Conditional<T> thenIf(Predicate<T> condition, Consumer<T> doThen) {
        Objects.requireNonNull(condition);
        Objects.requireNonNull(doThen);
        if (condition.test(variable)) {
            doThen.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    //add condition
    public Conditional<T> and(Predicate<T> condition) {
        Objects.requireNonNull(condition);
        this.condition = this.condition.and(condition);
        return this;
    }

    //add condition
    public Conditional<T> andNot(Predicate<T> condition) {
        Objects.requireNonNull(condition);
        this.condition = this.condition.and(condition.negate());
        return this;
    }

    //add condition
    public Conditional<T> or(Predicate<T> condition){
        Objects.requireNonNull(condition);
        this.condition = this.condition.or(condition);
        return this;
    }

    //add condition
    public Conditional<T> orNot(Predicate<T> condition){
        Objects.requireNonNull(condition);
        this.condition = this.condition.or(condition.negate());
        return this;
    }

    // irOrElse
    public Conditional<T> ifOrElse(Consumer<T> doIf, Consumer<T> doElse) {
        Objects.requireNonNull(doIf);
        Objects.requireNonNull(doElse);
        isTerminated = true;
        if (condition.test(variable)) {
            doIf.accept(variable);
        } else {
            doElse.accept(variable);
        }
        return this;
    }

    //else if - can be terminated
    public Conditional<T> orElseThen(Predicate<T> condition, Consumer<T> doElseThen) {
        Objects.requireNonNull(doElseThen);
        Objects.requireNonNull(condition);
        if (condition.test(variable) && !isTerminated) {
            doElseThen.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    //else - can be terminated
    public Conditional<T> orElse(Consumer<T> doElse) {
        Objects.requireNonNull(doElse);
        if (!isTerminated) {
            doElse.accept(variable);
            isTerminated = true;
        }
        return this;
    }

    //
    public <R> Conditional<R> flatMap(Function<T, Conditional<R>> function) {
        Objects.requireNonNull(function);
        return new Conditional<>(function.apply(variable).get(), condition.test(variable), isTerminated);
    }

    public <R> Conditional<R> map(Function<T, R> function) {
        Objects.requireNonNull(function);
        return new Conditional<>(function.apply(variable), condition.test(variable), isTerminated);
    }

    // if - throw exception
    public <X extends Throwable> Conditional<T> thenThrow(Supplier<? extends X> exceptionSupplier) throws X {
        Objects.requireNonNull(exceptionSupplier);
        if (condition.test(variable)) {
            isTerminated = true;
            throw exceptionSupplier.get();
        }
        return this;
    }

    // if - throw exception
    public <X extends Throwable> Conditional<T>  thenThrowIf(Predicate<T> condition, Supplier<? extends X> exceptionSupplier) throws X {
        Objects.requireNonNull(condition);
        Objects.requireNonNull(exceptionSupplier);
        if (condition.test(variable)) {
            isTerminated = true;
            throw exceptionSupplier.get();
        }
        return this;
    }

    //else if - throw exception (can be terminated)
    public <X extends Throwable> Conditional<T> orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        Objects.requireNonNull(exceptionSupplier);
        if (condition.negate().test(variable) && !isTerminated) {
            isTerminated = true;
            throw exceptionSupplier.get();
        } else {
            return this;
        }
    }

    //if-return - you should call get()
    public Conditional<T> thenReturn() {
        if (condition.test(variable)) {
            isTerminated = true;
        }
        return this;
    }

    //if-return - you should call get()
    public Conditional<T> thenReturn(Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        if (condition.test(variable)) {
            isTerminated = true;
            Conditional.of(supplier.get());
        }
        return this;
    }

    public Conditional<T> orElseReturn(Supplier<T> doReturn) {
        Objects.requireNonNull(doReturn);
        if (condition.negate().test(variable) && !isTerminated) {
            isTerminated = true;
            return Conditional.of(doReturn.get());
        }
        return this;
    }

    public T get() {
        return this.variable;
    }
}

