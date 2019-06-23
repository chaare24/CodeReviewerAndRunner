/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author charlesarellano
 */
public class runCode {
    public void compileRunCode() {
        try {
            runProcess("pwd");
            System.out.println("**********");
            runProcess("javac -cp src src/codereviewerandrunner/CorrectCode/InsertionSort.java");
            System.out.println("**********");
            runProcess("java -cp src codereviewerandrunner/CorrectCode/InsertionSort");
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
