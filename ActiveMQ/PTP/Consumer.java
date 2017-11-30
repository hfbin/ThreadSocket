package cn.hfbin.PTP;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer  {
    private ActiveMQConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    private Destination destination;

    public Consumer() throws JMSException {
        factory = new ActiveMQConnectionFactory(
                "hfbin",
                "hfbin",
                "tcp://localhost:61616"
        );
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue("queue2");
        consumer = session.createConsumer(destination);
    }

    public void getMessage() throws JMSException {
        consumer.setMessageListener(new Listener());
    }
    class Listener implements MessageListener{

        @Override
        public void onMessage(Message message) {
            if (message instanceof TextMessage){
                try {
                    System.out.println(((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws JMSException {
        Consumer consumer = new Consumer();
        consumer.getMessage();
    }

}
