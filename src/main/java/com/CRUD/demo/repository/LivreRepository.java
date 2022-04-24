package com.CRUD.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.demo.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
	public List<Livre> findByOrderByTitreAsc();
}
