/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    //private static String name;
    private static ArrayList<TodoItem> allItems = new ArrayList<TodoItem>();

    /*
    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }
    */
    public ArrayList<TodoItem> getList(){
        return allItems;
    }

    public void addItem(String itemName){
        //TODO:
        //Make a new TodoItem of 'itemName' and add it to allItems.
        //split based on commas to add the three different parts.
        //If it already exists do nothing.

        //
        allItems.add(new TodoItem(itemName));
    }

    public boolean doesNameExist(String name){
        //Check all lists to see if a list of the same name is already present in the array.
        for(TodoItem object : allItems){
            if(name.equals(object.getName())){
                return true;
            }
        }
        return false;
    }

    public void removeItem(String itemName){
        //Loop through allItems to find TodoItem 'itemName'.
            //Delete it.
    }

    public String listAsString(){
        //Return a string that is all the items separated by a space with the name of the list at the start.

        //Add the list name to a return string.
        //Add each TodoItem in allItems to the return String.
        //return the string
        return "";
    }

    public String completeItemsAsString(){
        //Return a string that is all the complete items separated by a space with the name of the list at the start.

        //Add the list name to a return string.
        //Add each TodoItem in allItems to the return String if isComplete is true.
        //return the string
        return "";
    }
}
