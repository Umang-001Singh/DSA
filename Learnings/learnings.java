package Learnings;

//1. We can change long to int using this: long num;
// int ans =  num.intValue();
// After doing the calculations, convert the ans back to long using:
// long fans = ans.longValue(); 
// or simply copy int value in the ans variable to fans;

// 2. Giving an initial value to an array which is other than zero(default initial value), 
// int []arr = new int[] {-1,-1,-1,-1,-1,-1};   CURLY BRACKETS REPRESENT THE SIZE OF THE ARRAY AND VALUED INITAILIZED TO IT.


// 3. Use (int)1e9 inplace of Integer. MAX_VALUE, to prevent from overflow, because if we return Integer. MAX_VALUE 
// from recursion and go on adding 1 to it as in this question then it will lead to overflow. 
// 1e9 simply means (1) * (10^9)

// Focus on the number of times the loop is running in a program, especially in the Graphs, eg, Prim's Algorithm.