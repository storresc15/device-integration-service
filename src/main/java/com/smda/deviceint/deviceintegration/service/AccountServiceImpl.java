package com.smda.deviceint.deviceintegration.service;

import com.smda.deviceint.deviceintegration.dao.AccountRepository;
import com.smda.deviceint.deviceintegration.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
        account.setUserId(sequenceGeneratorService.generateSequence(Account.SEQUENCE_NAME));
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account account) throws ChangeSetPersister.NotFoundException {
        if (accountRepository.existsById(id)) {
            account.setUserId(id);
            return accountRepository.save(account);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public void deleteAccount(Long id) throws ChangeSetPersister.NotFoundException {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
