package net.eric.aspect;

import net.eric.exception.AuthException;
import net.eric.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eric Zhao
 * @date 2018/2/8
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final String AUTHENTICATION = "Authentication";
    public static final String AUTH_USER_ID = "Auth-User-Id";
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    private JwtService jwtService;

    public AuthInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public AuthInterceptor() {
    }

    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AUTHENTICATION);
        try {
            logger.info("received request {}", request);
            int userId = jwtService.getUserIdFromToken(token);
            request.setAttribute(AUTH_USER_ID, userId);
            return true;
        } catch (Throwable th) {
            logger.warn("received invalid request {}, ex {}", request.getRequestURI(), th);
            throw new AuthException();
        }
    }
}
