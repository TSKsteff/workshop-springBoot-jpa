package br.univali.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univali.coursespring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

