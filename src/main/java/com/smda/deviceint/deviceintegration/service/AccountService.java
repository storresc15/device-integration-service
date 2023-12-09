package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.entity.Account;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long id);
    Account createAccount(Account account);
    Account updateAccount(Long id, Account account) throws ChangeSetPersister.NotFoundException;
    void deleteAccount(Long id) throws ChangeSetPersister.NotFoundException;
}
