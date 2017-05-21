package com.cluster.server.handle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.cluster.kubeclient.handle.KubeHandle;
import com.cluster.server.model.TBUser;
import com.cluster.server.port.TestPort;

public class TestHandle implements TestPort {

	@Context HttpServletRequest request;
    
    
	@Override
	public TBUser create() {
		//»ñµÃHTTPµÄSESSION  
	    KubeHandle kubeHandle=new KubeHandle();
	    System.out.println(kubeHandle.getNodePort());
		
		TBUser user=new TBUser();
		user.setName("hefl");
		user.setEmail("fajlfjl");
		user.setPassword("name");
		return user;
	}
	
	

}
