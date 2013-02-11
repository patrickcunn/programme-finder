/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.patrickcunningham.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.naming.AuthenticationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import uk.co.patrickcunningham.form.Search;
import uk.co.patrickcunningham.model.json.Blocklist;
import uk.co.patrickcunningham.model.json.SearchExtended;
import uk.co.patrickcunningham.model.json.TypeaheadSearchResult;

/**
 *
 * @author patrc3
 */
public class JsonSearchService implements SearchService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    public String baseUrl;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }  

    @Override
    public List<TypeaheadSearchResult> findByQueryMinimal(String query) {
        SearchExtended searchExtended = restTemplate.getForObject(baseUrl+"/q/"+query, SearchExtended.class);
        List<TypeaheadSearchResult> results = new ArrayList<TypeaheadSearchResult>();
        for (Blocklist b : searchExtended.getBlocklist()){            
            TypeaheadSearchResult result = new TypeaheadSearchResult();
            result.setLink(b.getPassionsite_link());
            result.setTitle(b.getBrand_title());
            if (!results.contains(result)){
                results.add(result);
            }            
        }
        return results;
    }   

    @Override
    public SearchExtended findByFormQuery(Search search) {
        return restTemplate.getForObject(searchUrlBuilder(search), SearchExtended.class);
    }     

    @Override
    public SearchExtended findByBrand(String brand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchExtended findByServiceType(String serviceType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SearchExtended findByMasterBrand(String masterBrand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Convenience method to build url to query
     * 
     * @param search
     * @return 
     */
    public String searchUrlBuilder(Search search){
        String finalUrl = baseUrl;
        if(search.getSearchTerm() != null && !search.getSearchTerm().isEmpty()){
            finalUrl += "/q/" + search.getSearchTerm();
        }
        if(search.getCategory() != null && !search.getCategory().isEmpty()){
            finalUrl += "/category/" + search.getCategory();
        }
        if(search.getComingSoonWithin() != null && !search.getComingSoonWithin().isEmpty()){
            finalUrl += "/coming_soon_within/" + search.getComingSoonWithin();
        }
        if(search.getLocalRadio() != null && !search.getLocalRadio().isEmpty()){
            finalUrl += "/local_radio/" + search.getLocalRadio();
        }
        if(search.getMasterBrand()!=null && !search.getMasterBrand().isEmpty()){
            finalUrl += "/masterbrand/" + search.getMasterBrand();
        }
        if(search.getMaxTleos()!= null && !search.getMaxTleos().isEmpty()){
            finalUrl += "/max_tleos/" + search.getMaxTleos();
        }
        if(search.getMediaSet() != null && !search.getMediaSet().isEmpty()){
            finalUrl += "/media_set/" + search.getMediaSet();
        }
        if(search.getPage()!= null && !search.getPage().isEmpty()){
            finalUrl += "/page/" + search.getPage();
        }
        if(search.getPerPage()!= null && !search.getPerPage().isEmpty()){
            finalUrl += "/perpage/" + search.getPerPage();
        }
        if(search.getServiceType()!=null && !search.getServiceType().isEmpty()){
            finalUrl += "/service_type/" + search.getServiceType();
        }
        if(search.getSigned()!= null && !search.getSigned().isEmpty()){
            finalUrl += "/signed/" + search.getSigned();
        }
        
        return finalUrl;
        
        
    }
    
    
    
}

class BBCIonResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger log = Logger.getLogger(BBCIonResponseErrorHandler.class);

    @Override
    public void handleError(ClientHttpResponse chr) throws IOException {
        if (chr.getStatusCode() == HttpStatus.FORBIDDEN) {
            try {
                log.debug(HttpStatus.FORBIDDEN + " response. Throwing authentication exception");
                throw new AuthenticationException();
            } catch (AuthenticationException ex) {
                log.error("Authentication Failure : " + ex.getMessage());
            }
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse chr) throws IOException {
        if (chr.getStatusCode() != HttpStatus.OK) {
            // Parse different HttpStatus code for more detailed error messages
            return true;
        }
        return false;
    }
}
