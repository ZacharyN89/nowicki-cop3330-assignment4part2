/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class FXController {
    //GUI attributes.
    @FXML private ListView listArea;
    @FXML private ListView itemArea;
    @FXML private TextArea inputArea;


    private TodoList bigList = new TodoList();
    private TodoItem curItem;


    public void selectItemButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Remember that item for manipulation.
    }

    public void displayIncompleteListButton(ActionEvent actionEvent) {
        //Show all incomplete lists from list aggregate.
    }

    public void displayCompleteItemsButton(ActionEvent actionEvent) {
        //Show all complete lists from list aggregate.
    }

    public void DisplayListItemsButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Populate item area with items from the list.
            //Find the items from the TodoList object.
    }

    /*
    public void removeListButton(ActionEvent actionEvent) {
        //Remove the selected item from the list screen.
        Object select = listArea.getSelectionModel().getSelectedItem();
        listArea.getItems().remove(select);

        //Remove it from the ListAggregate.
        bigList.removeList((String)select);

        //Remove the text from the ListArea and all the items from the ItemArea.

    }*/

    public void exportListButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
            //Copy in JSON format to a text file. If it already exists update that list.
    }

    public void removeItemButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Make sure an item has been selected.
    }

    /*
    public void addListButton(ActionEvent actionEvent) {
        //Get what is in the inputArea.
        String in = inputArea.getText().replaceAll("\n","");

        //If the list is already there we want to do nothing.
        if(!bigList.doesNameExist(in)){
            //Add the list to the list aggregate.
            bigList.addList(in);
            //Update the listArea.
            listArea.getItems().addAll(in);
        }
    }*/

    public void importSpecifiedListsButton(ActionEvent actionEvent) {
        //Look up all names of list separated by comma in the JSON file.
            //Add to ListAggregate.
        //Update ListArea filed.
    }

    public void addItemButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
            //Add a new item with a name from the InputArea in the TodoList object.
        //Update ItemArea field.
    }

    public void editItemNameButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Make sure a item has been selected.
            //Update an item with a name from the InputArea in the TodoList object.
        //Update ItemArea field.
    }

    public void editItemDateButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Make sure a item has been selected.
            //Update an item with a date from the InputArea in the TodoList object.
        //Update ItemArea field.
    }

    public void markItemCompleteButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Change list flag to marked.
    }
}
