package com.estudosmartins.workshopmongo.services;

import com.estudosmartins.workshopmongo.domain.Post;
import com.estudosmartins.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.get();
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContaining(text);
    }
}
