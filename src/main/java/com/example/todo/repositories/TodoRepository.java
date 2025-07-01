package com.example.todo.repositories;

import com.example.todo.entities.ToDoEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<ToDoEntity,Long> {
    Page<ToDoEntity> findAll(Pageable pageable);
}
