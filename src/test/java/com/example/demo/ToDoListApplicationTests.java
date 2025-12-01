package com.example.demo;

import com.example.demo.Model.ToDoModel;
import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Service.ToDoDTO;
import com.example.demo.Service.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class ToDoListApplicationTests {
	@InjectMocks
	private ToDoService toDoService;
	@Mock
	private ToDoRepository toDoRepository;
	@Test
	void contextLoads() {
	}
    @Test
	void  testGetAllTask(){
		ToDoModel toDoModel = new ToDoModel();
		toDoModel.setTitle("project");
		toDoModel.setId(1L);
		when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDoModel));
		ToDoDTO toDoModel1 =  toDoService.getTask(1L);
		Assertions.assertEquals(toDoModel1.getTitle() , "project");
	}
	@Test
	void  testْUpdateAllTask(){
		ToDoModel toDoModel = new ToDoModel();
		toDoModel.setTitle("project");
		toDoModel.setId(1L);
		when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDoModel));

		ToDoModel newData = new ToDoModel();
		toDoModel.setTitle("coding");
		toDoModel.setId(1L);

		ToDoModel toDoModel1 =  toDoService.upTask(1L,newData);

		Assertions.assertEquals(toDoModel1.getTitle() , "coding");
	}

}
