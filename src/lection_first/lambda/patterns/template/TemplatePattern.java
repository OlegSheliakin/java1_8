package lection_first.lambda.patterns.template;

/**
 * Created by olegsheliakin on 23/11/16.
 */

@FunctionalInterface
interface Step {
    void perform();
}

class FunctionalCrossCompiler {

    private Step collectSource;
    private Step compileToTarget;

    FunctionalCrossCompiler(Step collectSource, Step compileToTarget) {
        this.collectSource = collectSource;
        this.compileToTarget = compileToTarget;
    }

    final void crossCompile() {
        collectSource.perform();
        compileToTarget.perform();
    }
}

abstract class CrossCompiler {

    final void crossCompile() {
        collectSource();
        compileToTarget();
    }

    //Template methods
    abstract void collectSource();

    abstract void compileToTarget();
}

class IPhoneCompiler extends CrossCompiler {
    void collectSource() {
        System.out.println("IPhone: start building...");
    }

    void compileToTarget() {
        System.out.println("IPhone: Something went wrong!!!");
    }
}

class AndroidCompiler extends CrossCompiler {
    protected void collectSource() {
        System.out.println("Android: start building...");
    }

    protected void compileToTarget() {
        System.out.println("Android: Build is successful!!!");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {
        CrossCompiler iphone = new IPhoneCompiler();
        iphone.crossCompile();
        CrossCompiler android = new AndroidCompiler();
        android.crossCompile();


    }
}
