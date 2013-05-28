package org.springframework.springapp.web;

import org.springframework.springapp.web.InventoryController;
import org.springframework.web.servlet.ModelAndView;


import junit.framework.TestCase;

public class HelloControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello.jsp", modelAndView.getViewName());
    }
}