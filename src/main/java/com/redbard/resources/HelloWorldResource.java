package com.redbard.resources;

import java.util.Optional;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/hello-world")
@Produces(MediaType.TEXT_PLAIN)
public class HelloWorldResource {
		
	// I don't like delegating defaults to the Configuration, but to follow the pattern and move on, leaving as is.
	
	private String helloWorld = ""; // I would put other null checks in normally, but for the sake of brevity.
	
	
	/**
	 * This would be another way of making sure we can build the resource without a helloWorld value.
	
	private HelloWorldResource() {
		// Let makes sure we cant initialize without a String
	}
	 */
	
	public HelloWorldResource(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	
    @GET
    @Timed
    public String helloWorld() {
        return helloWorld;
    }
    
    @GET
    @Path("/format")
    @Timed
    public String helloWorldFormat(@DefaultValue(value = "false") @QueryParam("reverse") Boolean reverse) {
    	
    	if (reverse.booleanValue()) {
    		StringBuilder sb = new StringBuilder(helloWorld);
    		return sb.reverse().toString();
    	}
    	
    	return helloWorld;
    }
}
