# JJ Stack-based language

# Commands
* Console
```
// Print to console
"Text" print
"Text" println
"Text" printError

// Get's string input
input
```
* Stack commands
```
// Duplicate last stack value's
dup
2dup
3dup
4dup

// Swaps last value with last-1
// Result: 20 10
10 20 swap

// Swaps two last values with last-2 values
// Result: 30 40 10 20
10 20 30 40 2swap

// Drops latest value's
drop
2drop
```
* String / float stuff
```
// Converts number value into string
// Result: "124"
124 str

// Converts string to number value
// Result: 776
"776" num

// Concatenate strings
// Result: "ABC"
"AB" "C" concat
```
* List related stuff
```
// Append element to a value
elem arr append

// Get's element at a position of a list
// Pushes array and element value to a stack
id arr at
```
* Math
```
10 20 add
20 10 sub
10 2 div
10 20 mul
10 2 mod
```

* GOTO stuff
```

// Goto some pos
'main' goto
123 goto


// Locate label with some name and pushes index to stack
'main' loc

// Call some label and return back with 'ret' command
'main' call 
34 call

// Return back to caller
ret

// Declare label as a new function
'main' declare
```
* Errors
```
// Push new error
"ERR" newError

// Get's last error message
lastError

// Pop's last error message
popError

// Drops (Ignore's) last error message
dropError

// Counts how many errors we have
errorCount
```
* Logic (Flag)
  * When flag is active - `?command` will work
    * Any command with prefix `?` will run IF flag is active
    * Any command with prefix `??` will run IF flag is inactive
  * Flag can be activated when next commands return truth (Not to stack)
```
// Number Equals
10 20 ==

// Operators
1 2 <
2 2 <=
2 2 >
2 2 >=

// Negate result
negate

// Drop logic flag
dropFlag
```
* Logic flag sample
```
$25 $26 ==
    "value 25 and 26 are equal" ?println

// Another sample
30 $$0

$0 10 ==
    333 str ?println
    ??drop
$0 20 ==
    444 str ?println
    ??drop
$0 30 ==
    555 str ?println
    ??drop
```
* Memory
```
// Set something to a memory
val id set

// Get something from a memory
id get

// ===================
// ALTERNATIVE WAY
// ===================

// Set value to 0
val $$0

// Get value from 0
$0

// ===================
// GET AND INC/SUB
// ===================

// Returns $a and then decrease
$-a

// Returns $a and then increase
$+a

```
* Increment / Decrement
```
// Increment
1 inc
1 2inc
1 3inc
1 4inc

// Decrement
1 dec
1 2dec
1 3dec
1 4dec
```
* Loop
```
// Start point
start

// Loop until number is < 1
10 loop

// Sample
start
    0 get dec 0 set
    0 get loop
```