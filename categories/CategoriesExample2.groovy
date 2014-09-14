@Category(String)
class StringUtilsAnnotated {
    String truncate(Integer length, Boolean overflow = false) {
        this.take(length) + (overflow ? '...' : '')
    }
}

use (StringUtilsAnnotated) {
    println "Lorem ipsum".truncate(5)
}