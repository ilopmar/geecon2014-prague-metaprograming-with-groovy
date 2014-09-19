class SpidermanPower {
    String spiderSense() {
        "Using spider-sense..."
    }
}

class SupermanPower {
    String fly() {
        "Flying..."
    }
}

@Mixin([SpidermanPower])
class Person {}

def person = new Person()
assert person.spiderSense() == "Using spider-sense..."
assert !(person instanceof SpidermanPower)

Person.mixin SupermanPower
assert person.fly()  == "Flying..."
assert !(person instanceof SupermanPower)