Java Developer Tools
====================
JDT is a set of tools to help web developers. Currently it has the ability to convert excel copied and pasted (tab delemited) data into insert, update and delete statements.

Installation
------
To get it up and running quickly, you can just run the .jar file with your jvm. This is done by just a double click in most operating systems.

If you are on ubuntu I have made an install script which also adds the app to your system with an icon. To run this cd to the location you have the repo, go into the build directory and then run ```sudo ./INSTALL```. Here is the commands in order:

```cd <location_of_repo>/build; sudo ./INSTALL```

where <location_of_repo> is where you downloaded/cloned the repo to.

How To - INSERT
---------------
make sure your spreadsheet is in the format:

	table_name  
	Column_1	Column_2	Column_3  
	Data_1_1	Data_1_2	Data_1_3  
	Data_2_1	Data_2_2	Data_1_3  
	Data_3_1	Data_3_2	Data_1_3  

Then highlight from the top-left item to the bottom right in the spreadsheet and hit copy.
Open the JDT and make sure you are in the insert window. Hit paste in the input box, then hit translate and the corrosponding sql statement will pop up in the output box. This is the output for the above data:

	INSERT INTO `table_name` (`Column_1`,`Column_2`,`Column_3`) VALUES ('Data_1_1','Data_1_2','Data_1_3');  
	INSERT INTO `table_name` (`Column_1`,`Column_2`,`Column_3`) VALUES ('Data_2_1','Data_2_2','Data_1_3');  
	INSERT INTO `table_name` (`Column_1`,`Column_2`,`Column_3`) VALUES ('Data_3_1','Data_3_2','Data_1_3');  

How To - UPDATE
---------------
The same as insert, however the data must be as follows

	table_name		
	Column_1	Column_2	Column_3  
	*		  
	Data_1_1	Data_1_2	Data_1_3  
	Data_2_1	Data_2_2	Data_1_3  
	Data_3_1	Data_3_2	Data_1_3  

where the astrix row marks weather a collumn is an ID or not. Multiple columns can make up the ID for an update statement. The output of the above data is:

	UPDATE `table_name` set  `Column_2` = 'Data_1_2'  ,  `Column_3` = 'Data_1_3'  WHERE  `Column_1` = 'Data_1_1' ;  
	UPDATE `table_name` set  `Column_2` = 'Data_2_2'  ,  `Column_3` = 'Data_1_3'  WHERE  `Column_1` = 'Data_2_1' ;  
	UPDATE `table_name` set  `Column_2` = 'Data_3_2'  ,  `Column_3` = 'Data_1_3'  WHERE  `Column_1` = 'Data_3_1' ;  

How To - DELETE
---------------
This is the same as the above insert statements, however the columns are used to identify a row in the database.

	table_name	
	Column_1	Column_2  
	Data_1_1	Data_1_2  
	Data_2_1	Data_2_2  
	Data_3_1	Data_3_2  

The output for this data would be:

	DELETE FROM `table_name` WHERE  `Column_1` = 'Data_1_1'  ,  `Column_2` = 'Data_1_2' ;  
	DELETE FROM `table_name` WHERE  `Column_1` = 'Data_2_1'  ,  `Column_2` = 'Data_2_2' ;  
	DELETE FROM `table_name` WHERE  `Column_1` = 'Data_3_1'  ,  `Column_2` = 'Data_3_2' ;  

Project Info
------------

This project is under the MIT licence.  
Author: Benjamin Kaiser  
Copyright 2012  