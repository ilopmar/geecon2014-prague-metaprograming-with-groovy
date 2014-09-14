class FileBinaryCategory {
    def static leftShift(File file, URL url) {
        def input
        def output

        try {
            input = url.openStream()
            output = new BufferedOutputStream(new FileOutputStream(file))

            output << input
        } finally {
            input?.close()
            output?.close()
        }
    }
}

File tmpFile = File.createTempFile('tmp_', '')

use (FileBinaryCategory) {
    tmpFile << "http://groovy.codehaus.org/images/groovy-logo-medium.png".toURL()
}

println tmpFile
