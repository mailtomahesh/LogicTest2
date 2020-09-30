package com.marlabs.logictest2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {
	@RequestMapping("/")
	@ResponseBody
	public List<Integer> getRandomNumbers(){ 
	    List<Integer> randomNumberList = new ArrayList<Integer>();
		      
	    //Generate random numbers
	    int j = 1 + (int) (Math.random() * 10);
	    //Making sure that at least 2 numbers are available for addition
	    if (j == 1)
	  	  j = 2;
	    for (int i = 1; i <= j; i++) 
	    {
	  	  int x = 1 + (int) (Math.random() * 100);
	  	  randomNumberList.add(new Integer(x));
	    }
	    
	    return randomNumberList;
	}
}
