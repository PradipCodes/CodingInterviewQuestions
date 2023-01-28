REST API: Fit Count
***
Use the HTTP GET method to retrieve information from a database of patient medical records. Query https://jsonmock.hackerrank.com/api/medical_records to find all the records. The query result is paginated and can be further accessed by appending to the query string ?page=num where num is the page number, beginning with 1.

The query response from the API is a JSON with the following five fields:

 
```
page: the current page
per_page: the maximum number of results per page
total: the total number of records in the search result
total_pages: the total number of pages to query in order to get all the results
data: an array of JSON objects containing medical records
```
 
The data field in the response contains a list of medical records with the following schema:

```
id: the unique ID of the record
timestamp: the timestamp when the record was generated (In UTC as milliseconds)
userId: the id of the user for whom the transaction has been recorded
userName : the name of the patient for whom the transaction has been recorded
userDob: the date of birth of user in format DD-MM-YYYY
vitals: object, the vitals of the user
    vitals.bloodPressureDiastole: the diastolic pressure reading of the user, mmHg
    vitals.bloodPressureSystole: the systolic pressure reading of the user, mmHg
    vitals.pulse: the pulse rate of the user, beats per minute
    vitals.breathingRate: the breathing rate of the user, breaths per minute
    vitals.bodyTemperature: the body temperature of the user, degrees Fahrenheit
diagnosis: object, the diagnosis for the user
    diagnosis.id: the id of the condition diagnosed
    diagnosis.name: the name of the condition diagnosed
    diagnosis.severity: the severity of the condition diagnosed
doctor: object, the doctor who diagnosed the condition
    doctor.id: the id of the doctor who diagnosed the condition
    doctor.name: the name of the doctor who diagnosed the condition
meta: object, the meta information of the user
    meta.height: The current height of the user, centimeters
    meta.weight: The current weight of the user, pounds
```
 
Return the number of records that have bloodPressureDiastole in the inclusive range of lowerlimit to upperlimit. .

**Function Description**

Complete the function healthCheckup in the editor below.

healthCheckup has the following parameters:
```
int lowerlimit:  lower limit of the range of bloodPressureDiastole

int upperlimit: upper limit of the range of bloodPressureDiastole
```

**Returns**

`int: the number of records that qualify as fit`

**Input Format For Custom Testing**

The first line contains an integer, denoting the lower limit of the range of bloodPressureDiastole.

The second line contains an integer, denoting the upper limit of the range of bloodPressureDiastole.
<details>
<summary>Sample Case 0</summary>

**Sample Input For Custom Testing**
```
120 
160
```
**Sample Output**

`99`

**Explanation**

The records are searched and 99 have diastolic blood pressure within the range.
</details>

<details>
<summary>Sample Case 1</summary>

**Sample Input For Custom Testing**
```
110
120
```

**Sample Output**

`3`

**Explanation**

There were 3 records counted.
</details>