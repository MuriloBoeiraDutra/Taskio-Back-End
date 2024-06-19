package br.com.project.repository;

import br.com.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

}
