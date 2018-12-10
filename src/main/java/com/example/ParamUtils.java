package com.example;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

public class ParamUtils {
	/**
	 * 根据传入参数的key获取value
	 * 
	 * @param name
	 * @param decoderQuery
	 * @return
	 */
	public static String getParameterByName(String name, QueryStringDecoder decoderQuery) {
		Map<String, List<String>> uriAttributes = decoderQuery.parameters();
		for (Entry<String, List<String>> attr : uriAttributes.entrySet()) {
			String key = attr.getKey();
			for (String attrVal : attr.getValue()) {
				if (key.equals(name)) {
					return attrVal;
				}
			}
		}
		return null;
	}

	public static String getParamerByNameFromGET(String name, String uri) {
		QueryStringDecoder decoderQuery = new QueryStringDecoder(uri);
		return getParameterByName(name, decoderQuery);
	}
}
