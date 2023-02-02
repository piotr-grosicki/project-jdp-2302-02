package com.kodilla.ecommercee.repository;


import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {

}
