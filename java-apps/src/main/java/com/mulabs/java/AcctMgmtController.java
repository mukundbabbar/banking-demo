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
@RequestMapping("/AcctMgmt")
public class AcctMgmtController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "WebAPI:home()";
    }

	@RequestMapping("/login")
	public String login() {
		return "AcctMgmt login";
	}

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		processAccount(queryParams.get("appId"));
		makeWebRequest("billing-services", "8080", "BillingServices/pgp", request);
		makeWebRequest("credit-service", "8080", "CreditService/pgp"+"?appId="+queryParams.get("appId"), request);
		return "Making BillingServices pgp call and CreditService pgp call";
	}

	@RequestMapping("/jg")
	public String jg(HttpServletRequest request) {
		makeWebRequest("credit-service", "8080", "CreditService/jg", request);
		return "Making CreditService jg call";
	}
	
	private void processAccount(String string) {
		System.out.println("Start credit service call");
	}


}