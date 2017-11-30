package cn.hfbin.PubSub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

class Publisher {
    private ActiveMQConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private Destination destination;
    public Publisher() throws JMSException {
        factory = new ActiveMQConnectionFactory(
                "hfbin",
                "hfbin",
                "tcp://localhost:61616");
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        destination = session.createTopic("Topic");
        producer = session.createProducer(destination);
    }
    public void sendMessage() throws JMSException {
        for(int i = 0; i < 5; i++)
        {
            TextMessage message = session.createTextMessage("I Tell You >> "+i);
            System.out.println("生产数据: " + "I Tell You >> "+i);
            producer.send(destination, message);
        }
        connection.close();
    }
    public static void main(String[] args) throws JMSException {
        Publisher publisher = new Publisher();
        publisher.sendMessage();
    }
}
