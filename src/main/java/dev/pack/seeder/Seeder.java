package dev.pack.seeder;

import dev.pack.modules.user.User;
import dev.pack.modules.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static dev.pack.modules.authorization.Role.USER;

@Configuration
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(Seeder.class);

    @Override
    public void run(String... args) throws Exception {
        try{
            log.info("Seeding data . . . ");

            /**
             * Put your seed function here
             */
            seedUserData();

            log.info("Seed data success!");
        } catch (Exception ex){
            log.error("Seed data failed, due to error : {}", ex.getMessage());
        }
    }

    @Transactional(
            rollbackOn = {
                    Exception.class,
                    DataIntegrityViolationException.class,
                    DuplicateKeyException.class
            }
    )
    public void seedUserData(){
        log.info("Seed data :: USER");

        User user1 = User.builder()
                .username("USER PPDB")
                .email("UserPPDB@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .role(USER)
                .build();

        userRepository.save(user1);
    }
}
