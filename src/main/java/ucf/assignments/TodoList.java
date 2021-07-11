/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<TodoItem> allItems = new ArrayList<>();

    public ArrayList<TodoItem> getList(){
        return allItems;
    }

    public boolean addItem(String itemName, String description, LocalDate date, boolean complete){
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
            itemToAdd.setComplete(complete);

            allItems.add(itemToAdd);
            return true;
        }
        return false;
    }

    public boolean updateItem(String itemName, String newName, String description, LocalDate date, boolean complete){
        //This function returns whether it was successfully able to update an item. It won't update the item if one of the fields is filled out wrong.
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
                object.setComplete(complete);

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

    public TodoItem getItem(String searchName){
        TodoItem result = null;
        for(TodoItem object : allItems){
            if(searchName.equals(object.getName())){
                result = object;
            }
        }
        return result;
    }

    public void clearItems(){
        allItems.clear();
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
        return description.length() <= 256;
    }

    public void outputList(String filePath){
        try{
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file);
            PrintWriter printLine = new PrintWriter(fw);

            //ArrayList<TodoItem> outputList = bigList.getList();
            for(TodoItem object : allItems) {
                String name = object.getName();
                String description = object.getDescription();
                String date = object.getDate().toString();
                String complete = "false";
                if(object.getComplete()){complete = "true";}
                printLine.printf("Item:%s~" + "Description:%s~" + "Date:%s~" + "Complete:%s%n", name, description, date, complete);
            }

            printLine.close();
        }catch(IOException e){

        }
    }

    public void importList(String filePath){
        //reset the list of items.
        clearItems();

        try {
            //File reader stuff.
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //Read each line and add to items list.
            String itemLine;
            while((itemLine = br.readLine()) != null) {
                TodoItem itemToAdd = new TodoItem();
                String[] split = itemLine.split("~");

                //set name.
                String[] splitName = split[0].split(":");
                String name = splitName[1];

                //set description.
                String[] splitDescription = split[1].split(":");
                String description;
                if(splitDescription.length == 1){
                    description = "";
                } else {
                    description = splitDescription[1];
                }

                //set date.
                String[] splitDate = split[2].split(":");
                String[] properDate = splitDate[1].split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(properDate[0]),Integer.parseInt(properDate[1]),Integer.parseInt(properDate[2]));

                //set description.
                String[] splitComplete = split[3].split(":");
                boolean complete = false;
                if(splitComplete[1].equals("true")) {
                    complete = true;
                }

                //Add new item.
                addItem(name,description,date,complete);
            }

            br.close();

        }catch(Exception e){

        }
    }
}
