package br.com.tt.utilitario.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	
	public static <T> String asString(T t) throws Exception {
		String result = null;
		
		try {
			result = new ObjectMapper().writeValueAsString(t);
		} catch (JsonProcessingException e) {
			throw e;
		}
		
		return result;
	}
}
