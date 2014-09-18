// Execute with:
// gradle build
// groovy -cp build/libs/string-extensions-1.0.jar ExtensionExample1.groovy

assert "Lorem ipsu..."  == "Lorem ipsum dolor sit amet".truncate(10, true)
