package dooyaspring.boothello.repository;

import dooyaspring.boothello.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindById() {
        UserEntity user = new UserEntity();
        user.setName("Sana");
        user.setEmail("sana@gmail.com");

        UserEntity savedUser = userRepository.save(user);

        UserEntity foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo(savedUser.getName());
        assertThat(foundUser.getEmail()).isEqualTo(savedUser.getEmail());

    }
}
