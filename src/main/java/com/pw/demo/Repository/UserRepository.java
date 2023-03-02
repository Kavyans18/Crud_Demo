package com.pw.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pw.demo.Dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, Integer> {

}