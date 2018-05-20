package com.eshare.cache.module.redis;


import com.alipay.jarslink.api.Action;
import com.eshare.cache.module.api.model.ActionRequest;
import com.eshare.cache.module.api.service.DefaultCacheImpl;

public class RedisAction extends DefaultCacheImpl implements Action<ActionRequest, String> {

	private static final long serialVersionUID = 9219245460794102632L;

	public String execute(ActionRequest actionRequest) {
		return "redis:"+super.execute(actionRequest);
	}


	public String getActionName() {
		return "cache";
	}

}
