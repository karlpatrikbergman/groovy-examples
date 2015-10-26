package metaobjectprogramming


class SimpleExpando {
    def propertyMap = [:]

    def getProperty(String name) {
        propertyMap[name]?: null
    }

    void setProperty(String name, Object value) {
        propertyMap[name] = value
    }

    def invokeMethod(String name, Object args) {
        try {
            metaClass.invokeMethod(name, args)
        } catch (GroovyRuntimeException e) {
            def value = propertyMap[name]
            if (value instanceof Closure) {
                value.setDelegate(this)
                value.call(args)
            }
            else {throw e}
        }
    }
}

