package com.cluster.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RedisCluster") 
public class RedisCluster {
	int id;   //集群ID
	String created_time; //创建时间
	int memory_total;  //总内存
	int memory_using;  //已用内存
	String name;   //集群名称
	boolean state; //集群状态
	String username;  //集群所属用户名
	
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
	public int getMemory_total() {
		return memory_total;
	}
	public void setMemory_total(int memory_total) {
		this.memory_total = memory_total;
	}
	public int getMemory_using() {
		return memory_using;
	}
	public void setMemory_using(int memory_using) {
		this.memory_using = memory_using;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
