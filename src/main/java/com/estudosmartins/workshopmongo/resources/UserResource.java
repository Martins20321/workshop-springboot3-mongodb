package com.estudosmartins.workshopmongo.resources;

import com.estudosmartins.workshopmongo.domain.Post;
import com.estudosmartins.workshopmongo.domain.User;
import com.estudosmartins.workshopmongo.dto.UserDTO;
import com.estudosmartins.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //Criando a URL com parâmtro Id
        return ResponseEntity.created(uri).build(); //Contendo a localização do novo recurso criado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO objDTO, @PathVariable String id){
       User obj = service.fromDTO(objDTO);
       obj.setId(id); //Garantir que o obj vai ter o mesmo id do parâmetro
       obj = service.update(obj);
       return ResponseEntity.noContent().build();
    }

    //Retornando os posts do usuário
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj =  service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}
