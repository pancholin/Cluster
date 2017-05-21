package com.cluster.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RedisCluster") 
public class TBRedisCluster {
	int id;   //��ȺID
	String created_time; //����ʱ��
	String allocated_memory;  //���ڴ�
    String used_memory;  //�����ڴ�
	String name;   //��Ⱥ����
	int state; //��Ⱥ״̬
	String userName;  //��Ⱥ�����û���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getAllocated_memory() {
		return allocated_memory;
	}
	public void setAllocated_memory(String allocated_memory) {
		this.allocated_memory = allocated_memory;
	}
	public String getUsed_memory() {
		return used_memory;
	}
	public void setUsed_memory(String used_memory) {
		this.used_memory = used_memory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
}
