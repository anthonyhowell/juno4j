package juno4j.delegation;

import juno4j.people.PeopleDelegate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony on 8/18/16.
 */
public class PeopleCachingDelegate extends ChainableDelegate<PeopleDelegate> implements PeopleDelegate {

    public PeopleCachingDelegate(Integer order) {
        super(order);
    }

    @Override
    public List<String> findAll() {
        System.out.println("Cache: Good \n\n");
        return Arrays.asList("(C) John Doe", "(C) Elvis Presley");
    }

    @Override
    public List<String> findByFirstName(String firstName) {
        System.out.println("Cache: Bad");
        System.out.println("Attempting to forwarding request");

        if (this.getForward() != null) {
            List<String> forwardedResult = ((PeopleDelegate) this.getForward()).findByFirstName(firstName);

            System.out.println("Caching forwarded response");

            if (forwardedResult != null) {
                System.out.println("Cached: " + forwardedResult.toString());
                return forwardedResult;
            }
        }

        System.out.println("Forwarded request failed to produce a result \n\n");
        return null;
    }

}
