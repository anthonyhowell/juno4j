package juno4j;

import juno4j.delegation.DelegateList;
import juno4j.people.DefaultPeopleDelegate;
import juno4j.people.PeopleDelegate;

public class Juno4J {

    private static final Juno4J INSTANCE = new Juno4J();

    private DelegateList delegates = new DelegateList();

    public Juno4J() {}

    public DelegateList getDelegates() {
        return delegates;
    }



    public PeopleDelegate people() {
        return (PeopleDelegate) delegates.delegateForLastResponder(new DefaultPeopleDelegate(999));
    }


    public static final Juno4J getInstance() {
        return INSTANCE;
    }

}
