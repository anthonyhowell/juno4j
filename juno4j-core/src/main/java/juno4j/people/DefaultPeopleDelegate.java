package juno4j.people;


import juno4j.delegation.ChainableDelegate;

import java.util.Arrays;
import java.util.List;

public class DefaultPeopleDelegate extends ChainableDelegate<PeopleDelegate> implements PeopleDelegate {

    public DefaultPeopleDelegate(Integer order) {
        super(order);
    }

    @Override
    public List<String> findAll() {
        return Arrays.asList("(D) Brad Pitt", "(D) Angelina Jolie");
    }

    @Override
    public List<String> findByFirstName(String firstName) {
        return Arrays.asList("(D) Brad Pitt", "(D) Angelina Jolie");
    }

}
