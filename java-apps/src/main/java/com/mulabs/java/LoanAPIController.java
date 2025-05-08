package com.mulabs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/LoanAPI")
public class LoanAPIController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "LocanAPI:home()";
    }

	@RequestMapping("/ua")
	public String ua(HttpServletRequest request) {
		makeWebRequest("create-account", "8001", "CreateAccount/ua", request);
		makeWebRequest("login", "8080", "LoginService/ua", request);
		return "Making CreateAccount ua and LoginService ua call";
	}

	@RequestMapping("/c")
	public String c(HttpServletRequest request) {
		makeWebRequest("create-account", "8001", "CreateAccount/c", request);
		return "Making CreateAccount c call";
	}

	@RequestMapping("/gw")
	public String gw(HttpServletRequest request) {
		makeWebRequest("login", "8080", "LoginService/gw", request);
		return "Making LoginService gw call";
	}


}