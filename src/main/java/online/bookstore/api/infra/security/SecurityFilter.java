package online.bookstore.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online.bookstore.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);
        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var user = repository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("logado");
        }

        filterChain.doFilter(request, response);

    }

        private String recuperarToken(HttpServletRequest request) {
            var authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null) {
                return authorizationHeader.replace("Bearer ", "").trim();
            }
            return null;
    }
}
