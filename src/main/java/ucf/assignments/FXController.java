/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class FXController {
    //GUI attributes.
    @FXML private ListView itemArea;
    @FXML private TextField nameArea;
    @FXML private TextField descriptionArea;
    @FXML private TextField filePathArea;
    @FXML private DatePicker dateArea;
    @FXML private CheckBox completeArea;


    private TodoList bigList = new TodoList();
    private TodoItem curItem;


    public void selectItemButton(ActionEvent actionEvent) {
        //Make sure a list has been selected.
        Object selectedObject = itemArea.getSelectionModel().getSelectedItem();
        String lookupName = selectedObject.toString();

        //Make sure the item exists.
        if(selectedObject != null || bigList.doesNameExist(lookupName)){
            //Remember that item for manipulation.
            curItem = bigList.getItem(lookupName);

            //Update GUI.
            nameArea.setText(curItem.getName());
            descriptionArea.setText(curItem.getDescription());
            dateArea.setValue(curItem.getDate());
            completeArea.setSelected(curItem.getComplete());
        }

    }

    public void displayIncompleteListButton(ActionEvent actionEvent) {
        //Clear the itemArea
        itemArea.getItems().clear();
        //Populate item area with items from the list.
        for(TodoItem object : bigList.getList()){
            if(object.getComplete() == false) {
                itemArea.getItems().add(object.getName());
            }
        }
    }

    public void displayCompleteItemsButton(ActionEvent actionEvent) {
        //Clear the itemArea
        itemArea.getItems().clear();
        //Populate item area with items from the list.
        for(TodoItem object : bigList.getList()){
            if(object.getComplete() == true) {
                itemArea.getItems().add(object.getName());
            }
        }
    }

    public void DisplayListItemsButton(ActionEvent actionEvent) {
        displayList();
    }
    
    public void displayList(){
        //Clear the itemArea
        itemArea.getItems().clear();
        //Populate item area with items from the list.
        for(TodoItem object : bigList.getList()){
            itemArea.getItems().add(object.getName());
        }
    }

    public void clear(){
        nameArea.clear();
        descriptionArea.clear();
        dateArea.setValue(LocalDate.now());
        completeArea.setSelected(false);
    }

    public void removeItemButton(ActionEvent actionEvent) {
        //Make sure an item is selected.
        try {
            if (itemArea.getSelectionModel().getSelectedItem() != null) {
                bigList.removeItem(itemArea.getSelectionModel().getSelectedItem().toString());
                //Update ItemArea field.
                displayList();
                clear();
            }
        } catch (Exception e){
            displayList();
            clear();
        }
    }

    public void addItemButton(ActionEvent actionEvent) {
        try {
            //If the date is empty set it to current day.
            if (dateArea.getValue() == null) {
                dateArea.setValue(LocalDate.now());
            }
            //Add a new item based on the fill-able sections of the GUI.
            bigList.addItem(nameArea.getText(), descriptionArea.getText(), dateArea.getValue(), completeArea.isSelected());
            //Update ItemArea field.
            displayList();
            clear();
        } catch (Exception e){
            //Update ItemArea field.
            displayList();
            clear();
        }
    }

    public void itemUpdateButton(ActionEvent actionEvent) {
        //Update an item based on the fill-able sections of the GUI.
        //Make sure an item is selected.
        if(itemArea.getSelectionModel().getSelectedItem() != null ) {
            bigList.updateItem(itemArea.getSelectionModel().getSelectedItem().toString(), nameArea.getText(), descriptionArea.getText(), dateArea.getValue(), completeArea.isSelected());
            //Update ItemArea field.
            displayList();
            clear();
        }
    }

    public void clearSelectionButton(ActionEvent actionEvent) {
        clear();
        itemArea.getSelectionModel().clearSelection();
    }

    public void exportListButton(ActionEvent actionEvent) {
        bigList.outputList(filePathArea.getText());
    }

    public void importListButton(ActionEvent actionEvent) {
        clear();
        String filePath = filePathArea.getText();
        filePath.replaceAll("\\\\","/");
        bigList.importList(filePath);
        displayList();
    }

    public void clearListItemsButton(ActionEvent actionEvent) {
        bigList.clearItems();
        displayList();
    }
}
