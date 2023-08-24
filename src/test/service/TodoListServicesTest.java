package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServicesTest {

    public static void main(String[] args) {
        testDeleteTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar Java Dasar");
        todoListRepository.data[1] = new TodoList("Belajar Java OOP");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java dasar");
        todoListService.addTodoList("Belajar Java oop");

        todoListService.showTodoList();
    }

    public static void testDeleteTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java dasar");
        todoListService.addTodoList("Belajar Java oop");
        todoListService.addTodoList("Belajar Java jago");

        todoListService.deleteTodoList(4);
        todoListService.deleteTodoList(1);
        todoListService.showTodoList();
        todoListService.deleteTodoList(2);
        todoListService.showTodoList();
    }
}
