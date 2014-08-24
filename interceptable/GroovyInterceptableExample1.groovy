class Person implements GroovyInterceptable {

    String name
    Integer age

    public Object getProperty(String propertyName) {
        println "Getting property '${propertyName}'"
        return this.@"${propertyName}"
    }

    public void setProperty(String propertyName, Object newValue) {
        println "Setting property '${propertyName}' with value '${newValue}'"
        this.@"${propertyName}" = newValue
    }
}

def person = new Person()
person.name = "Iván"
person.age = 34

println "Hello ${person.name}, you're ${person.age}"