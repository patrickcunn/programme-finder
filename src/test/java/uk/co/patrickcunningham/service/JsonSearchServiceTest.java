/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.patrickcunningham.service;

import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import uk.co.patrickcunningham.controller.SearchController;
import uk.co.patrickcunningham.form.Search;
import uk.co.patrickcunningham.model.json.SearchExtended;
import uk.co.patrickcunningham.model.json.TypeaheadSearchResult;

/**
 *
 * @author patrc3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class JsonSearchServiceTest {
    
    private static final String SEARCH_TERM = "newsnight";
    
    @Autowired
    private SearchService jsonSearchService;
    private Search search;

    @Before
    public void setUp() {
        search = mock(Search.class);
        when(search.getSearchTerm()).thenReturn(SEARCH_TERM);
        
    }
    
    @Test
    public void testFindByQuery() {
        SearchExtended searchExtended = new SearchExtended();
        searchExtended = jsonSearchService.findByFormQuery(search);
        assertNotNull(searchExtended);
        assertNotNull(searchExtended.getLink());
        assertNotNull(searchExtended.getCount());
        assertNotNull(searchExtended.getPagination());
        assertNotNull(searchExtended.getBlocklist());
        assertNotNull(searchExtended.getGenerator());
        assertNotNull(searchExtended.getContext());
        assertNotNull(searchExtended.getUpdated());
        assertNotNull(searchExtended.getType());
        assertNotNull(searchExtended.getId());
        assertNotNull(searchExtended.getLocale_str());

    }
    
    @Test
    public void testFindByQueryMinimal(){
        List<TypeaheadSearchResult> results = jsonSearchService.findByQueryMinimal(SEARCH_TERM);
        assertNotNull(results);
    }
    
}
