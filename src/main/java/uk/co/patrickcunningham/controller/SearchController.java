package uk.co.patrickcunningham.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.patrickcunningham.model.json.TypeaheadSearchResult;
import uk.co.patrickcunningham.service.JsonSearchService;
import uk.co.patrickcunningham.service.SearchService;

/**
 * Controller class to handle return minimum specific data in a number of formats
 * 
 * @author Patrick Cunningham
 */
@Controller
public class SearchController {
    
    @Autowired
    JsonSearchService searchService;
    
    /**
     * Returns JSON formatted {@link List}<{@link TypeaheadSearchResult}> to be parsed
     * 
     * @param request
     * @param model
     * @return 
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody List<TypeaheadSearchResult> searchDynamicJson(HttpServletRequest request,Model model) {
        return searchService.findByQueryMinimal(request.getParameter("query"));
    }
    
    /**
     * Possible other method for returning XML
     * 
     * @param request
     * @param model
     * @return 
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces="application/xml")
    public @ResponseBody List<TypeaheadSearchResult> searchDynamicXML(HttpServletRequest request,Model model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
