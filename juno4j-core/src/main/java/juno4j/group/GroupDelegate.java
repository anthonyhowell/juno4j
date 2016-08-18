package juno4j.group;

import java.util.List;

/**
 * Created by anthony on 8/17/16.
 */
public interface GroupDelegate {

    public List<String> findAll();

    public String findOneById(Long id);

}
