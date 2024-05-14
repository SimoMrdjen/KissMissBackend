package Kiss.Miss.Backend.initialazer;

import Kiss.Miss.Backend.security.user.Role;
import Kiss.Miss.Backend.security.user.User;
import Kiss.Miss.Backend.security.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer {

    @Bean
    CommandLineRunner run(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            createUserIfNotFound(userRepository, passwordEncoder, "simo.mrdjen",
                    "dr.dirlija", Role.ADMIN);
        };
    }

    @Transactional
    private void createUserIfNotFound(UserRepository userRepository, PasswordEncoder passwordEncoder,
                                      String email, String password, Role role) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);
            userRepository.save(user);
        }
    }
}

