/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codereviewerandrunner;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author charlesarellano
 */
public class runTestCode extends runCode{
    @Override
    public void compileRunCode(String fileName) {
        String noExtension = FilenameUtils.removeExtension(fileName);
        System.out.println("\nRUNNING:");
        try {
            runProcess("pwd");
            System.out.println("**********");
            runProcess("javac -cp src src/codereviewerandrunner/TestCode/" + fileName);
            System.out.println("**********");
            runProcess("java -cp src codereviewerandrunner/TestCode/" + noExtension);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
