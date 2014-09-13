// Integer
assert '42' == 42.toString()

Integer.metaClass.toString = {
    delegate == 42 ?
        'The answer to life, the universe and everything' :
        String.valueOf(delegate)
}

assert 42.toString() == 'The answer to life, the universe and everything'
assert 100.toString() == '100'


// Boolean
assert false.toBoolean() == false

Boolean.metaClass.toBoolean = { !delegate }
assert false.toBoolean() == true
