ANY QUESTIONS ABOUT ANYTHING TO DO WITH ANY OF THIS EMAIL: jodiceluke@gmail.com

These are all of the Files that are what the website maintains
index.html =***IMPORTANT*
	-is the part of the site that the people will use
	-contains the Javascript that is used to make it so that there is an 	interactive portion of the site

styles Folder=
	Main.css=**IMPORTANT**
		- this is the Cascading Style Sheets or what helps make the website look the way that it should	



Data Folder =

	courseofstudyRawDumpFA21.txt=
		-This is the CARS Raw course dump that advisers use to show the				current status of the different courses as well as if some courses have any pre-requisites as well as the different sections of each course
	
	coursejsonNoGenEd.json=
		- This is the Json form of the Raw Course Dump
		- Had to email a CS Professor in order to get access to this
		- This was for the Semester of Fall 2021
	sp21.json=
		-This is just like the coursejsonNoGenEd.json 
		- this was for the Semsester of Spring 2021
			

	GenEdFA2021.json=
		-This SHOULD be the courses that will be considered GenEd requirements and will be one of the parts that you will use to combine all of the newer courses to
		-This is the main reason for why the website is used for, Showing which courses can fulfill several requirements at once
		- this has the data fields of:
			-name ( a String that contains the course code as well as the course title
			-genEdReq ( a String that contains the info if the course is a General Education Requirement and if so which one, if there is not one for this, use "None"
			-isWriting ( a Boolean that if the course is a writing Designated Course that would fill the writing requirement
			-isDEI ( a Boolean that if the course Fufills  a Diversity, Inclusion, and equity course requirement
			-isPerformance (a Boolean that if the course fufills the Performance Requirement
			-isLanguage (a Boolean that is if the course fulfills a language requirement
	

	AllCourses(genEDandother).json=
		-Just as the file says, it is the combination of the json files of  one like sp21.json and the genEd file
		-Data contains:
			- same data as the GenEd file, just added the semester to have them all from both SP21 + FA21 semesters. this includes all courses includingthe ones that do not fulfill any Requirements 