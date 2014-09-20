trait SpidermanPower {
    String spiderSense() {
        "Using spider-sense..."
    }
}

trait SupermanPower {
    String fly() {
        "Flying..."
    }
}


class Person implements SpidermanPower {}

def person = new Person()
assert person.spiderSense() == "Using spider-sense..."
assert person instanceof SpidermanPower

def person2 = person.withTraits SupermanPower
assert person2.fly() == "Flying..."
assert person2 instanceof SupermanPower
