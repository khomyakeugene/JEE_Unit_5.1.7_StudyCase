package com.company.tasks;

import com.company.Bootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Yevhen on 20.04.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    public Bootstrap bootstrap(ExecutorFactory executorFactory, TaskProvider<Number> numberTaskProvider) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setExecutorFactory(executorFactory);
        bootstrap.setTaskProvider(numberTaskProvider);

        return bootstrap;
    }

    @Bean
    public TaskProvider<Number> numberTaskProvider() {
        NumberTaskProvider numberTaskProvider = new NumberTaskProvider();
        numberTaskProvider.init();

        return numberTaskProvider;
    }

    @Bean
    @Scope("prototype")
    public TaskExecutor<Number> taskExecutor() {
        return new TaskExecutor<>();
    }

    @Bean
    public ExecutorFactory executorFactory() {
        return new ExecutorFactory() {
            @Override
            public Executor<Number> getNumberExecutor() {
                return taskExecutor();
            }
        };
    }
}
