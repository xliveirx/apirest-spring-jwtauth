package br.com.joao.booksapirest.api.domain.auth;

import br.com.joao.booksapirest.api.domain.user.User;
import br.com.joao.booksapirest.api.exceptions.ApplicationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        try{
            return JWT.create()
                    .withIssuer("joao")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirate(30))
                    .sign(algorithm);
        } catch ( JWTCreationException e) {
            throw new ApplicationException("There was an error generating the token");
        }
    }

    public String verifyToken(String token){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("joao")
                    .build();
            decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            throw new ApplicationException("There was an error verifying the token");
        }
    }

    private Instant expirate(Integer minutes){
        return LocalDateTime.now().plusMinutes(minutes).toInstant(ZoneOffset.of("-03:00"));
    }
}
