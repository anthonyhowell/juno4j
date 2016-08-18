package test.java;

import com.juno4j.core.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by anthony on 8/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class SampleTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Config config;

    @Configuration
    @ComponentScan(basePackages = "com.juno4j")
    static class ContextConfiguration implements InitializingBean {

        public void afterPropertiesSet() throws Exception {
            System.setProperty("host", "http://api.juno.com/v1");
            System.setProperty("client.key", "key_[iejf;laksjdvqea;ksldfjasdf");
            System.setProperty("client.secret", "secret_apsoifha;elkfha;oewhfasjdf");

        }

    }

    @Test
    public void run() {
        return;
    }

}
