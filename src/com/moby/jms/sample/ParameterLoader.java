package com.moby.jms.sample;

import java.io.IOException;
import java.util.Properties;

public class ParameterLoader {

    private static final String PROPERTY_FILE = "jms.properties";
    private static final String ATTR_FACTORY_NAME = "jms.factory";
    private static final String ATTR_PROVIDER_URL = "jms.provider_url";
    private static final String ATTR_QUEUE_CONNECTION_FACTORY = "jms.queue.connection.factory";
    private static final String ATTR_QUEUE_NAME = "jms.queue.name";
    private static final String ATTR_TOPIC_CONNECTION_FACTORY = "jms.topic.connection.factory";
    private static final String ATTR_TOPIC_NAME = "jms.topic.name";

    private Properties prop = new Properties();

    protected ParameterLoader() throws JMSConnectorException {
        try {
            load();
        } catch(IOException e) {
           throw new JMSConnectorException(e);
        }
    }

    protected String getFactoryName() {
        return prop.getProperty(ATTR_FACTORY_NAME);
    }

    protected String getProviderUrl() {
        return prop.getProperty(ATTR_PROVIDER_URL);
    }

    protected String getQueueConnectionFactory() {
        return prop.getProperty(ATTR_QUEUE_CONNECTION_FACTORY);
    }

    protected String getQueueName() {
        return prop.getProperty(ATTR_QUEUE_NAME);
    }

    protected String getTopicConnectionFactory() {
        return prop.getProperty(ATTR_TOPIC_CONNECTION_FACTORY);
    }

    protected String getTopicName() {
        return prop.getProperty(ATTR_TOPIC_NAME);
    }

    private void load() throws IOException {
            prop.load(this.getClass().getResourceAsStream(PROPERTY_FILE));
    }

}
