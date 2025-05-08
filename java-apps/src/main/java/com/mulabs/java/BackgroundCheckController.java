package com.mulabs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/BackgroundCheck")
public class BackgroundCheckController extends BaseController {

	//limited threads 200, create replica or add cpu/memory
    private final ExecutorService executor = Executors.newFixedThreadPool(200);

    private final Random random = new Random();
	
    @RequestMapping(value = {"","/"})
    public String home() {
        return "BackgroundCheck:home()";
    }

	@RequestMapping("/pgp")
	public String pgp(HttpServletRequest request, @RequestParam Map<String, String> queryParams) {
		System.out.println("Start worker thread");
        System.out.println("[Main] Received request with params: " + queryParams);
        // Start background thread
        executor.submit(() -> {
            int waitTimeSeconds = 60 + random.nextInt(121); // 60 to 180 seconds
            System.out.println("[Worker] Starting background task with params: " + queryParams);
            try {
                Thread.sleep(waitTimeSeconds * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("[Worker] Task interrupted: " + e.getMessage());
                return;
            }
            System.out.println("[Worker] Completed background task after " + waitTimeSeconds + " seconds with params: " + queryParams);
            makeWebRequest("email-service", "8080", "EmailService/pgp"+"?appId="+queryParams.get("appId"), request);
        });
		
		return "BackgroundCheck pgp";
	}

}