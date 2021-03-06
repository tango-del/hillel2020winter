import spark.Spark;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Spark.get("/hello", (req, res) -> "Hello World");

        Spark.get("/hello/:name", (req, res) -> {
            return "Hello, " + req.params(":name");
        });

        Spark.get("/sobik", ((request, response) -> "Let's some play"));
    }
}
