package br.com.project.controller;

import br.com.project.dto.UserDTO;
import br.com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listAll(){
        return userService.listAll();
    }

    @PostMapping
    public void create(@RequestBody UserDTO user){
        userService.create(user);
    }

    @PutMapping
    public UserDTO update(UserDTO user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
