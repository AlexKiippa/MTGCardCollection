package fi.haagahelia.mtgcollection.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import fi.haagahelia.mtgcollection.domain.Card;
import fi.haagahelia.mtgcollection.domain.CardColorRepository;
import fi.haagahelia.mtgcollection.domain.CardRepository;
import fi.haagahelia.mtgcollection.domain.CardTypeRepository;

@Controller
public class MtgcollectionController {
	
	
	@Autowired
	private CardRepository repository;
	
	@Autowired
	private CardColorRepository crepository;
	
	@Autowired
	private CardTypeRepository ctrepository;
			
	
			
			//Login
		@RequestMapping(value="/login")
			public String login() {
				return "login";
		}
		
		
		// Show all cards in the collection
		@RequestMapping(value= {"/collection"})
		public String collection(Model model) {
			model.addAttribute("cards", repository.findAll());
			return "collection";
		}
		
		
		// RESTful service to get all cards
	       @RequestMapping(value="/cards", method = RequestMethod.GET)
	        public @ResponseBody List<Card> cardListRest() {	
	            return (List<Card>) repository.findAll();
	        }  
	       
	       
	       
	       		// REST service to get card by id
	       @RequestMapping(value="/card/{id}", method= RequestMethod.GET)
	       public @ResponseBody Optional<Card> findCardRest(@PathVariable("id") Long cardid){
	    	   return repository.findById(cardid);
	       }
	       
	       
	       // Add new card to the list
	       @RequestMapping(value = "/addcard")
	       public String addCard(Model model) {
	    	   model.addAttribute("card", new Card());
	    	   model.addAttribute("cardcolors", crepository.findAll());
	    	   model.addAttribute("cardtypes",ctrepository.findAll());
	    	   return "addcard";
	    	   
	       }
	       
	       //Save new card to the list
	       @RequestMapping(value = "/save", method = RequestMethod.POST)
	       public String save(Card card) {
	    	   repository.save(card);
	    	   return "redirect:collection";
	       }
	       
	       // Delete card From the list
	       @PreAuthorize("hasAuthority('ADMIN')")
	       @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	       public String deleteCard(@PathVariable("id") Long cardid, Model model) {
	    	   repository.deleteById(cardid);
	    	   return "redirect:../collection";
	       }
	       
		

}
