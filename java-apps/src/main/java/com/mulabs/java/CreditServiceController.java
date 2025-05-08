package com.mulabs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/CreditService")
public class CreditServiceController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "CreditService:home()";
    }

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		System.out.println("CreditService/pgp");
		processJob(queryParams.get("appId"));
		makeWebRequest("address-check", "8080", "AddressCheck/pgp", request);
		makeWebRequest("background-check", "8080", "BackgroundCheck/pgp"+"?appId="+queryParams.get("appId"), request);
		return "Making AddressCheck pgp call and third party";
	}

	
	@RequestMapping("/jg")
	public String jg(HttpServletRequest request) {
		//makeWebRequest("address-check", "8080", "AddressCheck/jg", request);
		System.out.println("CreditService/jg");
		return "CreditService/jg";
	}

	@RequestMapping("/ua")
	public String ua(HttpServletRequest request) {
		makeWebRequest("address-check", "8080", "AddressCheck/ua", request);
		System.out.println("CreditService/ua");
		return "Making AddressCheck ua call";
	}

	@RequestMapping("/gw")
	public String gw(HttpServletRequest request) {
		makeWebRequest("address-check", "8080", "AddressCheck/gw", request);
		System.out.println("CreditService/gw");
		return "Making AddressCheck gw call";
	}
	private void processJob(String string) {
		System.out.println("Start background process service call");
	}

}