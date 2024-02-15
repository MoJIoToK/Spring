package com.example.payment.service;

import com.example.payment.domain.Account;
import com.example.payment.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс AccountService. Сервис для работы с учетными записями счетов.
 *
 * @author Nick
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    /**
     * Метод позволяет получить учетную запись по идентификатору.
     *
     * @param id идентификатор учетной записи
     * @return Account найденная учетная запись
     */
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    /**
     * Метод позволяет получить список всех учетных записей.
     *
     * @return List список всех учетных записей
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Метод позволяет сохранить список учетных записей.
     *
     * @param list список учетных записей для сохранения
     */
    public void saveAllAccounts(List<Account> list) {
        accountRepository.saveAll(list);
    }

    /**
     * Метод позволяет сохранять учетную запись.
     *
     * @param account учетная запись для сохранения
     */
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


}
