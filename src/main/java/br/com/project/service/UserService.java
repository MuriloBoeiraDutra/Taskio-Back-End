package br.com.project.service;

import br.com.project.dto.UserDTO;
import br.com.project.entity.UserEntity;
import br.com.project.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<UserDTO> listAll(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public void create(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    public UserDTO update(UserDTO user) {
        Optional<UserEntity> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            UserEntity userEntity = new UserEntity(user);
            return new UserDTO(userRepository.save(userEntity));
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    public void delete(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public UserDTO findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(UserDTO::new).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
