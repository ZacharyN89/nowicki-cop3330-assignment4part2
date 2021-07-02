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

    public ArrayList<String> getLists(String name){
        ArrayList<String> result = new ArrayList<>();
        //Add each TodoList in allLists to return array as a String.
        //Return the String list.
        return result;
    }

    public ArrayList<String> getListItems(String name){
        ArrayList<String> result = new ArrayList<>();
        //Find the TodoList 'name' by looping through allLists.
        //Make a String list of it's items.
        //Return the String list.
        return result;
    }

    public ArrayList<String> getCompleteItems(String name){
        ArrayList<String> result = new ArrayList<>();
        //Add all TodoLists with a complete flag to a return list. Loop through allLists to check.
        //Return the String list.
        return result;
    }

    public void exportList(String name){
        //Add the TodoList 'name' to a text file

        //BufferedWriter object.
        //Loop through allLists until 'name' is found.
        //Add string to text file with a space.
            //Loop through ArrayList.
            //Add string to text file with a space.
        //Add a new line.
    }

    public void exportAllLists(){
        //Transfer everything in the ListAggregate to a text file.

        //Loop through allLists and add each of those lists spaced.
        //Each line would contain one list.

        //BufferedWriter object.
        //Loop through allLists.
        //Add string to text file with a space.
            //Loop through ArrayList.
            //Add string to text file with a space.
        //Add a new line.
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
