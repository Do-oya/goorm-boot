package dooyaspring.boothello.service;

import dooyaspring.boothello.dto.UserDto;
import dooyaspring.boothello.entity.UserEntity;
import dooyaspring.boothello.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        return userRepository.save(userEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public UserEntity createWithRollback(UserDto userDto) throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userRepository.save(userEntity);

        if (userDto.getEmail().contains("error")) {
            throw new Exception("강제 예외 발생");
        }

        return userEntity;
    }

    @Transactional(readOnly = true)
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public UserEntity updateUser(Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        return userRepository.save(userEntity);
    }
}
