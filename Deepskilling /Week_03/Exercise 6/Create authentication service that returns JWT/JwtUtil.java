@Component
public class JwtUtil {

    private final String SECRET_KEY = "secret";

    public String generateToken(String username) {

        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(System.currentTimeMillis() + 1200000))

                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)

                .compact();
    }
}