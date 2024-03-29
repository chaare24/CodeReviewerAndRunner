package codereviewerandrunner.TestCode;

import codereviewerandrunner.CorrectCode.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charlesarellano
 */

/****************************
    *   Title: <Insertion Sort>
    *   Author: <Rajat Mishra>
    *   Date: <2018>
    *   Availability: <https://www.geeksforgeeks.org/insertion-sort/>
    * 
    *   Correctness and Testing Purposes
    ****************************/
    
public class InsertionSortTest {

    /*Function to sort array using insertion sort*/
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
  
    /* A utility function to print array of size n*/
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    { 
        int arr[] = { 5, 2, 3, 1, 4 }; 
  
        InsertionSortTest ob = new InsertionSortTest(); 
        ob.sort(arr); 
  
        printArray(arr); 
    }
    
}
