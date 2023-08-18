public class TodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * show all todo list
     */
    public static void showTodoList(){
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var num = i+1;

            if (todo != null) {
                System.out.println(num+". "+todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Ibadah";
        model[2] = "Makan";
        showTodoList();
    }

    /**
     * add new todo to list
     */
    public static void addTodoList(String todo){
        var isFull = true;

//      check if array index full
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null) {
//              model still have empty index
                isFull = false;
                break;
            }
        }

//      if full, resize max index array model and copy old data to new array
        if(isFull) {
            var temp = model;
            model = new String[model.length*2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

//      check which index null value in array model
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Test todo "+i);
        }

        showTodoList();
    }

    /**
     * delete todo from list
     */
    public static boolean deleteTodoList(Integer num){
        if ((num - 1) >= model.length) {
            return false;
        } else if  (model[num - 1] == null) {
            return false;
        } else {
            for (int i = (num - 1); i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodoList(){
//      add test todo and show todo
        addTodoList("First");
        addTodoList("Second");
        addTodoList("Third");
        showTodoList();

//      test remove number more than index array
        var result = deleteTodoList(100);
        System.out.println(result);
//      test remove number on null value
        result = deleteTodoList(8);
        System.out.println(result);
//      test remove todo
        result = deleteTodoList(2);
        System.out.println(result);
//      show new data todo
        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Name");
        System.out.println("Hi "+ name);

    }

    /**
     * view for show todo list
     */
    public static void viewShowTodoList(){
        while (true) {
            System.out.println("ToDo List");
            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("3. Exit");

            var input = input("Option");
            if(input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewDeleteTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Option not available!");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("First");
        addTodoList("Second");
        addTodoList("Third");
        addTodoList("Fourth");
        addTodoList("Fifth");
        viewShowTodoList();
    }

    /**
     * view for add todo list
     */
    public static void viewAddTodoList(){
        System.out.println("Add New Todo List");

        var todo = input("Todo (input x to cancel)");
        if (todo.equals("x")) {
            viewShowTodoList();
        } else {
            addTodoList(todo);
        }

    }

    public static void testViewAddTodoList(){
        addTodoList("First");
        addTodoList("Second");
        addTodoList("Third");
        addTodoList("Fourth");
        addTodoList("Fifth");
        viewAddTodoList();

        showTodoList();
    }

    /**
     * view for delete todo list
     */
    public static void viewDeleteTodoList(){
        System.out.println("Delete Todo List");

        var number = input("Number to delete (input x to cancel)");
        if (number.equals("x")) {
            viewShowTodoList();
        } else {
            boolean success = deleteTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Failed to delete todo list : "+number);
            }
        }
    }

    public static void testViewDeleteTodoList(){
        addTodoList("First");
        addTodoList("Second");
        addTodoList("Third");
        addTodoList("Fourth");
        addTodoList("Fifth");

        showTodoList();

        viewDeleteTodoList();

        showTodoList();
    }
}
