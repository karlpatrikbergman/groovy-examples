package methodcall.dynamicinvocation;

/**
 * Single dispatch
 * ---------------
 * If the decision of which version of a method to call
 * is based entirely on the class of the object x, then
 * this is known as single dispatch because an implementation
 * is chosen based on a single type – the type of the
 * instance.
 *
 * För mig är det oklart vilket objekt som åsyftas, det som
 * har metoden eller det som är argumentet
 */
public class JavaSingleDispatch {
    void print(Object object) {
        System.out.println("In print(Object object)");
    }

    void print(String string) {
        System.out.println("In print(String string)");
    }

    public static void main(String[] args) {
        Object arg = "string";
        new JavaSingleDispatch().print(arg);
    }
}
