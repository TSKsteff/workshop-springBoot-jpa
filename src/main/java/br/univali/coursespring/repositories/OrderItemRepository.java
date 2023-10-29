package br.univali.coursespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univali.coursespring.entities.OrderItem;
import br.univali.coursespring.entities.User;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}

