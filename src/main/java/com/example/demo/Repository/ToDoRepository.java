package com.example.demo.Repository;

import com.example.demo.Model.ToDoModel; // Assuming your model is in this package
import org.springframework.data.jpa.repository.JpaRepository;

// Use ToDoModel instead of Todo
public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {
}



