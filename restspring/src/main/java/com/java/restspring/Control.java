package com.java.restspring;

import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONArray;
import org.json.JSONException;

@Controller
public class Control {

		private static final Logger log = LoggerFactory.getLogger(Control.class);

		@RequestMapping("/")
		public String welcome() {
			return "index";
		}
	 
	 private String message = "";
	 private String name = "";
	 
	 @RequestMapping("/datoconsultado")
		public String welcome(@RequestParam(value="name", defaultValue="World") String nameRecibido,
				Map<String, Object> model) {
		 
		 	RestTemplate restTemplate = new RestTemplate();
			String url = "http://";
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			
			try {
				
				JSONArray json = new JSONArray(response.getBody()); //Transforma en JSON
				
				message = json.getJSONObject(0).getString("mensaje");
	
				int c=0;
				
				for(int f=0;f<=json.length();f++) {
					 
				//	 if(json.getJSONObject(f).getString("nombre").equals(nameRecibido)) { //Para nombre exacto
					 if(json.getJSONObject(f).getString("nombre").equalsIgnoreCase(nameRecibido)) {
					 log.info("json.getJSONObject(f).getString(\"nombre\"): "+json.getJSONObject(f).getString("nombre")+" ");
					 log.info("f: "+f+" ");
					 log.info("json.length(): "+json.length()+" ");
					 message = json.getJSONObject(f).getString("mensaje");
					 name = json.getJSONObject(f).getString("nombre");
					
					 	 model.put("name", this.name);
						 model.put("message", this.message);
						 return "index";
					 }else {
						 message = "No existe cedula consultada";
						 model.put("message", this.message);
						 return "index";
					 }
					
				 }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "index";
		}
		
}
