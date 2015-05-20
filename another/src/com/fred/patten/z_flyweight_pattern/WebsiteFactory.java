package com.fred.patten.z_flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

public class WebsiteFactory {

	private Map<String,ConcreteWebsite> flyweights = new HashMap<String,ConcreteWebsite>();
	
	public WebSite getWebSiteCategory(String key){
		if(!flyweights.containsKey(key)){
			flyweights.put(key, new ConcreteWebsite(key));
		}
		return (WebSite)flyweights.get(key);
	}
	
	public int getWebSiteCount(){
		return flyweights.size();
	}
}
