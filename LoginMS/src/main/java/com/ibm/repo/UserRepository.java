package com.ibm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
