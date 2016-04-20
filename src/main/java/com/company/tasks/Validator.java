package com.company.tasks;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */
public interface Validator<E> {
    // Validate delivered value
    boolean isValid(E result);
}
