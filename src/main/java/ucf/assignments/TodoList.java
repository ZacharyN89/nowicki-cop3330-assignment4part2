/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.time.LocalDate;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<TodoItem> allItems = new ArrayList<TodoItem>();

    public ArrayList<TodoItem> getList(){
        return allItems;
    }

    public boolean addItem(String itemName, String description, LocalDate date){
        //Make a new TodoItem and add it to allItems.
        //This function returns whether it was successfully able to add an item. It won't add the item if one of the fields is filled out wrong.
        //If it already exists do nothing.
        if(!doesNameExist(itemName)){
            TodoItem itemToAdd = new TodoItem();

            //Check valid name.
            if(itemName.isBlank()){
                return false;
            }
            itemToAdd.setName(itemName);

            //Check valid description.
            if(!isDescriptionValid(description)){
                return false;
            }
            itemToAdd.setDescription(description);

            itemToAdd.setDate(date);

            allItems.add(itemToAdd);
            return true;
        }
        return false;
    }

    public boolean updateItem(String itemName, String newName, String description, LocalDate date){
        //This function returns whether it was successfully able to update an item. It won't add the item if one of the fields is filled out wrong.
        //Only update an existing item.
        for(TodoItem object : allItems){
            if(object.getName().equals(itemName)) {
                //Check valid name and description.
                if (newName.isBlank() || !isDescriptionValid(description)) {
                    return false;
                }

                object.setName(newName);
                object.setDescription(description);
                object.setDate(date);

                return true;
            }
        }
        return false;
    }

    public void removeItem(String itemName){
        //Loop through allItems to find TodoItem 'itemName'.
        for(TodoItem object : allItems){
            if(itemName.equals(object.getName())){
                //Delete it.
                allItems.remove(object);
            }
        }
    }

    public boolean doesNameExist(String itemName){
        //Check all lists to see if a list of the same name is already present in the array.
        for(TodoItem object : allItems){
            if(itemName.equals(object.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean isDescriptionValid(String description){
        if(description.length() > 256){
            return false;
        }
        return true;
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
