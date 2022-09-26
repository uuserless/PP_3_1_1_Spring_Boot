package ru.uuserless.pp_3_1_1.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uuserless.pp_3_1_1.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
