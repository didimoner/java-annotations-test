package com.didimoner.annotations;

public class SampleTest {

    private static final int SOME_CONST = 5;
    private String someField = "Hi";

    public SampleTest() {
        // no args default constructor
    }

    public SampleTest(int a) {
        // additional constructor
    }

    @TestRunner.Test
    public void publicMethod() throws Exception {
        System.out.println("I'm a public method");

        throw new Exception("BLAH");
    }

    @TestRunner.Test
    public static void methodTwo() {
        System.out.println("I'm a public static method");

    }

    public void unannotatedMpublicMethod() {
        System.out.println("I'm an unannotated public method (should not be called)");
    }

    @TestRunner.Test
    protected void protectedMethod() {
        System.out.println("I'm a protected method (should not be called)");
    }

    @TestRunner.Test
    private void privateMethod() {
        System.out.println("I'm a private method (should not be called)");
    }

    @TestRunner.Test
    void packagePrivateMethod() {
        System.out.println("I'm a package-private method (should not be called)");
    }

}