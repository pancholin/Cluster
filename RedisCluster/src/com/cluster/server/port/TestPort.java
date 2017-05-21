package com.cluster.server.port;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.cluster.server.model.TBUser;

@Path("/Test")

@Produces({"application/xml","application/json"})
public interface TestPort {
	@GET
	@Produces({"application/xml","application/json"})
	@Path("/create")
	TBUser create();
 
}
