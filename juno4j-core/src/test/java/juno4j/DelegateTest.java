package juno4j;

import juno4j.delegation.DelegateList;
import juno4j.delegation.PeopleAsyncDelegate;
import juno4j.delegation.PeopleCachingDelegate;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DelegateTest {

    @Before
    public void setUp() throws Exception {
        DelegateList delegates = Juno4J.getInstance().getDelegates();
        delegates.add(new PeopleCachingDelegate(1));
        delegates.add(new PeopleAsyncDelegate(2));
    }

    @Test
    public void findAll() {
        List<String> result = Juno4J.getInstance().people().findAll();

        assertTrue(result.size() > 0);
    }

    @Test
    public void findByFirstName() {
        List<String> result = Juno4J.getInstance().people().findByFirstName("John");

        assertTrue(result.size() > 0);
    }

}
