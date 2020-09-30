package com.marlabs.logictest2.controller;

import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AdditionResult")
public class AdditionResultController {
	@RequestMapping("/{relevantNumbers}/{total}")
	@ResponseBody
	public String getAdditionResult(@PathVariable("relevantNumbers") String relevantNumbersString, 
	  @PathVariable("total") int iUserSentTotal)
	{
	    String additionResultMessage = new String();
	    int iTotal = 0;
	    String nextTkn = new String();
		   
	    StringTokenizer tokenizer = new StringTokenizer(relevantNumbersString,",");
	    while(tokenizer.hasMoreTokens()){
	 	   nextTkn = tokenizer.nextToken();
		   iTotal += Integer.parseInt(nextTkn);
	    }
	    System.out.println("iTotal="+iTotal);
	    System.out.println("iUserSentTotal="+iUserSentTotal);
		   
	    if(iTotal ==  iUserSentTotal)
	 	   additionResultMessage = "Addition is correct.";
	    else
		   additionResultMessage = "Addition is incorrect. Please try again!";
		   
	    return additionResultMessage;
	}
}
