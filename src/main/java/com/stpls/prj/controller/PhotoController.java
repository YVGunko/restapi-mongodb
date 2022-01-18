package com.stpls.prj.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stpls.prj.model.Photo;
import com.stpls.prj.repository.PhotoRepository;
import com.stpls.prj.service.PhotoService;

@RestController
public class PhotoController {
	@Autowired
	PhotoRepository repository;
	@Autowired
	PhotoService photoService;

	@PostMapping("/login/photo/add")
	public String add(@RequestParam("title") String title, @RequestParam("projectId") String projectId, 
			@RequestBody String image) 
	  throws IOException {
	    String id = photoService.addPhoto(title, projectId, image);
	    return id;
	}

	@GetMapping("/login/photo/{id}")
	public Object get(@PathVariable String id) {
	    Photo photo = photoService.getPhoto(id);
	    Map<String, Object> responce = new HashMap<String, Object>();
	    responce.put("id", photo.getId());
	    responce.put("title", photo.getTitle());
	    responce.put("projectId", photo.getProjectId());
	    responce.put("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    //return Base64.getEncoder().encodeToString(photo.getImage().getData());
	    return responce;
	}
	
	@GetMapping("/login/photo")
	public List<Object> gets() {
		List<Photo> photo = photoService.getAllPhotos();
		Map<String, Object> responce = new HashMap<String, Object>();
	    //return Base64.getEncoder().encodeToString(photo.getImage().getData());
	    return (List<Object>) responce;
	}
	
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("title") String title, @RequestParam("projectId") String projectId,
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
	    String id = photoService.addPhoto(title, projectId, image);
	    return "redirect:/photos/" + id;
	}
	
	@GetMapping("/photos/{id}")
	public String getPhoto(@PathVariable String id, Model model) {
	    Photo photo = photoService.getPhoto(id);
	    model.addAttribute("title", photo.getTitle());
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    return "photos";
	}
}
