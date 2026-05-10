package com.syne.bankapi.controller;

import com.syne.bankapi.model.Account;
import com.syne.bankapi.model.TransferRequest;
import com.syne.bankapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String home() {
        return "Simple Bank Transfer API Running";
    }

    @GetMapping("/accounts")
    public Collection<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable int id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {
        return accountService.transfer(request);
    }
}
