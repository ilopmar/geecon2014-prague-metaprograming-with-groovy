class Hello {
    void sayHi(String name) {
        println "Hello ${name}"
    }
}

Hello.metaClass.invokeMethod = { String methodName, args ->
    println "Invoking method '${methodName}' with args '${args}'"

    def method = Hello.metaClass.getMetaMethod(methodName, args)
    method?.invoke(delegate, args)
}

def hello = new Hello()

hello.sayHi("GeeCon Prague!")
hello.anotherMethod()