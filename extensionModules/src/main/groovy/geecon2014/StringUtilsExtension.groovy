// src/main/groovy/geecon2014/StringUtilsExtension.groovy
package geecon2014
class StringUtilsExtension {
    static String truncate(String self, Integer length, Boolean overflow = false) {
        self.take(length) + (overflow ? '...' : '')
    }
}