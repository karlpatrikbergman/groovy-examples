package basic

def half(def value) {
    value/2
}

Number half(Number value) {
    value/2
}

System.out.println(half(10))

/****/

x = 1
int y = 2

public bar() {
    assert x == 1
    try {
        assert y == 2
    } catch (groovy.lang.MissingPropertyException e) {
        println "error caught"
    }
}
bar()
