package com.syne.bankapi.service;

import com.syne.bankapi.model.Account;
import com.syne.bankapi.model.TransferRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private final Map<Integer, Account> accounts = new HashMap<>();

    public AccountService() {
        accounts.put(1, new Account(1, "Rakesh", 5000));
        accounts.put(2, new Account(2, "Amit", 3000));
        accounts.put(3, new Account(3, "Rahul", 7000));
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }

    public String transfer(TransferRequest request) {

        Account from = accounts.get(request.getFromAccount());
        Account to = accounts.get(request.getToAccount());

        if (from == null || to == null) {
            return "Invalid account";
        }

        if (request.getAmount() <= 0) {
            return "Amount must be greater than zero";
        }

        if (from.getBalance() < request.getAmount()) {
            return "Insufficient balance";
        }

        from.setBalance(from.getBalance() - request.getAmount());
        to.setBalance(to.getBalance() + request.getAmount());

        return "Transfer successful";
    }
}
