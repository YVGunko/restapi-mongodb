package com.stpls.prj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stpls.prj.model.Chat;

public interface ChatRepository extends MongoRepository<Chat, String> {
}
