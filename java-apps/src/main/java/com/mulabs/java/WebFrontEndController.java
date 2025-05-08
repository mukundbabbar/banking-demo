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
@RequestMapping("/WebFrontEnd")
public class WebFrontEndController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "Hello from WebFrontEnd:home()";
    }

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		makeWebRequest("auth-services", "8080", "AuthServices/login", request);
		makeWebRequest("acct-mgmt", "8080", "AcctMgmt/login", request);
		System.out.println("WebFrontEnd/login");
		return "Making AuthService login and AcctMgmt login call";
	}

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		System.out.println("WebFrontEnd/pgp");
		System.out.println(queryParams.get("appId"));
		String amountStr = queryParams.get("amount");
		if (amountStr != null) {
		    accounts(queryParams.get("appId"), amountStr);
		} else {
		    System.out.println("Missing query parameter: amount, setting default");
			accounts(queryParams.get("appId"), "10000");
		}
		makeWebRequest("acct-mgmt", "8080", "AcctMgmt/pgp"+"?appId="+queryParams.get("appId"), request);
		return "Making AcctMgmt pgp call";
	}

	private void accounts(String string, String val) {
		System.out.println("Start acct mgmt call, Value is: " + val);
	}

	@RequestMapping("/jg")
	public String jg(HttpServletRequest request) {
		makeWebRequest("acct-mgmt", "8080", "AcctMgmt/jg", request);
		System.out.println("WebFrontEnd/jg");
		return "Making AcctMgmt jg call";
	}


}