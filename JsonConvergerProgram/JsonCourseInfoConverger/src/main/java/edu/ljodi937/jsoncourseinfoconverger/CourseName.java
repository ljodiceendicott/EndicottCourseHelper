/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ljodi937.jsoncourseinfoconverger;

/**
 *
 * @author jodic
 */
public class CourseName {
    String code;
    String dep;
    String title;
    boolean found;

    CourseName(String code, String dep, String title1){
        this.code = code;
        this.dep = dep;
        this.title= title1;
        this.found = false;
    }
}
