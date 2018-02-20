package net.eric.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Eric Zhao
 * @date 2018/2/7
 */
public class JwtService {
    private static final String JWT_SIGN_KEY = "0123456789";
    private static final SignatureAlgorithm JWT_SIGN_ALG = SignatureAlgorithm.HS512;
    private static final String JWT_UID_KEY = "uid";

    public String genToken(int uid) {
        return Jwts.builder()
                .setSubject(JWT_UID_KEY)
                .claim(JWT_UID_KEY, uid)
                .signWith(JWT_SIGN_ALG, JWT_SIGN_KEY)
                .compact();
    }

    public int getUserIdFromToken(String token) throws Exception {
        return Jwts.parser().setSigningKey(JWT_SIGN_KEY).parseClaimsJws(token).getBody().get(JWT_UID_KEY, Integer.class);
    }
}
