package dooyaspring.boothello.service;

import dooyaspring.boothello.dto.UserDto;
import dooyaspring.boothello.entity.UserEntity;
import dooyaspring.boothello.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("John");
        userDto.setEmail("john@gmail.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        when (userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        UserEntity createdUser = userService.createUser(userDto);
        assertEquals(userDto.getName(), createdUser.getName());
        assertEquals(userDto.getEmail(), createdUser.getEmail());

        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void testCreateUserWithRollback() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("Sana");
        userDto.setEmail("error@gmail.com");

        when(userRepository.save(any(UserEntity.class))).thenAnswer(i -> i.getArguments()[0]);

        assertThrows(Exception.class, () -> userService.createWithRollback(userDto));

        verify(userRepository, times(1)).save(any(UserEntity.class));
    }
}
