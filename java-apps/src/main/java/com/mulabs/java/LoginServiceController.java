package com.mulabs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/LoginService")
public class LoginServiceController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "LoginService:home()";
    }

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request) {
		return "LoginService pgp";
	}

	@RequestMapping("/jg")
	public String jg(HttpServletRequest request) {
		return "LoginService jg";
	}

	@RequestMapping("/ua")
	public String ua(HttpServletRequest request) {
		makeWebRequest("credit-service", "8080", "CreditService/ua", request);
		System.out.println("LoginService/ua");
		return "Making CreditService ua call";
	}

	@RequestMapping("/gw")
	public String gw(HttpServletRequest request) {
		makeWebRequest("credit-service", "8080", "CreditService/gw", request);
		System.out.println("LoginService/gw");
		return "Making CreditService gw call";
	}

}