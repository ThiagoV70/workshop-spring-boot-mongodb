package com.thiagosantos.workshopmongo.repository;

import com.thiagosantos.workshopmongo.domain.Post;
import com.thiagosantos.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
