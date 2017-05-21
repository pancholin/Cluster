package com.cluster.server.port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cluster.server.model.ResUserName;
import com.cluster.server.model.Response;
import com.cluster.server.model.TBUser;

@Path("/users")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface UserPort {
	
	
	/*
	 * ʵ���û�ע�Ṧ��
	 * @return Response
	 */
	@POST
	@Path("/register")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public ResUserName register(TBUser user);
	
	/*
	 * ʵ���û���¼����
	 * @return Response
	 */
	@POST
	@Path("/login")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public ResUserName login(TBUser user);
	
	/*
	 * ʵ��ͨ���û�����ȡ�û���Ϣ�Ĺ���
	 * @return Response
	 */
	@GET
	@Path("/getUser/{name}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBUser getUserInformation(@PathParam("name") String name);
	
	/*
	 * ʵ��ע������
	 * @return Response
	 */
	@GET
	@Path("/logout")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public TBUser logout();
	
}
