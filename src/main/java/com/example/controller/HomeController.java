package com.example.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		String welcome="";
		
		try {
            InetAddress myHost = InetAddress.getLocalHost();
            welcome="I am on " + myHost.getHostName();
            //System.out.println(welcome);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
		
		return welcome;
	}

}
