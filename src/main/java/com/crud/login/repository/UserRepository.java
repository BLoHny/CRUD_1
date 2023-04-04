package com.crud.login.repository;

import com.crud.login.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllBy();

    User findByNickname(String nickname); //얘도 콘솔이랑 지켜줘야함
}
