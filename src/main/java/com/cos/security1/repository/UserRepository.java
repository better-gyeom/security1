package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA가 기본적인 CRUD 함수 제공
//@Repository 어노테이션 없어도 IoC 됨 (JpaRepository를 상속했기 때문에)
public interface UserRepository extends JpaRepository<User, Integer> {
}
