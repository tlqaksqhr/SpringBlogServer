package com.semtax.application.controller;


import com.semtax.application.dto.AccountDTO;
import com.semtax.application.entity.Account;
import com.semtax.application.repository.AccountRepository;
import com.semtax.application.util.Hashing;
import com.semtax.application.util.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody AccountDTO accountDTO, HttpSession session){

        String username = accountDTO.getUsername();
        String password = Hashing.hashingPassword(accountDTO.getPassword());

        Account account = accountRepository.findByUsernameAndPassword(username, password);

        if(account == null) {
            return "failed";
        }

        session.setAttribute(Sessions.SESSION_ID, username);

        return "success";
    }
}
