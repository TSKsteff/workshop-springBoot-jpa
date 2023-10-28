package br.univali.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univali.coursespring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}