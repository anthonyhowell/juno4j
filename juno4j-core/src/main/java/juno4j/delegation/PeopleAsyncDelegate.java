package juno4j.delegation;

import juno4j.people.PeopleDelegate;

import java.util.List;

public class PeopleAsyncDelegate extends ChainableDelegate<PeopleDelegate> implements PeopleDelegate {

    public PeopleAsyncDelegate(Integer order) {
        super(order);
    }

    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public List<String> findByFirstName(String firstName) {
        return null;
    }
}
