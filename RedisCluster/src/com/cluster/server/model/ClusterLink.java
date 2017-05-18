package com.cluster.server.model;

public class ClusterLink {
	int clusterId;  //集群ID
	String link;    //集群中redis数据库连接，以逗号分割
	int number;     //集群中数据库数量
	
	public int getClusterId() {
		return clusterId;
	}
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	

}
