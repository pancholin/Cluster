package com.cluster.server.model;

public class ClusterLink {
	int clusterId;  //��ȺID
	String link;    //��Ⱥ��redis���ݿ����ӣ��Զ��ŷָ�
	int number;     //��Ⱥ�����ݿ�����
	
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
