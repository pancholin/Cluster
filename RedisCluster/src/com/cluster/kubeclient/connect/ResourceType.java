package com.cluster.kubeclient.connect;

public enum ResourceType {
	NODES("nodes"),
	NAMESPACES("namespaces"),
	SERVICES("services"),
	PELICATIONCONTROLLERS("replicationcontrollers"),
	PODS("pods"),
	BINGDINGS("bindings"),
	ENDPOINTS("endpoints"),
	SERVICEACCOUNTS("serviceaccounts"),
	SECRETS("secrets"),
	EVENTS("events"),
	COMPOMNENTSSTATUSES("componentstatus"),
	LIMITRANGES("limitranges"),
	RESOURCEQUOTES("resourcequotas"),
	PODTEMPLATES("podtemplates"),
	PERSISTENTVOLUMECLAIMS("persistenvolumeclaims"),
	PERSISTENTVOLUMES("persistenvolumes");
	
	private String type;
	
	private ResourceType(String type){
		this.type=type;
	}
	
	public String getType(){
		return type;
	}
	

}
