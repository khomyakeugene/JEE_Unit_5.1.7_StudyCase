package com.company.tasks;

import java.util.List;

/**
 * Created by Yevhen on 19.04.2016.
 */
public interface TaskProvider<E> {

    List<Task<? extends E>> getAllTasks();
}
