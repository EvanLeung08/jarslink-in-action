package com.eshare.cache.module.api.service;

import com.eshare.cache.module.api.model.ActionRequest;

import java.util.HashMap;

public class DefaultCacheImpl extends HashMap<String, String>{


	protected String execute(ActionRequest actionRequest) {
		String result ;
		if (ActionRequest.OPERATION.SAVE.getIndex() == actionRequest.getOperation() ) {
			result = put(actionRequest.getKey(), actionRequest.getValue());
		}else{
			result = get(actionRequest.getKey());
		}
		return result;
	}
	
}