package uk.co.patrickcunningham.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import uk.co.patrickcunningham.form.Search;

/**
 *
 * @author Patrick Cunningham
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class HomeControllerTest {

    private static final String SEARCH_TERM = "newsnight";
    private static final String SERVICE_TYPE = "tv";
    
    @Autowired
    private AnnotationMethodHandlerAdapter adapter;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    @Autowired
    private HomeController controller;
    private Search search;
    private BindingResult result;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        search = mock(Search.class);
        when(search.getSearchTerm()).thenReturn(SEARCH_TERM);
        when(search.getServiceType()).thenReturn(SERVICE_TYPE);
        result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

    }

    @Test
    public void testIndex() throws Exception {
        request.setMethod("GET");
        request.setRequestURI("/");
        Model model = new ExtendedModelMap();
        final ModelAndView mav = adapter.handle(request, response, controller);
        assertEquals("index", controller.index(model));

    }

    @Test
    public void testResults() throws Exception {
        request.setMethod("POST");
        request.setRequestURI("/");
        request.addParameter("searchTerm", SEARCH_TERM);

        ModelAndView mv = adapter.handle(request, new MockHttpServletResponse(), controller);
        assertTrue(mv.getModelMap().containsKey("episodes"));
        assertNotNull(request);

    }
}
