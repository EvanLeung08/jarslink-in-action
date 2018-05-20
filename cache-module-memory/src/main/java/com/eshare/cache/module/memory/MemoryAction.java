package com.eshare.cache.module.memory;


import com.alipay.jarslink.api.Action;
import com.eshare.cache.module.api.model.ActionRequest;
import com.eshare.cache.module.api.service.DefaultCacheImpl;

public class MemoryAction extends DefaultCacheImpl implements Action<ActionRequest, String> {

	private static final long serialVersionUID = -63052827434556767L;

	public String execute(ActionRequest actionRequest) {
		return "memory:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "cache";
	}

 

}
