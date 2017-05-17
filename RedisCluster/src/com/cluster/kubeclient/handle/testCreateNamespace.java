package com.cluster.kubeclient.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.JSONStringer;

import com.cluster.kubeclient.connect.JerseyRestfulClient;
import com.cluster.kubeclient.connect.Params;
import com.cluster.kubeclient.connect.ResourceType;
import com.cluster.kubeclient.connect.RestfulClient;
import com.sun.jersey.server.impl.cdi.Utils;



public class testCreateNamespace {
	
	public static void main(String []arg) throws JSONException{
		System.out.println("hello");
		RestfulClient _restfulClient=new JerseyRestfulClient("http://123.207.6.42:8080/api/v1");
		Params params=new Params();
		params.setResourceType(ResourceType.NAMESPACES);
		//params.setJson(Utils("namespace.json"))
		String str="{\"kind\":\"Namespace\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"linpanxue-sample\"}}";
		//String hello=ReadFile("source/frontend-controller.json");
		//System.out.println(hello);
		
	    params.setJson(str);
	   // System.out.println(hello);
	    //JSONObject json=new JSONObject(hello);
	    //params.setJson(str);
	    //System.out.println(json.get("kind"));
	    params.setNamespace("default");
	    
	    System.out.print(_restfulClient.create(params));
		//System.out.println(_restfulClient.create(params));	
		
	}

	/*
	 * 文件读取转换为字符串函数
	 */
	public static String ReadFile(String path) {  
        File file = new File(path);  
        BufferedReader reader = null;  
        String laststr = "";  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
                laststr = laststr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return laststr;  
    }  
}
