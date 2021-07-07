/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

//        @Test
//        void setName() {
//            TodoList testList = new TodoList();
//            testList.setName("hello");
//            assertEquals("hello",testList.getName());
//        }

    @Test
    void addItem() {
        TodoList testList = new TodoList();
        testList.addItem("1");
        testList.addItem("2");

        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }


        assertEquals("12",result);
    }

    @Test
    void removeItem() {
        //Create a list and set its name.
        //Add an item.
        //Remove the item.
        //compare output of listAsString to name.
    }

    @Test
    void listAsString() {
        //Create a list and set its name.
        //Add some items
        //compare output of listAsString to input and items.
    }

    @Test
    void completeItemsAsString() {
        //Create a list and set its name.
        //Make complete items.
        //Make incomplete items.
        //compare output of listAsString to complete items input.
    }
}