Longest Increasing Subsequence
***

A subsequence is created by deleting zero or more elements from a sequence while maintaining order.

A sequence is strictly increasing if every element in the sequence is greater than the previous element. For example, [1, 2, 3] is strictly increasing while [1, 2, 2] is not.

Given an array of integers, determine the length of the longest strictly increasing subsequence.

For example, s = [1, 2, 2, 3, 1, 6]. Two strictly increasing subsequences are (1,2), (1, 2, 3). The longest increasing subsequence has a length of 4: LIS = [1,2,3,6].

**Function Description**

Complete the function findLIS in the editor below.

findLIS has the following parameter(s):
```
int s[n]:  an array of integers
```
 
Returns:
```
int: the length of the longest strictly increasing subsequence in the array
```

Constraints:
```
1 ≤ n < 1000
1 ≤ s[i] ≤ 1000000
```
**Input Format for Custom Testing**

Input from stdin will be processed as follows and passed to the function.

The first line contains an integer n, the size of the array s.

Each of the next n lines contains an integer s[i] where 1 ≤ i ≤ n.
<details>
<summary>Sample Case 0</summary>

**Sample Input 0**

|   STDIN  |     Function Parameters |
|   -----  |      -------------------   |
|   3     | →    s[] Size = 3 |
|   1     | →     s[] = [ 1,  | 
|   4   |              4,    |
|   3   |               3 ]    |

**Sample Output 0**

`2`

**Explanation 0**

Inputs are s=[1,4,3]. Increasing subsequences are [1,4] and [1,3].
</details>

<details>
<summary>Sample Case 1</summary>

**Sample Input 1**

|   STDIN   |   Function Parameters |
|   -----   |   -------------------
|   5   | →  s[] Size = 5   |
|   1   | →  s = [1,4,5,2,6] |
|   4   |       |
|   5   |          |
|   2   |          | 
|   6   |          |   

**Sample Output 1**

`4`

**Explanation 1**

The longest increasing subsequence is [1,4,5,6].
</details>

<details>
<summary>Sample Case 2</summary>

**Sample Input 2**

| STDIN | Function Parameters |
| ----- |   ------------------- |
| 4 | →  s[] Size = 4 |
| 2 | →  s[] = [ 2, 3, 3, 5 ] |
| 3 |  |             
| 3 |  |               
| 5 |  |              

**Sample Output**

`3`

**Explanation**

The longest increasing subsequence is [2,3,5].
</details>