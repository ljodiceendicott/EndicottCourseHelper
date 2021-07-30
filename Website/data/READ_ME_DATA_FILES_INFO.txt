Within this folder there are several different json files. Each of them serve a different pourpose in this process.As you go down the list you get to the final thing that you use for the website

CourseofstudyRawDumpFA21.txt =
	-this file is the raw course dump that is used as a tool for looking at the different classes and how many people are in each class as well as the different sessions for all of the courses
	-This is very hard to parse. I asked for someone to parse this file for me


sp21.json/FA21.json =
	- this is the json form of all of those classes mentioned in the course dump

GenEdFA2021.json=
	-this file shows all of the courses that are considered a graduation reqirement
	-(if this is the file that is being used currently on the website, then it needs to be replaced)

AllCoursesFA21.json/AllCoursesSP21.json=
	-all of the courses that are avaliable to take in each of these semesters is found in their own files

AllCourses.json=
	-All courses from all semesters are found here
	-each course has a field that tell you which semester it is from

EndicottCourselistFA21-SP21.xlsx
	
	-IF YOU ARE ADDING BOOLEAN DATA MANUALLY, MAKE SURE THAT YOU HAVE THE TRUE AND FALSE BE LOWER CASE, UPPER CASE IS TURNED TO A STRING(BREAKS EVERYTHING)
	-this is the recommended way of adding and storing the information 
	-to do this go to Data>Get Data>From File>Json file
	-find json file you want to use
	-navigate until you get to the list you want should be classes( a list of records)
	-click the expland tab on the top of the column and add all of the data 
	-click close and load and it should load into the excel doc
	-Now you would be able to filter the data if you would like
	
	
	-TO PUT BACK TO JSON, SAVE/DOWNLOAD FILE AS A CSV FILE AND GO TO A CSV TO JSON CONVERTER ONLINE AND COPY THEN PASTE THE RESULT INTO A FILE AND SAVE IT AS A JSON FILE