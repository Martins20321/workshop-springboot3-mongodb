package com.estudosmartins.workshopmongo.services;

import com.estudosmartins.workshopmongo.domain.User;
import com.estudosmartins.workshopmongo.dto.UserDTO;
import com.estudosmartins.workshopmongo.repository.UserRepository;
import com.estudosmartins.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj =  repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public User update(User obj){
        User entity = findById(obj.getId());
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public List<User> findByName(String text){
        return repository.findByNameContainingIgnoreCase(text);
    }

}
