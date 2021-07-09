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

    TodoItem(){
        isComplete = false;
    }

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

    public void setComplete(boolean flag){
        isComplete = flag;
    }

    public boolean getComplete(){
        return isComplete;
    }

    public String getAsString(){
        //Return the name and date formatted as a String with a space between them.
        return  "";
    }
}
