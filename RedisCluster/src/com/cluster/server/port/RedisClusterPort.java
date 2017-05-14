package com.cluster.server.port;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/instances")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface RedisClusterPort {
	
	
	

}
