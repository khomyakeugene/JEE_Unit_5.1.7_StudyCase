package com.company;

import com.company.tasks.Executor;
import com.company.tasks.TaskProvider;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    private TaskProvider<Number> taskProvider;
    private ObjectFactory<Executor<Number>> executorFactory;

    public static void main(String[] args) throws Exception  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);

        bootstrap.execute();
        bootstrap.execute();
    }

    private void execute() throws Exception {
        Executor<Number> executor = executorFactory.getObject();
        taskProvider.getAllTasks().forEach(executor::addTask);

        executor.execute();

        System.out.println("Valid results:");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        executor.getInvalidResults().forEach(System.out::println);
    }

    @Autowired
    public void setTaskProvider(TaskProvider<Number> taskProvider) {
        this.taskProvider = taskProvider;
    }

    @Autowired
    public void setExecutorFactory(ObjectFactory<Executor<Number>> executorFactory) {
        this.executorFactory = executorFactory;
    }
}
