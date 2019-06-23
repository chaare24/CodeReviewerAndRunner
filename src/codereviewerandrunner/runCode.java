/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author charlesarellano
 */

/****************************
    *   Title: <How to Compile and Run Java Program from another Java Program>
    *   Author: <Pankaj>
    *   Date: <2018>
    *   Availability: <https://www.journaldev.com/937/compile-run-java-program-another-java-program>
    * 
    *   Modified to fit my requirements
    ****************************/
public class runCode {
    public void compileRunCode(String fileName) {
        String noExtension = FilenameUtils.removeExtension(fileName);
        System.out.println("\nRUNNING:");
        try {
            runProcess("pwd");
            System.out.println("**********");
            runProcess("javac -cp src src/codereviewerandrunner/CorrectCode/" + fileName);
            System.out.println("**********");
            runProcess("java -cp src codereviewerandrunner/CorrectCode/" + noExtension);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
    
    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines("stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(" exitValue() " + pro.exitValue());
      }
    
}
