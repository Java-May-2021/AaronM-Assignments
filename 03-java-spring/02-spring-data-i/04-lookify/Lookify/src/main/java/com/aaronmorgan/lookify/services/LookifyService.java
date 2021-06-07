package com.aaronmorgan.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aaronmorgan.lookify.models.Song;
import com.aaronmorgan.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lRepo;
	
	public LookifyService(LookifyRepository repo) {
		this.lRepo = repo;
	}
	
	//Display All
	public List<Song> getAllSongs(){
		return this.lRepo.findAll();
	}
	
	//Display One
	public Song getSingleSong(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public Song findSong(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
//	Display Top 10
//	public List<Song> topTen(){
//		return lRepo.findTopTen();
//	}
//	
	
	//Search by Artist
	public List<Song> songsByArtist(String artist){
		return lRepo.findByArtist(artist);
	}
	
	//Create
	public Song createSong(Song song) {
		return this.lRepo.save(song);
	}
	
	//Create manually
	public Song createSongManually(String title, String artist, int rating) {
		Song newSong = new Song(title, artist, rating);
		return this.lRepo.save(newSong);
	}
	
	//Update
	public Song updateSong(Song song) {
		return this.lRepo.save(song);
	}
	
	//Delete
	public void deleteSong(Long id) {
		this.lRepo.deleteById(id);
	}
	

}
