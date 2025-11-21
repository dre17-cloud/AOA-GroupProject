# AOA-GroupProject Documentation/Theory Component

## Function Three - Retirement Expense Simulation
### Problem Definition
The `finallyRetired()` function/algorithm will determine the number of years until a retirement account reaches zero when the retiree withdraws a fixed expense every year and earns a fixed interest rate.

### Algorithm Classification
The `finallyRetired()` function/agorithm falls within the problem class of Polynomial Time (P-Type). This is because:
 - It is deterministic; has one outcome which is the number of years until the balance is depleted and an empty balance. 
 - Computable by a single loop, and solvable in linear time (as will be seen in the algorithms design section below).
Thus as stated the algorithm is of Polynomial Time, P-Type solvable with and Algorithm paradignms such as divide-and-conquer, greedy, etc., are not suitable for this problem and would be overkill for this solition because a simple iterative loop is all that's needed.

### Algorithm Design
#### Design Section 1 - High Level Elicitation for finallyRetired()
 - Accept `balance`, `rate`, and `expense` as input parameters. `balance` is the amount the simulation starts with, `rate` the interest of growth as a decimal and `expense` the constant annual withdrawal amount.
 - Iterate while `balance` is greater than to zero. 
 - Each iteration:
  - multiply `balance` by `rate + 1`
  - subtract `expense` from `balance`.
  - increment year counter `year`.
 - Return `year` after loop. 
    
#### Design Section 2 - Pseudo-Code for finallyRetired()
 - START finallyRetired(balance as FLOAT, expense as FlOAT, rate as FLOAT)
 - LET year = 0
 - BEGIN LOOP WHILE balance > 0 
  - balance = balance * (1 + rate)
  - balance = balance - expense
  - year = year + 1
 - END WHILE LOOP
 - RETURN year
 - END finallyRetired() 

 ### Proof of Correctness
 Here I will outline the relevant post and pre conditions for the algorithm and inner loop as well as the loop invariant to prove its correctness:
  - The preconditions for the algorithm are:
   - `balance` and `expense` is non-negative integer greater than zero.
   - `rate` is a percentage expressed as a decimal. 
   - Expense must be greater than the interest gained in the first year.
  - The post-conditions for the algorithm are:
   - `balance` will be less than or equal to zero.
   - `year` will be equal to the iterations it took for balance to deplete to zero or less.
  - Loop Invariant condition for this algorithm is:
   - For `k` iterations, `balance` equals the account value for `k` simulated years.
   - Invariant holds for initialization because, before the loop, `k = 0` and balance for the zero-year would be the input balance.
   - Invariant holds for maintainance because, balance's rate increase and expense deduction is the new account value for that year (k + 1) or `year + 1`. 
   - Invariant holds for termination because, when `balance <= 0`, `k + 1` as we've established is the year that matches the new account balance/value. 


 ### Asymtopic Analaysis (Time and Space Efficincy)
 The algorithms has 5 constant time steps, 3/5 of which take place in a single iterative loop. Therefore the time complexity of this algorithm is the number of loop iterations `n` or O(n). 
 The space complexity is constant because:
  - Algorithm uses variables year (int), balance (int), rate (float), expense (int).
  - It does not recurse and the variables are simply updated.
  - Therefore space conplexity is O(1).
