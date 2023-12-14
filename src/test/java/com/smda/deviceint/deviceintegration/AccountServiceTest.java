package com.smda.deviceint.deviceintegration;

import com.smda.deviceint.deviceintegration.dao.AccountRepository;
import com.smda.deviceint.deviceintegration.entity.Account;
import com.smda.deviceint.deviceintegration.entity.Device;
import com.smda.deviceint.deviceintegration.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void testGetAccountById() {
        Long accountId = 1L;

        Account account = new Account(12L, "Testacc", null);
        account.setAccountId(accountId);
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

        Optional<Account> retrievedAccount = accountService.getAccountById(accountId);
        assertTrue(retrievedAccount.isPresent());
        assertEquals(account.getAccountId(), retrievedAccount.get().getAccountId());
    }

    // Add more tests as needed
}
