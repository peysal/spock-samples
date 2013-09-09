package name.peysal;

import java.util.List;

/**
 * @author peysal
 */
public interface Finder {

    /**
     * Find names based on given id.
     * @param id
     * @return names
     */
    List<String> findNames(final int id);
}
