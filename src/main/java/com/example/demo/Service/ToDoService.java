package com.example.demo.Service;

import com.example.demo.Model.ToDoModel;
import com.example.demo.Repository.ToDoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }


//    public List<ToDoDTO> getAllTasks() {
//        List<ToDoModel>  toDoModels= repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
//
//        return mapTODTP(toDoModels, new ToDoDTO());
//    }


    public ToDoModel createTask(ToDoModel toDoModel) {
        return repository.save(toDoModel);
    }

    public ToDoDTO getTask(Long id) {
        ToDoModel t =  repository.findById(id).orElse(null);
        return mapTODTToAdmin(t,new ToDoDTO());
    }

    public ToDoModel upTask(Long id, ToDoModel newData) {
        return repository.findById(id)
                .map(task -> {
                    task.setTitle(newData.getTitle());
                    task.setDone(newData.isDone());
                    return repository.save(task);
                })
                .orElse(null);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
    public ToDoDTO mapTODTToAdmin(ToDoModel toDo, ToDoDTO toDoDTO ){
         toDoDTO.setTitle(toDo.getTitle());
        return  toDoDTO;
    }
}
