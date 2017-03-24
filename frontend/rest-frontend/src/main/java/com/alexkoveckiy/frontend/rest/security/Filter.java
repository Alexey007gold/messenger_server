package com.alexkoveckiy.frontend.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

//import com.alexkoveckiy.common.token.api.TokenHandler;
//import com.alexkoveckiy.common.exceptions.InvalidTokenException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 17.03.17.
 */
@Component
public class Filter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private TokenHandler tokenHandler;

    private Authentication authentication;

    public Filter() {
        this.authentication = new UsernamePasswordAuthenticationToken(null, null);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = ((HttpServletRequest)req);
            request.getSession()
                    .setAttribute("routing_data", tokenHandler.getRoutingDataFromTemporaryToken(request.getHeader("x-token")));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(req, res);
        } catch (InvalidTokenException ignored) {
            ((HttpServletResponse) res).sendError(403);
        }
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
