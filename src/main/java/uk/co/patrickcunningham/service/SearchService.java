
package uk.co.patrickcunningham.service;

import java.util.List;
import uk.co.patrickcunningham.form.Search;
import uk.co.patrickcunningham.model.json.SearchExtended;
import uk.co.patrickcunningham.model.json.TypeaheadSearchResult;

/**
 * Interface to be implemented by classes looking to obtain BBC Programme and Episode data
 * This could be via a number of different sources i.e. Web services, database, native api
 *
 * @author Patrick Cunningham
 */
public interface SearchService {
    
    public SearchExtended findByFormQuery(Search search);
    public abstract List<TypeaheadSearchResult> findByQueryMinimal(String query);
    public abstract SearchExtended findByBrand(String brand);
    public abstract SearchExtended findByServiceType(String serviceType);
    public abstract SearchExtended findByMasterBrand(String masterBrand);
    
    
}
