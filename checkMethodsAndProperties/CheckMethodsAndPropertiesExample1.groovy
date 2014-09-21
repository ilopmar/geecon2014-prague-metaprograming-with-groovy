class Person {
    String name
    Integer age

    String sayHi() {
        "Hi, my name is ${name} and I'm ${age}"
    }

    String sayHiTo(String name) {
        "Hi ${name}, how are you?"
    }
}

def p = new Person(name: 'Iván', age: 34)

assert p.respondsTo('sayHi')
assert p.respondsTo('sayHiTo', String)
assert !p.respondsTo('goodbye')

assert p.hasProperty('name')
assert !p.hasProperty('country')


def p2 = new Person()
p2.metaClass.country = 'Spain'
assert p2.hasProperty('country')
