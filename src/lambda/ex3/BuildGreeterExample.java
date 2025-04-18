package lambda.ex3;

import lambda.StringFunction;

public class BuildGreeterExample {

    public static StringFunction buildGreeter(String greeting) {
        return name -> greeting + ", " + name;

    }

    public static void main(String[] args) {
        System.out.println(buildGreeter("Hello").apply("Java"));
        System.out.println(buildGreeter("Hi").apply("Lambda"));
    }
}
