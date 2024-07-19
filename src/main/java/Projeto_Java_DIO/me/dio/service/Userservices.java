package Projeto_Java_DIO.me.dio.service;

import Projeto_Java_DIO.me.dio.model.User;

public interface Userservices {
    User findById(Long id);

    User create(User userToCreate);
}
