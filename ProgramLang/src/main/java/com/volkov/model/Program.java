package com.volkov.model;

public abstract class Program {

    final public void startProgram() {
        writeCode();
        debugCode();
        compileCode();
        testCode();
        recievResult();
    }


    abstract void writeCode();

    abstract void debugCode();

    abstract void compileCode();

    abstract void testCode();


     private void recievResult() {
        System.out.println("Recieved the result of your code");
    }
}
