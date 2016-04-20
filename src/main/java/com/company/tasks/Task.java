package com.company.tasks;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */
public interface Task<E> {
    // Start task to execution
    void execute();

    // Return execution result
    E getResult();
}
