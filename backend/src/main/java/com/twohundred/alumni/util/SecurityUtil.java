package com.twohundred.alumni.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.exception.Exceptions;
import com.twohundred.alumni.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    private final UserRepo repository;

    public Long getCurrentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getId();
    }

    public User getCurrentUser() {
        return repository.findById(getCurrentUserId())
                .orElseThrow(() -> Exceptions.USER_NOT_FOUND);
    }
}
