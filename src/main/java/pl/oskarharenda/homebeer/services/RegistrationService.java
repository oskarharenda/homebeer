package pl.oskarharenda.homebeer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import pl.oskarharenda.homebeer.domain.model.User;
import pl.oskarharenda.homebeer.domain.repositories.UserRepository;
import pl.oskarharenda.homebeer.dtos.RegistrationDataDTO;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@Transactional @Slf4j
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

        public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder){
            this.userRepository = userRepository;
            this.passwordEncoder=passwordEncoder;
        }

        public void RegisterUser(RegistrationDataDTO data){
            log.debug("Dane do rejestracji: {}", data);
            User user = new User();
            user.setUsername(data.getUsername());
            user.setPassword(passwordEncoder.encode(data.getPassword()));
            user.setActive(true);
            user.setEmail(data.getEmail());
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
            user.setCreatedDate(date);

            userRepository.save(user);
            log.debug("zarejestrowany urzytkownik: {}", user);
    }
}
