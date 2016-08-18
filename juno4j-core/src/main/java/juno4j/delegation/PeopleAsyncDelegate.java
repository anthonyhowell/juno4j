package juno4j.delegation;

import juno4j.people.PeopleDelegate;

import java.util.Arrays;
import java.util.List;

public class PeopleAsyncDelegate extends ChainableDelegate<PeopleDelegate> implements PeopleDelegate {

    public PeopleAsyncDelegate(Integer order) {
        super(order);
    }

    @Override
    public List<String> findAll() {
        System.out.println("Async findAll() \n\n");
        return Arrays.asList("(A) John Doe", "(A) Elvis Presley");
    }

    @Override
    public List<String> findByFirstName(String firstName) {
        System.out.println("Async findByFirstName() \n\n");
        return Arrays.asList("(A) John Doe", "(A) Elvis Presley");
    }

}
