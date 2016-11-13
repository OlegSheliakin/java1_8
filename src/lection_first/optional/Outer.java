package lection_first.optional;

/**
 * Created by Oleg on 14.11.2016.
 */
class Outer {
    private Nested nested;
    public Nested getNested() {
        return nested;
    }

    public void setNested(Nested nested) {
        this.nested = nested;
    }
}
class Nested {
    private Inner inner;
    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }
}
class Inner {
    private String foo;
    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
