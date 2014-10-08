package com.gcchr.system.dal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcchr.system.dal.model.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String>
{
    UserAccount findByUsername(final String username);

    List<UserAccount> findByUsernameAndPassword(final String username, final String password);
}
