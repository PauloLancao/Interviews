package com.assesment.matillion.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

	public static <T> String convertToJson(List<T> content) {
		ObjectMapper mapper = new ObjectMapper();
		String json = StringUtils.EMPTY;
	    try {
	        json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(content);
	    } catch (JsonProcessingException e) {
	        json = e.getMessage();
	    }
	    return json;
	}
}
