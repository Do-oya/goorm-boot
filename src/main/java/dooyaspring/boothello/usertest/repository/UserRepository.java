package dooyaspring.boothello.usertest.repository;

import dooyaspring.boothello.usertest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
