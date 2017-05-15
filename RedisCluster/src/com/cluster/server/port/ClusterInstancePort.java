package com.cluster.server.port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cluster.server.model.Redis;




@Path("/instances")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface ClusterInstancePort {
	@GET
	@Path("/getInstance")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({"application/xml","application/json"})
	public Redis getInstance() ;
	
	
	@GET
	@Path("/get")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Redis get();
	
}
