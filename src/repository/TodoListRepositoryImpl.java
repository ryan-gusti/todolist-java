package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    public TodoList[] data = new TodoList[10];
    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        var isFull = true;
        //check if array index full
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                //model still have empty index
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        if(isFull()) {
            var temp = data;
            data = new TodoList[data.length*2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        //if full, resize max index array model and copy old data to new array
        resizeIfFull();

        //check which index null value in array model
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if  (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == data.length - 1) {
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
            return true;
        }
    }
}
