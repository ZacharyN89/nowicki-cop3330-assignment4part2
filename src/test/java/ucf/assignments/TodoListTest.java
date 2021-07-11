/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

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
        testList.addItem("","", testDate, false);
        testList.addItem("2","", testDate, false);

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
        testList.addItem("1",space257, testDate, false);
        testList.addItem("2","", testDate, false);

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
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        //Update item name.
        testList.updateItem("1","3","",testDate, false);

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
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        //Update item description.
        testList.updateItem("1","1","123",testDate, false);

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
        testList.addItem("1","", testDate, false);

        //Update item date.
        LocalDate newDate = LocalDate.of(2001,02,12);
        testList.updateItem("1","1","123",newDate, false);

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
    void updateItem_check_date_2() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        LocalDate next = LocalDate.of(2000,01,01);
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", next, false);

        //Update item date.
        LocalDate newDate = LocalDate.of(2001,02,12);
        testList.updateItem("1","1","123",newDate, false);

        //Concatenate the dates.
        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getDate().toString();
        }

        //Test expected dates.
        assertEquals("2001-02-122000-01-01",result);
    }

    @Test
    void updateItem_check_complete() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate, false);

        //Update item complete.
        testList.updateItem("1","1","123",testDate, true);

        //Grab the complete value.
        ArrayList<TodoItem> check = testList.getList();
        boolean boolCheck = false;
        for(TodoItem item : check){
            boolCheck = item.getComplete();
        }

        //Test expected complete.
        assertTrue(boolCheck);
    }

    @Test
    void updateItem_bad_name() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        //Update item name. (This is a bad name and should result in a failed update)
        testList.updateItem("1","","",testDate, false);

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
        testList.addItem("1","", testDate, false);
        testList.addItem("2","321", testDate, false);

        //Update item description. (This is a bad description and should result in a failed update)
        testList.updateItem("1","3",space257,testDate, false);

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
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        assertTrue(testList.doesNameExist("1"));
    }

    @Test
    void doesNameExist_does_not_exist() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        assertFalse(testList.doesNameExist("3"));
    }

    @Test
    void clearItems() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

        //Remove the item.
        testList.clearItems();

        ArrayList<TodoItem> check = testList.getList();
        String result = "";
        for(TodoItem item : check){
            result += item.getName();
        }

        //compare names of all items to expected names of items.
        assertEquals("",result);
    }

    @Test
    void removeItem() {
        //Add some items to a list.
        TodoList testList = new TodoList();
        LocalDate testDate = LocalDate.now();
        testList.addItem("1","", testDate, false);
        testList.addItem("2","", testDate, false);

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
    void importList(){
        try {
            //File reader stuff.
            File file = new File("C:/Users/zipfl/Desktop/Utility/me.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //Read each line and add to items list.
            TodoItem itemToAdd = new TodoItem();
            //for(int i=0; i<2; i++) {
                String itemLine = br.readLine();
                itemLine = br.readLine();
                String[] split = itemLine.split(" ");

                //set name.
                String[] splitName = split[0].split(":");
                String name = splitName[1];

                assertEquals("hi",splitName[1]);


                //set description.
                String[] splitDescription = split[1].split(":");
                String description;
                if(splitDescription.length == 1){
                    description = "";
                } else {
                    description = splitDescription[1];
                }

                assertEquals("",description);

                //set date.
                String[] splitDate = split[2].split(":");
                String[] properDate = splitDate[1].split("-");

                assertEquals("2021",properDate[0]);


                LocalDate date = LocalDate.of(Integer.parseInt(properDate[0]), Integer.parseInt(properDate[1]), Integer.parseInt(properDate[2]));


                //set complete.
                String[] splitComplete = split[3].split(":");
                boolean complete = false;
                if (splitComplete[1].equals("true")) {
                    complete = true;
                }


                itemToAdd.setName(name);
                itemToAdd.setDescription(description);
                itemToAdd.setDate(date);
                itemToAdd.setComplete(complete);

            //}

            br.close();
            LocalDate check = LocalDate.of(2021, 7, 14);

            assertEquals("yes","no");
        }catch(Exception e){

            assertTrue("ye".equals("no"));
        }
    }
}