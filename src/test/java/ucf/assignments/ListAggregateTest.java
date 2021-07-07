///*
// *  UCF COP3330 Summer 2021 Assignment 4 Solution
// *  Copyright 2021 Zachary Nowicki
// */
//
//package ucf.assignments;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ListAggregateTest {
//
//    @Test
//    void addList() {
//        ListAggregate testBigList = new ListAggregate();
//        testBigList.addList("hello");
//        String testList = testBigList.getListName(0);
//
//        assertEquals("hello", testList);
//    }
//
//    @Test
//    void addTwoList() {
//        ListAggregate testBigList = new ListAggregate();
//        testBigList.addList("hello");
//        testBigList.addList("hi");
//        String check = testBigList.getListNames();
//
//        assertEquals("hellohi", check);
//    }
//
//    @Test
//    void doesNameExist() {
//        ListAggregate testBigList = new ListAggregate();
//        testBigList.addList("hello");
//
//        assertTrue(testBigList.doesNameExist("hello"));
//    }
//
//    @Test
//    void removeList() {
//        ListAggregate testBigList = new ListAggregate();
//        testBigList.addList("hello");
//        testBigList.addList("hi");
//        testBigList.addList("later");
//
//        //testBigList.removeList("later");
//
//        //go through and add up all in a string then test the string. kind of works as is.
//
//        String result = "";
//        result += testBigList.getListName(0);
//        result += testBigList.getListName(1);
//        result += testBigList.getListName(2);
//
////        assertEquals(testBigList.getList(0).toString() + testBigList.getList(1).toString() + testBigList.getList(2).toString(), "failme");
//
//        assertEquals("hellohilater",result);
//        //assertFalse(testBigList.doesNameExist("later"));
//    }
//
//    @Test
//    void getLists() {
//        //Add a list.
//        //assert output to added list.
//    }
//
//    @Test
//    void getListItems() {
//        //Add a list.
//            //Add items to the list.
//        //assert output to added list and its items.
//    }
//
//    @Test
//    void getCompleteItems() {
//        //Add a list.
//            //Add complete items to the list.
//            //Add incomplete items to the list.
//        //assert output to added list and its complete items.
//    }
//}