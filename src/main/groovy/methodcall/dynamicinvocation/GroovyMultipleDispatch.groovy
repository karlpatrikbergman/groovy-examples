package methodcall.dynamicinvocation

/**
 * Multiple Dispatch
 * -----------------
 * Multiple dispatch or multimethods is a feature of
 * some programming languages in which a function or
 * method can be dynamically dispatched based on the
 * run-time (dynamic) type or, in the more general
 * case some other attribute, of more than one of its
 * arguments.
 */
class GroovyMultipleDispatch {

    def print(Object o) {
        println "println object"
    }

    def print(String s) {
        println "println string"
    }

    public static void main(String[] args) {
        Object arg = "string"
        print(arg)
    }
}

