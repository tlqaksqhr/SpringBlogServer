package com.semtax.application.repository;

import com.semtax.application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

    public Account findByUsername(String username);
    public Account findByUsernameAndPassword(String username, String password);
}
