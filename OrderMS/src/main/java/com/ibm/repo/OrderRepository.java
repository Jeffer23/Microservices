package com.ibm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
