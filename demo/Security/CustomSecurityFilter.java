package com.example.demo.Security;

import com.example.demo.Utils.JwtUtilsHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class CustomSecurityFilter extends OncePerRequestFilter { ;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromReader(request);
        System.out.println("Kiem Tra : "+token);

        if (token != null) {
            //Kiểm tra xem token có phải token mình create không?
            if (jwtUtilsHelper.verifyToken(token)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("", "", new ArrayList<>());
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        //chấp nhận cho phép đi vào các link api
        filterChain.doFilter(request, response);

    }
    private String getTokenFromReader(HttpServletRequest request) {
        String BearerToken = request.getHeader("Authorization");
        String token = null;
        if (StringUtils.hasText(BearerToken) && BearerToken.startsWith("Bearer ")) {
            token= BearerToken.substring(7);//lấy dữ liệu sau 7 kí tự

        }
        return token;

    }

}

