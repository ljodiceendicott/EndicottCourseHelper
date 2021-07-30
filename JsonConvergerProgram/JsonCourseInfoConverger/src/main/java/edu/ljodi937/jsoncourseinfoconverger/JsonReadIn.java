/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
This is the JSON-Course-Info Converger
- this was made to converge 2 JSON files that had some similar information that 
I wanted to connect the two
-I first Made a Array List and put the GEN ED list into the ArrayList 
- I then added all the other courses, If the course was already in the list, then I would
not add it but if it wasnt then I would add the new course and make sure the data
was populated with the right data using the COURSE.JAVA class
-Output goes line my line but adds a comma between each making it so that it sorta
makes the JSON Array for you
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/
package edu.ljodi937.jsoncourseinfoconverger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonReadIn {

    Scanner x;
//this is the known size of the array
    public static int arraysize = 1047;
    public static int genedsize;
    public static Gson g;
    public static ArrayList<Course> courselist;
    public static ArrayList<CourseName> cnlist;
    public static void readinAll(){
        //This should be the second file that you use, the one that holds more courses
       
        //Reading in hte file 
        File txt = new File(JsonReadIn.class.getResource("/sp21.json").getFile());
        try {
            BufferedReader br = new BufferedReader(new FileReader(txt));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while((inputLine = br.readLine())!= null){
                sb.append(inputLine);
                sb.append("\n");
            }
           // System.out.println(sb.toString());
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(sb.toString());
            JsonObject objRoot = root.getAsJsonObject();
            //End of reading in the file getting you to the info from JSON
            
            //This point is Parsing the data
            JsonElement sessions = objRoot.get("sessions");
            JsonArray array = sessions.getAsJsonArray();
            JsonObject obj = array.get(0).getAsJsonObject();
            JsonArray courses = obj.get("classes").getAsJsonArray();
           
            //Use a loop in the cases when you get to where the core of the json information is that you need
            for(int i=0; i<courses.size(); i++){
                JsonObject courseobj = courses.get(i).getAsJsonObject();
                boolean found =false;
                //loop that checks to see if the course is already in the arraylist meaning that it is one of the GEN EDs
                for(int j=0; j<courselist.size(); j++){
                    String coursename = courseobj.get("course").getAsString()+" "+courseobj.get("title1").getAsString();
                    if(coursename.equals(courselist.get(j).title)){
                        found = true;
                        break;
                    }
                }
                if(!found){
                Course c = new Course(courseobj.get("course").getAsString()+ courseobj.get("title1").getAsString(), "none", false,false,false,false);
                courselist.add(c);
                }
                found=false;
                }
            
            //end of Parsing the data
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readinGenEd() throws FileNotFoundException {
         courselist = new ArrayList<>();
        File txt = new File(JsonReadIn.class.getResource("/Data.json").getFile());
        g = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(txt));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while((inputLine = br.readLine())!= null){
                sb.append(inputLine);
                sb.append("\n");
            }
           // System.out.println(sb.toString());
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(sb.toString());
            JsonObject objRoot = root.getAsJsonObject();
            JsonElement sessions = objRoot.get("sessions");
            JsonArray array = sessions.getAsJsonArray();
            JsonObject obj = array.get(0).getAsJsonObject();
            JsonArray courses = obj.get("classes").getAsJsonArray();
            genedsize = courses.size();
            for(int i =0; i<genedsize; i++){
                    JsonObject course = courses.get(i).getAsJsonObject();
                    String coursename = course.get("name").getAsString();
                    Course c = new Course(coursename, course.get("genEdReq").getAsString(),course.get("isWriting").getAsBoolean(),course.get("isDEI").getAsBoolean()
                                , course.get("isPerformance").getAsBoolean(), course.get("isLanguage").getAsBoolean());
                        System.out.println(g.toJson(c)+",");
                        courselist.add(c);
            }
           /*  for(int i = 0; i<cnlist.size(); i++){//loops through all courses
                    String coursecode = cnlist.get(i).code;
                    String coursedep = cnlist.get(i).dep;
                    String courseAllName = cnlist.get(i).title;
                    Boolean matches = false;
            for(int j=0;j<genedsize; j++){//loops through all of the Gen-Ed Course requirement array
                JsonObject course = courses.get(j).getAsJsonObject();
                String courseGenName = course.get("name").getAsString();
                    if(courseGenName.equalsIgnoreCase(coursecode+" "+courseAllName)){//if the name matches the course name on there then add the corresponding data
                        matches =true;
                        System.out.println("MATCH");
                        cnlist.get(i).found = true;
                        Course c = new Course(coursecode, coursedep, courseAllName, course.get("genEdReq").getAsString(),course.get("isWriting").getAsBoolean(),course.get("isDEI").getAsBoolean()
                                , course.get("isPerformance").getAsBoolean(), course.get("isLanguage").getAsBoolean());
                        System.out.println(c);
                        courselist.add(c);
                        break;
                    }
                }
                ///Course(String code, String dep, String title1, String gened, boolean write, boolean dei, boolean perform, boolean language){
            }
            for(int i = 0; i<cnlist.size(); i++){
                if(!cnlist.get(i).found){
                    CourseName addc = cnlist.get(i);
                    Course unfoundc = new Course(addc.code,addc.dep, addc.title, "None", false,false,false,false);
                    courselist.add(unfoundc);
                }
            }
            System.out.println(courselist.size()+" w/no matches");
             *///Loop again to see if something was added and if it was not then add it....
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        g = new Gson();
        courselist = new ArrayList<>();
        try {
            JsonReadIn.readinGenEd();
             JsonReadIn.readinAll();
             for(int i = 0; i<courselist.size(); i++){
             String output = g.toJson(courselist.get(i));
             System.out.println(output+",");
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
