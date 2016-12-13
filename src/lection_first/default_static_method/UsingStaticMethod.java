package lection_first.default_static_method;

/**
 * Created by olegsheliakin on 02/12/16.
 */
interface Printer {

    static void print(){
        System.out.println("print in interface");
    }
}

class PrinterImpl implements Printer{

    public void print (){
        System.out.println("print in class");
    }
}
public class UsingStaticMethod {

    public static void main(String[] args) {
        //Printer.print();

        PrinterImpl printer = new PrinterImpl();
        printer.print();




    }

}
