@RestController
public class AuthenticationController {

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        String base64Credentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decodedBytes);

        String[] values = credentials.split(":");

        String username = values[0];
        String password = values[1];

        // validate username/password

        if (username.equals("user")
                && password.equals("pwd")) {

            String token = jwtUtil.generateToken(username);

            return new AuthenticationResponse(token);

        }

        throw new RuntimeException("Invalid Credentials");
    }
}
