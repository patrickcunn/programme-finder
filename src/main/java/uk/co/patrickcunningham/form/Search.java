
package uk.co.patrickcunningham.form;

import javax.validation.Valid;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple pojo to act as form backing object on search form submission
 * 
 * @author Patrick Cunningham
 */
public class Search {
    
    @NotEmpty(message = "Search term must not be blank.")
    private String searchTerm;
    private String category;
    private String comingSoonWithin;
    private String localRadio;
    private String masterBrand;
    private String maxTleos;
    private String mediaSet;
    private String page;
    private String perPage;
    private String searchAvailability;
    private String serviceType;
    private String signed;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComingSoonWithin() {
        return comingSoonWithin;
    }

    public void setComingSoonWithin(String comingSoonWithin) {
        this.comingSoonWithin = comingSoonWithin;
    }

    public String getLocalRadio() {
        return localRadio;
    }

    public void setLocalRadio(String localRadio) {
        this.localRadio = localRadio;
    }

    public String getMasterBrand() {
        return masterBrand;
    }

    public void setMasterBrand(String masterBrand) {
        this.masterBrand = masterBrand;
    }

    public String getMaxTleos() {
        return maxTleos;
    }

    public void setMaxTleos(String maxTleos) {
        this.maxTleos = maxTleos;
    }

    public String getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(String mediaSet) {
        this.mediaSet = mediaSet;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerPage() {
        return perPage;
    }
    
    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }    

    public String getSearchAvailability() {
        return searchAvailability;
    }

    public void setSearchAvailability(String searchAvailability) {
        this.searchAvailability = searchAvailability;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed;
    }   
    
}
