/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.util.ArrayList;

public class ListAggregate {
    private static ArrayList<TodoList> allLists;

    public void addList(String name){
        //Make a new list 'name' and add it to allLists.
    }

    public void removeList(String name){
        //Find the TodoList 'name' and remove it by looping through allLists.
    }

    public String getLists(String name){
        //Call listAsString for every TodoList in allLists with a newLine at the end of each and add to a return string.
        //Return the String list.
        return "";
    }

    public String getListItems(String name){
        //Find the TodoList 'name' by looping through allLists.
        //Make a String list of it's items by calling listAsString and adding to a return String.
        //Return the String list.
        return "";
    }

    public String getCompleteItems(String name){
        //Call completeItemsAsString for every TodoList in allLists with a newLine at the end of each and add to a return string.
        //Return the String list.
        return "";
    }

    public void exportList(String name){
        //Add listAsString to a text file for the TodoList 'name' in allLists.
    }

    public void exportAllLists(){
        //Add listAsString to a text file for every TodoList in allLists.
    }

    public void loadList(String name){
        //Add the TodoList 'name' to a allLists

        //BufferedReader object.
        //Loop through text file until 'name' is found.
            //Make a new TodoList object.
            //Add its items from the text file.
        //Add object to allLists.
    }

    public void loadAllLists(){
        //Add the TodoList 'name' to a allLists

        //BufferedReader object.
        //Loop through text file.
            //Make a new TodoList object.
            //Add its items from the text file.
            //Add object to allLists.
        //Repeat until end of file.
    }
}
