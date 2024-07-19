package Projeto_Java_DIO.me.dio.service;

import Projeto_Java_DIO.me.dio.model.User;

public interface Userservices {
    User findbyid(Long id);

    User create(User userToCreate);
}
