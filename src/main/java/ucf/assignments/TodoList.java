/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.util.ArrayList;

public class TodoList {
    private static String name;
    private static ArrayList<TodoItem> allItems;

    public void setName(String newName){
        //Update name.
    }

    public void addItem(String itemName){
        //Make a new TodoItem of 'itemName' and add it to allItems.
        //If it already exists do nothing.
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
