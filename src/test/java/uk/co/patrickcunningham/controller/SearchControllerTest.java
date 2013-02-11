/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.patrickcunningham.controller;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import uk.co.patrickcunningham.form.Search;
import uk.co.patrickcunningham.model.json.TypeaheadSearchResult;

/**
 *
 * @author patrc3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class SearchControllerTest {
    
    private static final String SEARCH_TERM = "newsnight";
    
    @Autowired
    private AnnotationMethodHandlerAdapter adapter;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    @Autowired
    private SearchController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();    
        
    }
    
    @Test
    public void testSearchDynamic() throws Exception {
        request.setMethod("GET");
        request.setRequestURI("/search");
        request.setParameter("query", SEARCH_TERM);
        Model model = new ExtendedModelMap();
        //final ModelAndView mav = adapter.handle(request, response, controller);
        List<TypeaheadSearchResult> results = controller.searchDynamicJson(request, model);
        assertNotNull(results);
        assertTrue(!results.isEmpty());
    }

    
    
}
