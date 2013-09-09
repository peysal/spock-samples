package name.peysal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author peysal
 */
public class StudentFinder implements Finder {

    @Override
    public List<String> findNames(int id) {
        if (id == 3) {
            return new ArrayList<String>(Arrays.asList(new String[]{"kacak", "hensem"}));
        }
        return new ArrayList<String>();
    }
}
