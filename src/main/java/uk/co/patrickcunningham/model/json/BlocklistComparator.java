
package uk.co.patrickcunningham.model.json;

import java.util.Comparator;

/**
 * Comparator to sort {@link List} of {@link Blocklist} object by Brandtitle and Original Broadcast time
 * 
 * @author Patrick Cunningham
 */
public class BlocklistComparator implements Comparator<Blocklist> {

    @Override
    public int compare(Blocklist o1, Blocklist o2) {
        int compare1 = o1.getBrand_title().compareTo(o2.getBrand_title());
        if (compare1 == 0) {
            int compare2 = o1.getOriginal_broadcast_datetime().compareTo(o2.getOriginal_broadcast_datetime());
            if (compare2 != 0) {
                return compare2;
            } else {
                return compare1;
            }
        }
        return compare1;

    }
    
}
