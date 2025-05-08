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
@RequestMapping("/EmailService")
public class EmailController extends BaseController {

    @RequestMapping(value = {"","/"})
    public String home() {
        return "EmailService()";
    }

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		//makeWebRequest("notify", "443", "Nofify/pgp?aaa=100", request);
		sendNotification(queryParams.get("appId"));
		return "EmailService pgp";
	}
	
	private void sendNotification(String appId) {
		System.out.println("Send notification");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ack(appId);
	}

	private String ack(String appId) {
		System.out.println("Email sent");
		return appId;
	}
	
}