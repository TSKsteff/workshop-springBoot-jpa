package br.univali.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univali.coursespring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
