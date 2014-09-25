package geecon2014

class VersionASTTransformationTest extends GroovyTestCase {

    void testTheVersionIsAdded() {
        assertScript '''
            import geecon2014.Version

            @Version("1.0")
            class MyClass {}

            assert MyClass.VERSION == '1.0'
        '''
    }

    void testTheVersionIsNotAdded() {
        assertScript '''
            class MyClass {}

            try {
                MyClass.VERSION
                // As the VERSION field is not added to the class the exception is thrown
                // and this code is not executed. If the VERSION field exists the test
                // will fail here
                assert false
            } catch (MissingPropertyException mpe) {
                // true
            }
        '''
    }
}