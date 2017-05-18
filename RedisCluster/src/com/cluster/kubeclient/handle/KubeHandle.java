package com.cluster.kubeclient.handle;

import com.cluster.kubeclient.connect.JerseyRestfulClient;
import com.cluster.kubeclient.connect.Params;
import com.cluster.kubeclient.connect.ResourceType;
import com.cluster.kubeclient.connect.RestfulClient;

public class KubeHandle {
	/*
	 * create a replicationController
	 */
	public String createRC(){
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.PELICATIONCONTROLLERS);
		KubeUtil kubeUtil=new KubeUtil();
		String hello=kubeUtil.getRCJson();	
	    params.setJson(hello);
	    System.out.println(hello);
	    params.setNamespace("default");
	    System.out.print(_restfulClient.create(params));	
	    return hello;
	}
	
	/*
	 * create a service
	 */
	public String createSVC(){
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.SERVICES);
		KubeUtil kubeUtil=new KubeUtil();
		String hello=kubeUtil.getSVCJson();	
	    params.setJson(hello);
	    System.out.println(hello);
	    params.setNamespace("default");
	    System.out.print(_restfulClient.create(params));	
	    return hello;
	}
	
	/*
	 * get a replicationController
	 */
	public String getRC(){
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.PELICATIONCONTROLLERS);
		params.setName("redis-master");
	    params.setNamespace("default");
	    System.out.print(_restfulClient.get(params));	
	    return null;
	}
	
	/*
	 * get a service
	 */
	public String getSVC(){
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.SERVICES);
		KubeUtil kubeUtil=new KubeUtil();
	    params.setNamespace("default");
	    params.setName("redis-master");
	    System.out.print(_restfulClient.get(params));	
	    return null;
	}
		
}
