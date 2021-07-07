/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.util.ArrayList;

public class TodoItem {
    private static String name;
    private static String description;
    private static String date;
    private static boolean isComplete;

    TodoItem(String newName){
        this.name = newName;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setDate(String newDate){
        //Update date.
        //Update isComplete.
    }

    public void setCompleteFlag(boolean flag){
        //Update isComplete.
    }

    public String get(){
        //Return the name and date formatted as a String with a space between them.
        return  "";
    }

    public String getIfComplete(){
        //If isComplete is true return the item and date as a string.
        return  "";
    }

}
