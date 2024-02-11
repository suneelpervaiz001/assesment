package com.tech.assesment.repository;


import com.tech.assesment.entity.RetailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RetailUser, Long> {
}
