package com.minayasa.cvform.repository;


import com.minayasa.cvform.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
