package no.ntnu.calculator.security;

import io.jsonwebtoken.JwtException;
import no.ntnu.calculator.model.User;
import no.ntnu.calculator.service.UserService;
import no.ntnu.calculator.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JwtTokenVerifier extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenVerifier.class);

    private final JwtUtil jwtUtil;
    private final UserService userService;

    public JwtTokenVerifier(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(httpServletRequest.getServletPath().equals("/login") || httpServletRequest.getServletPath().equals("/token") || httpServletRequest.getServletPath().equals("/register")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = authorizationHeader.replace("Bearer ", "");
        try {
            // Decode token
            String subject =  jwtUtil.decode(token);

            User user = (User) userService.loadUserByUsername(subject);

            // Set authorities
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("USER"));

            // Authenticate user
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    user,
                    null, authorities
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (JwtException e) {
            logger.error("Token {} cannot be trusted", token);
        }

    }
}

