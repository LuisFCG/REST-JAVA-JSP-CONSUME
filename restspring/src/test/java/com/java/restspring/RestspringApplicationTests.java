package com.java.restspring;


import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestspringApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(RestspringApplicationTests.class);

	
	@Test
	public void contextLoads() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://www.xpass.cl/site/getBeaconUsersCustom";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		try {
			JSONArray json = new JSONArray(response.getBody());
			log.info("jsonArray.length(): "+json.getJSONObject(0).getString("mensaje")+" ");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
