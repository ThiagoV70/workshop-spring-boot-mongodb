package com.thiagosantos.workshopmongo.resources;

import com.thiagosantos.workshopmongo.domain.User;
import com.thiagosantos.workshopmongo.dto.UserDTO;
import com.thiagosantos.workshopmongo.repository.UserRepository;
import com.thiagosantos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
