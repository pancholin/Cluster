package com.cluster.kubeclient.connect;

public interface RestfulClient {
	public String get(Params params); //��ȡ������Դ����
	
	public String list(Params params); //��ȡ��Դ�����б�
	
	public String create(Params params);//������Դ����
	
	public String delete(Params patams);//ɾ��ĳ����Դ����
	
	public String update(Params params);//���ָ���ĳ����Դ����
	
	public String updateWithMediaType(Params params,String mediaType);
	//ͨ��mediaTypeʵ��merge
	public String replace(Params params);  //�滻ĳ����Դ����
	
	public String options(Params params);
	
	public String head(Params params);
	
	public void close();
	
	
	
	

}
