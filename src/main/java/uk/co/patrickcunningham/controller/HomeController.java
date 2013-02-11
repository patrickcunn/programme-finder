package uk.co.patrickcunningham.controller;

import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.co.patrickcunningham.form.Search;
import uk.co.patrickcunningham.model.json.Blocklist;
import uk.co.patrickcunningham.model.json.BlocklistComparator;
import uk.co.patrickcunningham.model.json.SearchExtended;
import uk.co.patrickcunningham.service.SearchService;

/**
 * Main controller of the Programme Finder app.  Handles GET and POST requests to the root of the app
 * 
 * @author Patrick Cunningham
 */
@Controller
public class HomeController {
    
    @Autowired
    SearchService searchService;

    /**
     * Returns a simple index view for root of site
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
    /**
     * This uses the autowired SearchService to retrieve a set of BBC episode data in pojos with configurable options from a {@link Search} form backing object.
     * If any results are available they are returned to the results view
     * 
     * @param search
     * @param result
     * @param model
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String results(@Valid @ModelAttribute("search")Search search, BindingResult result,Model model) {
        SearchExtended searchExtended = searchService.findByFormQuery(search); 
        List<Blocklist> blocklist = searchExtended.getBlocklist();
        // Order by name and date order
        BlocklistComparator compare = new BlocklistComparator();
        Collections.sort(blocklist, compare);
        model.addAttribute("episodes", blocklist);
        if (result.hasErrors()){
            return "index";
        } else{
            return "results";
        }
    }
    
}


