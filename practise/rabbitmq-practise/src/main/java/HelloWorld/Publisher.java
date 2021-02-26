package HelloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    private static final String QUEUE_NAME = "1-hillel-java";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "Sobik";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes());
            System.out.println(" [X] Sent '" + message + "'");
            Thread.sleep(100);
        }

        channel.close();
        connection.close();
    }
}
