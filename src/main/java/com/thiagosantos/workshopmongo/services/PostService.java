package com.thiagosantos.workshopmongo.services;

import com.thiagosantos.workshopmongo.domain.Post;
import com.thiagosantos.workshopmongo.domain.User;
import com.thiagosantos.workshopmongo.dto.UserDTO;
import com.thiagosantos.workshopmongo.repository.PostRepository;
import com.thiagosantos.workshopmongo.repository.UserRepository;
import com.thiagosantos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
