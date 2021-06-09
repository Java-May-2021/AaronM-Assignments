package com.aaronmorgan.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.aaronmorgan.lookify.models.Song;
import com.aaronmorgan.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	private LookifyService lService;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allSongs", this.lService.getAllSongs());
		return "dashboard.jsp";
	}

	@RequestMapping("/search")
	public String Search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	lService.songsByArtist(artist));
		model.addAttribute("artist", artist);
		return "search.jsp";
	}	
	
	@RequestMapping("/top10")
	public String TopTen(Model model) {
		model.addAttribute("songs", lService.topTen());
		return "top10.jsp";
	}
	
	
	@GetMapping("/new")
	public String add(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
//	@PostMapping("/new")
//	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
//		if(result.hasErrors()) {
//			return "new.jsp";
//		}
//		this.lService.createSong(song);
//		return "redirect:/";
//	}
	
	@PostMapping("/create")
	public String addSong(@RequestParam("title") String title, @RequestParam("artist") String artist, @RequestParam("rating") int rating, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(title.length() < 5 ) {
			errors.add("please provide a longer title");
		}
		if(artist.length() < 5 ) {
			errors.add("please provide a longer artist name");
		}

		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/new";
		
		}
		this.lService.createSongManually(title, artist, rating);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model, @ModelAttribute("song") Song song) {
		model.addAttribute("song", lService.findSong(id));
		return "edit.jsp";
	}
	@PostMapping("update/{id}")
	public String updateSong(@Valid @ModelAttribute("song") Song song, BindingResult result, @PathVariable("id") Long id, Model model) {
		Song oneSong = this.lService.findSong(id);
		model.addAttribute("song", oneSong);
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		this.lService.updateSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.lService.deleteSong(id);
		return "redirect:/dashboard";
		}
}
