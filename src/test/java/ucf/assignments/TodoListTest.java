/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

    @Test
    void addItem() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        //Concatenate the names.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //Test expected names.
        assertEquals("12",result);
    }

    @Test
    void addItem_bad_name() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        //This item has a blank name and should not add to list.
        testList.addItem("","", testDate);
        testList.addItem("2","", testDate);

        //Concatenate the names.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //Test expected names.
        assertEquals("2",result);
    }

    @Test
    void addItem_bad_description() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        String space257 = new String(new char[257]).replace("\0"," ");
        //This item has a description that is too long and should not add to the list.
        testList.addItem("1",space257, testDate);
        testList.addItem("2","", testDate);

        //Concatenate the names.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //Test expected names.
        assertEquals("2",result);
    }

    @Test
    void updateItem() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        //Update item name.
        testList.updateItem("1","3","",testDate);

        //Concatenate the names.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //Test expected names.
        assertEquals("32",result);
    }

    @Test
    void updateItem_check_description() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        //Update item description.
        testList.updateItem("1","1","123",testDate);

        //Concatenate the descriptions.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getDescription();
        }

        //Test expected descriptions.
        assertEquals("123",result);
    }

    @Test
    void updateItem_check_date() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);

        //Update item date.
        LocalDate newDate = LocalDate.of(2001,02,12);
        testList.updateItem("1","1","123",newDate);

        //Concatenate the dates.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getDate().toString();
        }

        //Test expected dates.
        assertEquals("2001-02-12",result);
    }

    @Test
    void updateItem_bad_name() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        //Update item name. (This is a bad name and should result in a failed update)
        testList.updateItem("1","","",testDate);

        //Concatenate the names.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //Test expected names.
        assertEquals("12",result);
    }

    @Test
    void updateItem_bad_description() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        String space257 = new String(new char[257]).replace("\0"," ");
        testList.addItem("1","", testDate);
        testList.addItem("2","321", testDate);

        //Update item description. (This is a bad description and should result in a failed update)
        testList.updateItem("1","3",space257,testDate);

        //Concatenate the descriptions.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getDescription();
        }

        //Test expected descriptions.
        assertEquals("321",result);
    }

    @Test
    void doesNameExist_does_exist() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        assertTrue(testList.doesNameExist("1"));
    }

    @Test
    void doesNameExist_does_not_exist() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        assertFalse(testList.doesNameExist("3"));
    }

    @Test
    void removeItem() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate);
        testList.addItem("2","", testDate);

        //Remove the item.
        testList.removeItem("1");

        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //compare names of all items to expected names of items.
        assertEquals("2",result);
    }

    @Test
    void isDescriptionValid_less_than_256() {
        TodoList testList = new TodoList();
        assertTrue(testList.isDescriptionValid("234"));
    }

    @Test
    void isDescriptionValid_256() {
        TodoList testList = new TodoList();
        String space256 = new String(new char[256]).replace("\0"," ");
        assertTrue(testList.isDescriptionValid(space256));
    }

    @Test
    void isDescriptionValid_greater_than_256() {
        TodoList testList = new TodoList();
        String space257 = new String(new char[257]).replace("\0"," ");
        assertFalse(testList.isDescriptionValid(space257));
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