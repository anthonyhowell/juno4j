package juno4j;

import juno4j.cache.CachingDelegate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by anthony on 8/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class CacheTest {

    @Test
    public void run() {
        Juno.getInstance()
                .people()
                    .delegate()
                        .chain(new CachingDelegate());

        Juno.getInstance()
                .people()
                    .findAll();
    }

}
