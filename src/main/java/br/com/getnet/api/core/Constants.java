package br.com.getnet.api.core;

import io.restassured.http.ContentType;

public interface Constants {
	
	String APP_BASE_URL = "https://reqres.in/api/";
	Integer APP_PORT = 80;
	
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 10000L;

}
