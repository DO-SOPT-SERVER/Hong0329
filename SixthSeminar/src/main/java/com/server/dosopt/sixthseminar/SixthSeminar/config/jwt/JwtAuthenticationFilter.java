package com.server.dosopt.sixthseminar.SixthSeminar.config.jwt;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.server.dosopt.sixthseminar.SixthSeminar.config.jwt.JwtValidationType.VALID_JWT;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            final String token = getJwtFromRequest(request);
            System.out.println("11111");
            if (jwtTokenProvider.validateToken(token) == VALID_JWT) {
                Long memberId = jwtTokenProvider.getUserFromJwt(token);
                // authentication 객체 생성 -> principal에 유저정보를 담는다.
                System.out.println("2222");
                UserAuthentication authentication = new UserAuthentication(memberId.toString(), null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("4444");
            }
        } catch (Exception exception) {
            System.out.println("3333");
            throw new RuntimeException();
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
        }
        // 다음 필터로 요청 전달
        System.out.println("55555");
        filterChain.doFilter(request, response);
        System.out.println("666666");
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
}
