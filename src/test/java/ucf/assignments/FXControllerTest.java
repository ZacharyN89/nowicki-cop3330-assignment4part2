/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Zachary Nowicki
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXControllerTest {

    @Test
    void displayIncompleteListButton() {
        //Set up some lists with complete and incomplete items.
        //compare incomplete items to ItemArea.
    }

    @Test
    void displayCompleteItemsButton() {
        //Set up some lists with complete and incomplete items.
        //compare complete items to ItemArea.
    }

    @Test
    void markItemCompleteButton() {
        //Add an item as incomplete.
        //make it complete.
        //It should show up when the display complete items action is taken.
        //compare ItemArea to item.
    }

    @Test
    void displayListItemsButton() {
        //Set up some lists with complete and incomplete items.
        //compare all items to ItemArea.
    }

    @Test
    void removeListButton() {
        //initialize ListArea
        //Add a few lists.
        //Remove one list.
        //Compare the input lists (Except the removed one) to ListArea.
    }

    @Test
    void removeItemButton() {
        //initialize ListArea
        //Add a few lists and items
        //Remove one item
        //Compare the input items (Except the removed one) to ItemArea.
    }

    @Test
    void addListButton() {
        //initialize ListArea
        //Add a list.
        //Compare the input list to ListArea.
    }

    @Test
    void editListNameButton() {
        //initialize ListArea with a list.
        //Change the list name
        //Compare what the list should be to ListArea.
    }

    @Test
    void addItemButton() {
        //initialize ListArea with a list.
        //Add an item.
        //Compare what the item should be to ItemArea.
    }

    @Test
    void editItemNameButton() {
        //initialize ListArea with a list.
        //initialize ItemArea with items.
        //Change the item name
        //Compare what the item should be to ItemArea.
    }

    @Test
    void editItemDateButton() {
        //initialize ListArea with a list.
        //initialize ItemArea with items.
        //Change the item date
        //Compare what the item should be to ItemArea.
    }
}