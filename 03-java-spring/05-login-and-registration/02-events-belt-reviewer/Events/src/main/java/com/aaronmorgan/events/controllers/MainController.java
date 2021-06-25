package com.aaronmorgan.events.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaronmorgan.events.models.Event;
import com.aaronmorgan.events.models.User;
import com.aaronmorgan.events.services.EventService;
import com.aaronmorgan.events.services.MessageService;
import com.aaronmorgan.events.services.UserService;
import com.aaronmorgan.events.validators.UserValidator;



@Controller
public class MainController {

	@Autowired
	private UserValidator validator;

	@Autowired
	private UserService uService;
	
	@Autowired
	private EventService eService;
	
	@Autowired
	private MessageService mService;
	
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        validator.validate(user, result);
    	if(result.hasErrors()) {
        	return "registrationPage.jsp";
        }
        User u = uService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/events";
    }
    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
       boolean isAuthenticated = uService.authenticateUser(email, password);
       if(isAuthenticated) {
    	   User u = uService.findByEmail(email);
    	   session.setAttribute("userId", u.getId());
    	   return "redirect:/events";
       } else {
    	   model.addAttribute("error", "Email or Password incorrect.");
    	   return "redirect:/";
       }
    }
    
    @RequestMapping("/events")
    public String home(HttpSession session, User user, Model model, @ModelAttribute("event") Event event, Model viewModel) {
    	viewModel.addAttribute("allEvents", this.eService.getAllEvents());	
        Long userId = (Long) session.getAttribute("userId");
        User u = uService.findUserById(userId);
    	model.addAttribute("user", u);
        model.addAttribute("inState",this.eService.getEventsWithState(u.getState()));
        model.addAttribute("notInState",this.eService.getEventsNotWithState(u.getState()));
        if(userId == null) {
    	   return "redirect:/";
        }
        return "homePage.jsp";
    }
    
    @PostMapping(value="/events")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId"); 
    	
    	User u = uService.findUserById(userId);
        model.addAttribute("user", u);
        model.addAttribute("inState",this.eService.getEventsWithState(u.getState()));
        model.addAttribute("notInState",this.eService.getEventsNotWithState(u.getState()));
        if(result.hasErrors()) {
        	return "redirect:/events";
        }
        eService.createEvent(event);
        return "redirect:/events";
    }
    
	@GetMapping("events/{id}")
	public String viewEvent(@ModelAttribute("event") Event event, Model model, @PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
    	User u = uService.findUserById(userId);
        model.addAttribute("user", u);
		Event oneEvent = this.eService.getSingleEvent(id);
		model.addAttribute("event", oneEvent);
		return "viewEvent.jsp";
	}
    
	@GetMapping("events/join/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event oneEvent = this.eService.getSingleEvent(id);
		User attending = this.uService.findUserById((Long) session.getAttribute("userId"));
		this.eService.joinEvent(attending, oneEvent);
		return "redirect:/events";
	}
	
	@GetMapping("events/unjoin/{id}")
	public String unjoinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event oneEvent = this.eService.getSingleEvent(id);
		User attending = this.uService.findUserById((Long) session.getAttribute("userId"));
		this.eService.unjoinEvent(attending, oneEvent);
		return "redirect:/events";
	}
	
	@GetMapping("events/unjoiner/{id}")
	public String unjoinerEvent(@PathVariable("id") Long id, HttpSession session) {
		Event oneEvent = this.eService.getSingleEvent(id);
		User attending = this.uService.findUserById((Long) session.getAttribute("userId"));
		this.eService.unjoinEvent(attending, oneEvent);
		return "redirect:/events/"+id;
	}
	@GetMapping("events/joiner/{id}")
	public String joinerEvent(@PathVariable("id") Long id, HttpSession session) {
		Event oneEvent = this.eService.getSingleEvent(id);
		User attending = this.uService.findUserById((Long) session.getAttribute("userId"));
		this.eService.joinEvent(attending, oneEvent);
		return "redirect:/events/" +id;
	}
	
	@GetMapping("events/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.eService.deleteEvent(id);
		return "redirect:/events";
	}
	@GetMapping("events/edit/{id}")
	public String editEvent(@ModelAttribute("event") Event event, Model model, @PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); 
    	User u = uService.findUserById(userId);
        model.addAttribute("user", u);
		Event oneEvent = this.eService.getSingleEvent(id);
		model.addAttribute("event", oneEvent);
		return "edit.jsp";
	}
	
	
	//Messages
	@PostMapping(value="/events/message/{id}")
    public String createMessage(@PathVariable("id") Long id, HttpSession session, @RequestParam("content")String content, RedirectAttributes redirs) {
    	Long userId = (Long) session.getAttribute("userId");     	
    	User author = uService.findUserById(userId);
    	Event topic = this.eService.getSingleEvent(id);
    	if(userId == null) {
     	   return "redirect:/";
         }
    	if(content.equals("")) {
			redirs.addFlashAttribute("error", "There has to be content");
			return "redirect:/events/" + id ;
		}
        mService.comment(author, topic, content);
        return "redirect:/events/" + id;
    }
	
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/";
    }
    
}

