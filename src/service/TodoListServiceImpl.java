package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();


        for (int i = 0; i < model.length; i++) {
            var todolist = model[i];
            var num = i+1;

            if (todolist != null) {
                System.out.println(num+". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Success add todo : "+todo);
    }

    @Override
    public void deleteTodoList(Integer number) {
        boolean success = todoListRepository.delete(number);
        if (success) {
            System.out.println("Success delete todo : "+ number);
        } else {
            System.out.println("Failed delete todo : "+ number);
        }
    }
}
