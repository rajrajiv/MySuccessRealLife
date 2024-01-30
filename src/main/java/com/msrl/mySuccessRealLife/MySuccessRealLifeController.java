package com.msrl.mySuccessRealLife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.msrl.mySuccessRealLife.service.MsrlSignInService;

@RestController
public class MySuccessRealLifeController {
//	@Autowired
	MsrlSignInService msrlService = new MsrlSignInService();
	
//	String id = null;
	
	 @GetMapping("/")
	    public String home() {
	        // This method returns the name of the view (HTML page) to be rendered
	        return "index"; // Assuming there's an index.html in your static directory
	    }
	 @GetMapping("/signIn/{id}/{password}")
	 @ResponseBody
	    public String signIn(@PathVariable String id,@PathVariable String password) {
	        // This method returns the name of the view (HTML page) to be rendered
		 System.out.println("hi");
		 String msg = msrlService.validateSignIn(id,password);
		 System.out.println("msg");
	        return msg; // Assuming there's an index.html in your static directory
	    }

}
