Package - Route Processing Application



Description - 

1. This project reads .xlsx file as input containing data in the following order- SKU, Start Pincode, Hop Pincode, Stop Pincode. 
2. The result logs in the following format - 
	a. List of Unique SKUs

	b. List of Unique PIN codes in columns Start, Hop and End

	c. List of Unique Routes. A route is a tuple of (Start, Hop, End). 

	d. List of SKUs for each Route

3. This project takes input, validates if the row data is correct and processes it as per the requirement in an efficient way.
4. This project is made to be optimized even for larger data sets and should be able to process more than 100,000 rows of data in just under a few seconds.
5. However, the time taken for processing highly depends on host machine hardware specifications. 
6. JDK 1.8+ highly recommeded for running this application.




Assumptions taken into consideration while development are - 

1. All the columns are expected to be strings.
2. All the pincodes will be 6 character long string values and there will be no special characters included. This is an important part of validation process.
3. There should be no null values or empty strings in any row, else the program is expected to throw an exception.
4. The input file should be in .xlsx format.




To run the application, please follow the steps - 

   1. Open the project in any IDE.

   2. In main application class, there is a variable called path, provide the path of the file which is to be read with "//" as folder 
   separators. 

   3. Run the application.

   4. It will display all the responses that are required question wise along with invalid pincodes that are being used in the code.
