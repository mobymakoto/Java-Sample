package com.moby.jms.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JmsConnectorTest.class, JmsReceiverTest.class,
        JmsSenderTest.class, ParameterLoaderTest.class,
        ParameterRepositoryTest.class })
public class AllTests {

}
