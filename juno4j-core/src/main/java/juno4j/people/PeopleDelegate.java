package juno4j.people;

import java.util.List;

public interface PeopleDelegate {

    List<String> findAll();

    List<String> findByFirstName(String firstName);

}
