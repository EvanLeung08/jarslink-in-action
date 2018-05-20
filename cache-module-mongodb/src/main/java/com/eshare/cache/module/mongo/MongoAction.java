package com.eshare.cache.module.mongo;


import com.alipay.jarslink.api.Action;
import com.eshare.cache.module.api.model.ActionRequest;
import com.eshare.cache.module.api.service.DefaultCacheImpl;

public class MongoAction extends DefaultCacheImpl implements Action<ActionRequest, String> {
	
	private static final long serialVersionUID = -4716239074103927075L;

	public String execute(ActionRequest actionRequest) {
		return "mongodb:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "cache";
	}

}
