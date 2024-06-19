package br.com.project.dto;

import br.com.project.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;

    public UserDTO(UserEntity user){
        BeanUtils.copyProperties(user, this);
    }

    public UserDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
