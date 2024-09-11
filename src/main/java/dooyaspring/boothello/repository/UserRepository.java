package dooyaspring.boothello.repository;

import dooyaspring.boothello.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
