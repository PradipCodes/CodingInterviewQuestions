3. Election
***
Given a database of the results of an election, find the number of seats won by each party. There are some rules to going about this:

```There are many constituencies in a state and many candidates who are contesting the election from each constituency.
Each candidate belongs to a party.
The candidate with the maximum number of votes in a given constituency wins for that constituency.
```

The output should be in the following format: Party Seats_won

The ordering should be in the order of seats won in descending order.
 
**Schema**

There are 2 tables: Candidates and Results.

Candidates

| Name | Type | Description |
| ---  | ---  | ---          |
| id | INTEGER | It is the primary key. |
| gender | STRING | The gender of the candidate. |
| age |	INTEGER | Age of the candidate. |
| party | STRING | The party to which the candidate belongs to. |
 ***

**Results**

| Name | Type | Description |
| ---  | ---  | --- |
| constituency_id | INTEGER | It is the constituency to which the candidate is contesting from. |
| candidate_id | INTEGER | It is the primary key. |
| votes | INTEGER | The number of votes won by the candidate. |
***

**Sample Data Tables**

Candidates

| id | gender |	age | party |
| --- | --- | --- | --- |
| 1 | M | 55 | Democratic |
| 2 | M | 51 | Democratic |
| 3 | F | 62 | Democratic |
| 4 | M | 60 | Republic |
| 5 | F | 61 | Republic |
| 6 | F | 58 | Republic |

Results
| constituency_id | candidate_id | votes |
| --- | --- | --- |
| 1 | 1 | 847529 |
| 1 | 4 | 283409 |
| 2 | 2 | 293841 |
| 2 | 5 | 394385 |
| 3 | 3 | 429084 |
| 3 | 6 | 303890 |

**Expected Output:**
```
Democratic 2

Republic 1
```

```
/*
Enter your query below.
Please append a semicolon ";" at the end of the query
*/
SELECT party, COUNT(DISTINCT constituency_id) as seats_won FROM Candidates JOIN Results ON Candidates.id = Results.candidate_id WHERE Results.votes = (SELECT MAX(votes) FROM Results r WHERE r.constituency_id = Results.constituency_id) GROUP BY party ORDER by seats_won DESC;
```
***

4.  Sorting With Heaps
***
Identify which of the following statements is true, with regards to the heap data structure and its role in sorting.   
Pick ONE option   
- [x] Heap sort functions in O(n log n) asymptotic complexity and a heap of n elements may be constructed in O(n) asymptotic complexiy (i.e. linear time).   
- [ ] Heap sort functions in O(n log n) time and a heap of n elements may be constructed in no better than O(n log n) time   
- [ ] Heap sort functions in O(n^2) time and a heap of n elements may be constructed in no better than O(n log n) time   
- [ ] None of the above are correct.   
***

5. BFS Traversal
***
In a tree where 21 & 13 are children of 1, and 14 & 51 are children of 21, what will be the BFS traversal of that tree starting from 1?
 
Pick ONE option   

- [x] 1->21->14->51->13   
- [ ] 1->13->14->21->51   
- [ ] 1->21->13->14->51   
- [ ] 1->14->51->21->13
***

6. K-Distinct Numbers
***
You are given an integer N. You have to present N as a sum of K distinct odd integers. Choose the relations of K to N which will make this impossible.

Note: The % sign is the modulo operator.   
Pick ONE OR MORE options   
- [ ] K*K>N   
- [x] N%K=0   
- [ ] K*K ≤ N   
- [ ] N%2 ≠ K%2