package com.example.demo.Controller;

import com.example.demo.Model.ToDoModel;
import com.example.demo.Service.ToDoDTO;
import com.example.demo.Service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")

public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

//    @GetMapping
//    public List<ToDoDTO> getAllTasks() {
//        return service.getAllTasks();
//    }

    @PostMapping
    public ResponseEntity<ToDoModel> createTask(@RequestBody ToDoModel toDoModel) {
        ToDoModel saved = service.createTask(toDoModel);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoModel> updateTask(@PathVariable Long id, @RequestBody ToDoModel toDoModel) {
        return ResponseEntity.ok(service.upTask(id, toDoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();


    }
}



























