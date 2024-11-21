package com.example.springsecurity.service;

import com.example.springsecurity.Dto.AccountLoginDto;
import com.example.springsecurity.domain.Account;
import com.example.springsecurity.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(account.getUsername())
                .password(encoder.encode(account.getPassword()))
                .roles(account.getRole())
                .build();
    }

    public Account addAccount(Account account) {
        Account findAccount = accountRepository.findByUsername(account.getUsername());
        if (findAccount == null) {
            account.changePassword(account.getPassword(), encoder);
            findAccount = accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Account already exists");
        }
        return findAccount;
    }

    // 로그인 유효성 검사
    public Boolean isValidUser(AccountLoginDto loginDto) {
        Account account = accountRepository.findByUsername(loginDto.getUsername());
        if (account != null && encoder.matches(loginDto.getPassword(), account.getPassword())) {
            return true; // 비밀번호가 일치하면 로그인 성공
        }
        return false; // 일치하지 않으면 로그인 실패
    }


//    public Boolean isValidUser(AccountLoginDto loginDto) {
//        Account account = accountRepository.findByUsername(loginDto.getUsername());
//        if (account != null && addAccount(account).checkPassword(loginDto.getPassword(), encoder)) {
//            return true;
//        }
//        return false;
//    }



}
