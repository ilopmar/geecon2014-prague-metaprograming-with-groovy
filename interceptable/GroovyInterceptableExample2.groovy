class Hello implements GroovyInterceptable {

    public Object invokeMethod(String methodName, Object args) {
        System.out.println "Invoking method '${methodName}' with args '${args}'"

        def method = metaClass.getMetaMethod(methodName, args)
        method?.invoke(this, args)
    }

    void sayHi(String name) {
        System.out.println "Hello ${name}"
    }
}

def hello = new Hello()
hello.sayHi("GeeCon Prague!")
hello.anotherMethod()