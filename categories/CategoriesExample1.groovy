class StringUtils {
    static String truncate(String text, Integer length, Boolean overflow = false) {
        text.take(length) + (overflow ? '...' : '')
    }
}

use (StringUtils) {
    println "Lorem ipsum".truncate(5)
}

try {
    println "Lorem ipsum".truncate(5)
} catch (MissingMethodException mme) {
    println mme
}