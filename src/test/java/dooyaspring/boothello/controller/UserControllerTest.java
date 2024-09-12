package dooyaspring.boothello.controller;

import dooyaspring.boothello.dto.UserDto;
import dooyaspring.boothello.entity.UserEntity;
import dooyaspring.boothello.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.out.println("테스트 준비 데이터베이스의 모든 사용자 데이터 삭제");
        userRepository.deleteAll();
    }

    @Test
    void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Sana");
        userDto.setEmail("sana@gmail.com");

        HttpEntity<UserDto> request = new HttpEntity<>(userDto);

        ResponseEntity<UserEntity> response = restTemplate.exchange("/users", HttpMethod.POST, request, UserEntity.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("Sana");
        assertThat(response.getBody().getEmail()).isEqualTo("sana@gmail.com");
    }

    @Test
    void testGetUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Goorm");
        userEntity.setEmail("goorm@gmail.com");

        UserEntity savedUser = userRepository.save(userEntity);

        ResponseEntity<UserEntity> res = restTemplate.getForEntity("/users/{id}", UserEntity.class, savedUser.getId());

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(res.getBody()).isNotNull();
        assertThat(savedUser.getId()).isEqualTo(res.getBody().getId());
        assertThat(savedUser.getName()).isEqualTo(res.getBody().getName());
        assertThat(savedUser.getEmail()).isEqualTo(res.getBody().getEmail());
    }

}
