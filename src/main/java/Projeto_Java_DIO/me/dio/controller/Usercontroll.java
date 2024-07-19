package Projeto_Java_DIO.me.dio.controller;

import Projeto_Java_DIO.me.dio.model.User;
import Projeto_Java_DIO.me.dio.service.Userservices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class Usercontroll {

    private final Userservices userservices;


    public Usercontroll(Userservices userservices) {
        this.userservices = userservices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userservices.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User usertocreate){
        var usercreated = userservices.create(usertocreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usercreated.getId())
                .toUri();
        return ResponseEntity.ok(usertocreate);
    }

}
