/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class FXController {
    //GUI attributes.
    @FXML private ListView itemArea;
    @FXML private TextArea inputArea;
    @FXML private TextField nameArea;
    @FXML private TextField descriptionArea;
    @FXML private DatePicker dateArea;
    @FXML private CheckBox completeArea;
    @FXML private AnchorPane mainScreen;


    private TodoList bigList = new TodoList();
    FileChooser fileChooser = new FileChooser();
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save List");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        Stage stage = (Stage) mainScreen.getScene().getWindow();

        File file = fileChooser.showSaveDialog(stage);
        if(file != null){
            try{
                FileWriter write = new FileWriter(file, false);
                PrintWriter printLine = new PrintWriter(write);

                //ArrayList<TodoItem> outputList = bigList.getList();
                for(TodoItem object : bigList.getList()) {
                    String name = object.getName();
                    String description = object.getDescription();
                    String date = object.getDate().toString();
                    String complete = "false";
                    if(object.getComplete()){complete = "true";}
                    printLine.printf("Item:%s " + "Description:%s " + "Date:%s " + "Complete:%s%n", name, description, date, complete);
                }
            }catch(Exception e){

            }
        }
    }

    public void importListButton(ActionEvent actionEvent) {
        fileChooser.setTitle("Save List");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt")
        );

        Stage stage = (Stage) mainScreen.getScene().getWindow();

        File file = fileChooser.showSaveDialog(stage);
        if(file != null){
            printToFile(file);
        }
    }

    public void printToFile(File file){
        try{
            FileWriter write = new FileWriter(file);
            PrintWriter printLine = new PrintWriter(write);

            printLine.println("List:");

            //ArrayList<TodoItem> outputList = bigList.getList();
            for(TodoItem object : bigList.getList()) {
                String name = object.getName();
                String description = object.getDescription();
                String date = object.getDate().toString();
                String complete = "false";
                if(object.getComplete()){complete = "true";}
                printLine.printf("Item:%s " + "Description:%s " + "Date:%s " + "Complete:%s%n", name, description, date, complete);
            }

            printLine.close();
        }catch(IOException e){

        }
    }
}
