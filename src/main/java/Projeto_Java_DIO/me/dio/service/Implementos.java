package Projeto_Java_DIO.me.dio.service;

import Projeto_Java_DIO.me.dio.depository.UserRepository;
import Projeto_Java_DIO.me.dio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class Implementos implements Userservices{

    private final UserRepository userRepository;

    @Autowired
    public Implementos(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Esse numero de conta já existe.");
        }
        return userRepository.save(userToCreate);
    }
}
