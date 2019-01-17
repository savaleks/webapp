package com.savaleks.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.savaleks.website.service.CardService;

@Controller
@RequestMapping("/card")
public class CardController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping("/show")
	public ModelAndView showCard(@RequestParam(name="result", required=false) String result) {
		ModelAndView model = new ModelAndView("page");
		
		if(result != null) {
			switch(result) {
			case "updated":
				model.addObject("message", "The Card is updated");
				break;
			case "added":
				model.addObject("message", "Card added");
				break;
			case "deleted":
				model.addObject("message", "Card removed");
				break;
			case "max":
				model.addObject("message", "Card reached maximum count");
				break;
			case "unavailable":
				model.addObject("message", "Card is unavailable");
				break;
			case "error":
				model.addObject("message", "Something went wrong");
				break;
			}
		}
		model.addObject("title", "User card");
		model.addObject("userClickShowCard", true);
		model.addObject("cardLines", cardService.getCardLines());
		
		return model;
	}
	
	@RequestMapping("/{cardLineId}/update")
	public String updateCard(@PathVariable int cardLineId, @RequestParam int count) {
		String response = cardService.manageCardLine(cardLineId, count);
		
		return "redirect:/card/show?" + response;
	}
	
	@RequestMapping("/{cardLineId}/delete")
	public String removeCard(@PathVariable int cardLineId) {
		String response = cardService.deleteCardLine(cardLineId);
		
		return "redirect:/card/show?" + response;
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCard(@PathVariable int productId) {
		String response = cardService.addCardLine(productId);
		
		return "redirect:/card/show?" + response;
	}


}
