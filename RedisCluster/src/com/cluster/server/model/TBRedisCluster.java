package com.cluster.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RedisCluster") 
public class TBRedisCluster {
	int id;   //集群ID
	String created_time; //创建时间
	String allocated_memory;  //总内存
    String used_memory;  //已用内存
	String name;   //集群名称
	int state; //集群状态
	String userName;  //集群所属用户名
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
