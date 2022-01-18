package com.stpls.prj.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stpls.prj.model.Photo;
import com.stpls.prj.repository.PhotoRepository;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public String addPhoto(String title, String projectId, String encodedImage) throws IOException { 
        Photo photo = new Photo(); 
        photo.setTitle(title);
        photo.setProjectId(projectId);
        photo.setImage(new Binary(Base64.decodeBase64(encodedImage))); 
        photo = photoRepo.insert(photo); 
        return photo.getId(); 
    }
    
    public String addPhoto(String title, String projectId, MultipartFile file) throws IOException { 
        Photo photo = new Photo(); 
        photo.setTitle(title);
        photo.setProjectId(projectId);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepo.insert(photo); return photo.getId(); 
    }

    public Photo getPhoto(String id) { 
        return photoRepo.findById(id).get(); 
    }
    
    public Optional<Photo> getPhotos(String projectId) { 
        return photoRepo.findByProjectId(projectId); 
    }
    public List<Photo> getAllPhotos() { 
        return photoRepo.findAll(); 
    }
}
