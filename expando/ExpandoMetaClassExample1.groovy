class StringUtils {
    static String truncate(String text, Integer length, Boolean overflow = false) {
        text.take(length) + (overflow ? '...' : '')
    }
}

String chuckIpsum = "If you can see Chuck Norris, he can see you.\
If you can not see Chuck Norris you may be only seconds away from death"

println StringUtils.truncate(chuckIpsum, 72)
println StringUtils.truncate(chuckIpsum, 72, true)

String.metaClass.truncate = { Integer length, Boolean overflow = false ->
    delegate.take(length) + (overflow ? '...' : '')
}

assert chuckIpsum.truncate(72, true) == StringUtils.truncate(chuckIpsum, 72, true)