package com.expensemanager.expensemanager.security;

import com.expensemanager.expensemanager.model.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenProperties tokenProperties;

    public AuthenticationFilter(AuthenticationManager authenticationManager, TokenProperties tokenProperties) {
        objectMapper = new ObjectMapper();
        this.authenticationManager = authenticationManager;
        this.tokenProperties = tokenProperties;
        setLoginPath(tokenProperties);
    }

    private void setLoginPath(TokenProperties tokenProperties) {
        setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher(tokenProperties.getLoginPath(), "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UserCredentials credentials = getCredentials(request);
            UsernamePasswordAuthenticationToken token = createAuthenticationToken(credentials);
            return authenticationManager.authenticate(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UserCredentials getCredentials(HttpServletRequest request) throws IOException, java.io.IOException {
        return objectMapper.readValue(request.getInputStream(), UserCredentials.class);
    }

    private UsernamePasswordAuthenticationToken createAuthenticationToken(UserCredentials credentials) {
        return new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                Collections.emptyList()
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws UnsupportedEncodingException {
        response.addHeader(tokenProperties.getHeader(), tokenProperties.getPrefix() + createToken(auth));
    }
    private String createToken(Authentication auth) throws UnsupportedEncodingException {
        long now = System.currentTimeMillis();
        List<String> authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(auth.getName())
                .claim("authorities", authorities)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + tokenProperties.getExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS512, tokenProperties.getSecret().getBytes("UTF-8"))
                .compact();
    }
}
