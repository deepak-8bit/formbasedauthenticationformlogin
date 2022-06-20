package com.springsecurity.basic_securityWith_inmemorydatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.basic_securityWith_inmemorydatabase.modal.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
