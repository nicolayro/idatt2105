package no.ntnu.calculator.service;

import no.ntnu.calculator.model.LoginRequest;
import no.ntnu.calculator.model.User;
import no.ntnu.calculator.repository.UserRepository;
import no.ntnu.calculator.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCrypt;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder bCrypt, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bCrypt = bCrypt;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    /**
     * Register a user if the given username is not taken. Password is encrypted and store do the database
     * @param loginRequest user information
     * @throws AuthenticationException if the username is already taken
     */
    public void register(LoginRequest loginRequest) throws AuthenticationException {
        if(userExists(loginRequest.getUsername())) {
            throw new AuthenticationException("Username is already in use");
        }

        // Encrypt password
        String encryptedPassword = bCrypt.encode(loginRequest.getPassword());

        // Save user
        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    /**
     * Helper method for checking if a username is taken
     * @param username user to check
     * @return true if taken, false if not
     */
    private boolean userExists(String username) {
        return userRepository.existsById(username);
    }

}
