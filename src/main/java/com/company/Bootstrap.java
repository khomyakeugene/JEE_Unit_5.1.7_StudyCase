package com.company;

import com.company.tasks.Executor;
import com.company.tasks.ExecutorFactory;
import com.company.tasks.TaskProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    private TaskProvider<Number> taskProvider;
    private ExecutorFactory executorFactory;

    public static void main(String[] args) throws Exception  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        bootstrap.execute();
        bootstrap.execute();
    }

    private void execute() throws Exception {
        Executor<Number> executor = executorFactory.getNumberExecutor();
        taskProvider.getAllTasks().forEach(executor::addTask);

        executor.execute();

        System.out.println("Valid results:");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        executor.getInvalidResults().forEach(System.out::println);
    }

    public void setTaskProvider(TaskProvider<Number> taskProvider) {
        this.taskProvider = taskProvider;
    }

    public void setExecutorFactory(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }
}
