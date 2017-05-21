package com.cluster.kubeclient.handle;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		String hello=kubeUtil.getRCJson("redis");	
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
		String hello=kubeUtil.getSVCJson("redis");	
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
	public String getSVC() {
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.SERVICES);
		KubeUtil kubeUtil=new KubeUtil();
	    params.setNamespace("default");
	    params.setName("redis-master");
	   // String str=_restfulClient.get(params);
	    String str="{\"kind\":\"Service\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"redis-master\",\"namespace\":\"default\",\"selfLink\":\"/api/v1/namespaces/default/services/redis-master\",\"uid\":\"5a38dd9d-3abc-11e7-a015-00163e0431c6\",\"resourceVersion\":\"944697\",\"creationTimestamp\":\"2017-05-17T04:50:30Z\",\"labels\":{\"name\":\"redis-master\"}},\"spec\":{\"ports\":[{\"protocol\":\"TCP\",\"port\":6379,\"targetPort\":6379,\"nodePort\":8889}],\"selector\":{\"name\":\"redis-master\"},\"clusterIP\":\"10.254.94.69\",\"type\":\"NodePort\",\"sessionAffinity\":\"None\"},\"status\":{\"loadBalancer\":{}}}";
	    
	    System.out.println(str);
	    JSONObject json = null;
	    JSONArray array;
	    
		try {
			json = new JSONObject(str);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			array=new JSONArray(new JSONObject(json.get("spec").toString()).get("ports").toString());
			System.out.println(array.toString());
			System.out.println(new JSONObject(array.get(0).toString()).get("nodePort"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	    return null;
	}
		
	
	public String getNodePort(){
		String nodePort = null;
		RestfulClient _restfulClient=new JerseyRestfulClient(KubeUtil.Url);
		Params params=new Params();
		params.setResourceType(ResourceType.SERVICES);
		KubeUtil kubeUtil=new KubeUtil();
	    params.setNamespace("default");
	    params.setName("redis-master");
	    String str=_restfulClient.get(params);
	     
	    System.out.println(str);
	    JSONObject json = null;
	    JSONArray array;
	    
	    try {
	    	json = new JSONObject(str);
			array=new JSONArray(new JSONObject(json.get("spec").toString()).get("ports").toString());
			
			nodePort=new JSONObject(array.get(0).toString()).get("nodePort").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return nodePort;		
	}
}
