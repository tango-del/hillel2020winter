package tests;

import spark.Spark;

public class Test {
    public static void main(String[] args) {
        
    }

    public static void testUserService() {

    }

    public static void testHelloWorld() {
        Spark.get("/hello", (req, res) -> "Hello World");

        Spark.get("/hello/:name", (req, res) -> {
            return "Hello, " + req.params(":name");
        });

        Spark.get("/sobik", ((request, response) -> "Let's some play"));
    }
}
