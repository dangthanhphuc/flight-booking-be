package com.example.flight_booking_be.configurations;

import com.example.flight_booking_be.responses.UserDetail;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearner ")) {
            token = token.substring(7);
            try {
                JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
                SignedJWT signedJWT = SignedJWT.parse(token);

                if (signedJWT.verify(verifier) && signedJWT.getJWTClaimsSet().getExpirationTime().after(new Date())){
                    String userName = signedJWT.getJWTClaimsSet().getSubject();
//                    UserDetail userDetail = new UserDetail(userName, "", Collections.emptyList());
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, Collections.emptyList());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) authentication));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    request.setAttribute("userId", userId);
                }
            } catch (ParseException | JOSEException exception){
                throw new RuntimeException(exception);
            }
        }

        filterChain.doFilter(request, response);
    }
}
