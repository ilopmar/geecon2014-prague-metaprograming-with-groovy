class Utils {
}

def utilsInstance = new Utils()
assert Utils.metaClass =~ /MetaClassImpl/


Utils.metaClass.version = "3.0"
utilsInstance.metaClass.released = true
assert Utils.metaClass =~ /ExpandoMetaClass/


assert utilsInstance.version == "3.0"
assert utilsInstance.released == true
