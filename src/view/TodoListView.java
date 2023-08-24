package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            System.out.println("ToDo List");
            todoListService.showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("3. Exit");

            var input = InputUtil.input("Option");
            if(input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                deleteTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Option not available!");
            }
        }
    }

    public void addTodoList(){
        System.out.println("Add New Todo List");

        var todo = InputUtil.input("Todo (input x to cancel)");
        if (todo.equals("x")) {
            showTodoList();
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void deleteTodoList(){
        System.out.println("Delete Todo List");

        var number = InputUtil.input("Number to delete (input x to cancel)");
        if (number.equals("x")) {
            showTodoList();
        } else {
            todoListService.deleteTodoList(Integer.valueOf(number));
        }
    }
}
