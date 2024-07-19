package Projeto_Java_DIO.me.dio.depository;

import Projeto_Java_DIO.me.dio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsMyAccount(String accountNumber);
}
