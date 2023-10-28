package br.univali.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univali.coursespring.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}