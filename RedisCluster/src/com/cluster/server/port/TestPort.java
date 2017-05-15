package com.cluster.server.port;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.cluster.server.model.User;

@Path("/Test")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface TestPort {
	@POST
	@Path("/create")
	User create(HttpServletRequest request);
 
}
