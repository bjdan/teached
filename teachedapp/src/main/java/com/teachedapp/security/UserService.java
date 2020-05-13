package com.teachedapp.security;

import com.teachedapp.dao.Account;
import com.teachedapp.respository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("Login: " + login + " not found");
        }
        return new User(login, "{noop}" + account.getPassword(), getGrantedAuthorities(account));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(Account account) {
        return Collections.singletonList(() -> accountRepository.findRoleByAccountId(account.getId()));
    }
}
