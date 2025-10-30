# Working with Number Representations and Bitwise Operations

## Abstract
**Research Question:** How can number systems and bitwise operations be implemented manually to understand low-level data manipulation in Java?  
**Conclusion:** Through manual conversion and binary arithmetic without built-in Java methods, this project demonstrates a strong grasp of binary logic, base conversions, and how bitwise operations affect data at the hardware level.  
**Tools:** Java, IntelliJ IDEA, JDK 8+  
**Skills:** Binary computation, base conversion algorithms, input validation, bitwise logic, low-level algorithm design  

---

## Project Overview
This project explores the relationships between number systems (binary, decimal, hexadecimal) and the logic behind bitwise operations.  
By implementing all functionality from scratch—without using built-in Java conversion or bitwise operators—it simulates how computers represent and manipulate numeric data at a low level.

The program:
- Parses user inputs in multiple numbering systems.  
- Performs manual base conversions between binary, decimal, and hexadecimal.  
- Computes 1’s and 2’s complements.  
- Performs logical binary operations (AND, OR, XOR) and bitwise shifts using only algorithmic logic.

---

## Research Question
How can bitwise operations, complements, and base conversions be performed algorithmically—without built-in operators—to simulate real-world binary computation?

---

## Methodology

**Language:** Java  
**Execution Command:**
```bash
java Operations <num1> <num2> <num3>
````

### Tasks

#### **1. Argument Parsing**

Validate the number of input arguments and terminate gracefully if incorrect.

#### **2. Number System Identification**

Identify each input’s format:

* Binary numbers start with `0b`
* Hexadecimal numbers start with `0x`
* Others are treated as decimal

#### **3. Input Validation**

Ensure valid characters for each numbering system:

* Binary: `0` and `1`
* Decimal: `0–9`
* Hexadecimal: `0–9`, `A–F` (case-insensitive)

#### **4. Base Conversions**

Manually convert between binary, decimal, and hexadecimal systems using iterative and arithmetic logic.

#### **5. 1’s Complement**

Generate the 1’s complement by inverting each bit.

#### **6. 2’s Complement**

Apply 1’s complement, then add one to compute 2’s complement.

#### **7. Logical Operations**

Perform **OR**, **AND**, and **XOR** across all three numbers using algorithmic comparison.

#### **8. Bitwise Shifting**

Simulate left and right bit shifts by manipulating binary strings.

---

## Example Output

### Invalid Input Example

```bash
java Operations 1
```

```
Task 1
Incorrect number of arguments have been provided. Program Terminating!
```

### Invalid Characters Example

```bash
java Operations 15 0b1011 0xhello
```

```
Task 1
Correct number of arguments given.
Task 2
15=Decimal
0b1011=Binary
0xhello=Hexadecimal
Task 3
15=true
0b1011=true
0xhello=false
```

### Successful Run Example

```bash
java Operations 15 0b1011 0xfa
```

```
Task 1
Correct number of arguments given.
Task 2
15=Decimal
0b1011=Binary
0xfa=Hexadecimal
Task 3
15=true
0b1011=true
0xfa=true
Task 4
Start=15,Binary=0b1111,Decimal=15,Hexadecimal=0xf
Start=0b1011,Binary=0b1011,Decimal=11,Hexadecimal=0xb
Start=0xfa,Binary=0b11111010,Decimal=250,Hexadecimal=0xfa
Task 5
15=1111=>0000
0b1011=1011=>0100
0xfa=11111010=>00000101
Task 6
15=1111=>0001
0b1011=1011=>0101
0xfa=11111010=>00000110
Task 7
1111|1011|11111010=11111111
1111&1011&11111010=00001010
1111^1011^11111010=11111110
Task 8
1111<<2=111100,1111>>2=11
1011<<2=101100,1011>>2=10
11111010<<2=1111101000,11111010>>2=111110
```

---

## Restrictions and Prohibited Methods

The following **Java methods and operators were intentionally avoided** to ensure all computations were implemented from scratch:

### Methods Not Used

* `Integer.parseInt()`
* `Integer.toHexString()`
* `Integer.toBinaryString()`
* `Integer.valueOf()`

### Operators Not Used

* `~` (bitwise NOT)
* `&` (bitwise AND)
* `|` (bitwise OR)
* `^` (bitwise XOR)
* `<<` (left shift)
* `>>` (right shift)

All logical behavior was reproduced using **string operations, loops, and conditional logic**.

---

## Core Insights

| Task    | Concept                     | Key Takeaway                                                      |
| ------- | --------------------------- | ----------------------------------------------------------------- |
| **1–3** | Input handling & validation | Emphasized robust input parsing for numeric data.                 |
| **4**   | Base conversions            | Built an algorithmic understanding of positional number systems.  |
| **5–6** | Complements                 | Reinforced how computers represent negative numbers in binary.    |
| **7–8** | Bitwise logic & shifting    | Simulated low-level data manipulation without built-in operators. |

---

## Conclusion

This project demonstrates how binary and hexadecimal systems operate beneath modern programming abstractions.
By manually simulating binary operations, it bridges the gap between **high-level programming** and **hardware-level computation**.
It provided a practical understanding of:

* How different number systems interrelate
* How logical bit manipulation affects stored data
* How to think algorithmically at the bit level

---

## How to Run

1. **Compile**

   ```bash
   javac Operations.java
   ```
2. **Run**

   ```bash
   java Operations <num1> <num2> <num3>
   ```
3. **Examples**

   ```bash
   java Operations 15 0b1011 0xfa
   java Operations 10 0xA 0b110
   ```

---

## Project Structure

```
number-representations-bitwise/
├── Operations.java                # Main program file
└── README.md                      # Project documentation
```
