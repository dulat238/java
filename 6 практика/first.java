import java.util.*;

class Task {
    private int id; 
    private String description; 
    private String category; 
    private boolean isDone;
    private Date creationDate;

    public Task(int id, String description, String category) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.isDone = false; 
        this.creationDate = new Date();
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public boolean isDone() { return isDone; }
    public void markAsDone() { this.isDone = true; }

    @Override
    public String toString() {
        return id + ". " + description + " (Категория: " + category + ", Статус: " + (isDone ? "Выполнено" : "Не выполнено") + ")";
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTask(new Task(1, "Купить молоко", "Покупки"));
        todoList.addTask(new Task(2, "Позвонить маме", "Личное"));
        todoList.addTask(new Task(3, "Подготовить отчет", "Работа"));

        todoList.displayAllTasks();
        todoList.markTaskAsDone(1);
        todoList.searchTasks("отчет");
        todoList.displayTasksByCategory();
        todoList.displayStatistics();

        System.out.println("\n=== Добавление новой задачи ===");
        todoList.addTask(new Task(4, "Сходить в спортзал", "Здоровье"));
        todoList.displayAllTasks();

        System.out.println("\n=== Удаление задачи ===");
        todoList.deleteTask(2);
        todoList.displayAllTasks();

        System.out.println("\n=== Обновленная статистика ===");
        todoList.displayStatistics();
    }
}

class TodoList {
    private List<Task> tasks = new ArrayList<>();
    private Set<String> categories = new HashSet<>(); 
    private Map<String, List<Task>> tasksByCategory = new HashMap<>(); 

    public void addTask(Task task) {
        tasks.add(task);
        categories.add(task.getCategory());
        tasksByCategory.putIfAbsent(task.getCategory(), new ArrayList<>());
        tasksByCategory.get(task.getCategory()).add(task);
        System.out.println("Задача \"" + task.getDescription() + "\" добавлена.");
    }

    public void markTaskAsDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsDone();
                System.out.println("Задача \"" + task.getDescription() + "\" отмечена как выполненная.");
                return;
            }
        }
        System.out.println("Задача с id " + id + " не найдена.");
    }

    public void deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("Задача \"" + task.getDescription() + "\" удалена.");
                break;
            }
        }
    }

    public void displayAllTasks() {
        System.out.println("=== Вывод всех задач ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void searchTasks(String keyword) {
        System.out.println("=== Поиск задач по ключевому слову \"" + keyword + "\" ===");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Найдена задача: " + task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Задачи не найдены.");
        }
    }

    public void displayTasksByCategory() {
        System.out.println("=== Вывод задач по категориям ===");
        for (String category : categories) {
            System.out.println("Категория: " + category);
            for (Task task : tasksByCategory.get(category)) {
                System.out.println(" - " + task);
            }
        }
    }

    public void displayStatistics() {
        int completed = 0, notCompleted = 0;
        for (Task task : tasks) {
            if (task.isDone()) completed++;
            else notCompleted++;
        }
        System.out.println("=== Статистика ===");
        System.out.println("Всего задач: " + tasks.size());
        System.out.println("Выполнено: " + completed);
        System.out.println("Не выполнено: " + notCompleted);
    }
}
