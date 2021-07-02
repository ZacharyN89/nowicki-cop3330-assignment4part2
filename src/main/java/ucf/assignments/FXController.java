package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class FXController {

    public void selectListButton(ActionEvent actionEvent) {
        //Remember that list for manipulation.
    }

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

    public void markListCompleteButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Change list flag to marked.
    }

    public void DisplayListItemsButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Populate item area with items from the list.
            //Find the items from the TodoList object.
    }

    public void removeListButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
            //Remove it from the ListAggregate.
        //Remove the text from the ListArea and all the items from the ItemArea.
    }

    public void exportListButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
            //Copy in JSON format to a text file. If it already exists update that list.
    }

    public void removeItemButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        //Make sure an item has been selected.
    }

    public void addListButton(ActionEvent actionEvent) {
        //Make a list based of the name in the input text field.
            //Add the list to the list aggregate and mark as incomplete.
    }

    public void editListNameButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
            //Change name in listAggregate.
        //Update text in ListArea.
    }

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

    public void exportAllListsButton(ActionEvent actionEvent) {
        //Export all lists from ListAggregate to JSON file.
    }
}
