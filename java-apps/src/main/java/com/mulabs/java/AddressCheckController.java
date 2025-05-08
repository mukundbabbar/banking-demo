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
@RequestMapping("/AddressCheck")
public class AddressCheckController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "AddressCheck:home()";
    }

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		return "AddressCheck pgp";
	}

	@RequestMapping("/jg")
	public String jg(HttpServletRequest request) {
		return "AddressCheck jg";
	}

	@RequestMapping("/ua")
	public String ua(HttpServletRequest request) {
		return "AddressCheck ua";
	}

	@RequestMapping("/gw")
	public String gw(HttpServletRequest request) {
		return "AddressCheck gw";
	}


}