/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.time.LocalDate;

public class TodoItem {
    private String name;
    private String description;
    private LocalDate date;
    private boolean isComplete;

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setDate(LocalDate newDate){
        date = newDate;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public String getDescription(){
        return description;
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
