package com.midwesten.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midwesten.demo.model.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>{

}
