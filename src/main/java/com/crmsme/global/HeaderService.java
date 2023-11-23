package com.crmsme.global;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    public String getUsername(HttpServletRequest request) {
        return request.getHeader("user_name");
    }
}