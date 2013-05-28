package org.springframework.springapp.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.springapp.service.ProductManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.support.RequestContextUtils;

public class InventoryController implements Controller {

	protected final Logger logger = LoggerFactory.getLogger(InventoryController.class);
    
    private ProductManager productManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	WebApplicationContext wac = RequestContextUtils.getWebApplicationContext(request);
    	ServletContext sctx = wac.getServletContext();
    	  	
    	System.out.println(sctx.getContextPath());
    	
    	String now = (new java.util.Date()).toString();
        logger.debug("returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
    }
    
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

}