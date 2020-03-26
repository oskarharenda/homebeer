package pl.oskarharenda.homebeer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.oskarharenda.homebeer.domain.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
