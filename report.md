# Report for assignment 3

## Project

Name: Java : Algorithms and Data Structure

URL: https://github.com/phishman3579/java-algorithms-implementation

A collection of algorithms and data structures implemented by Justin Wetherell.

## Onboarding experience

Did it build and run as documented?
    
See the assignment for details; if everything works out of the box,
there is no need to write much here. If the first project(s) you picked
ended up being unsuitable, you can describe the "onboarding experience"
for each project, along with reason(s) why you changed to a different one.


## Complexity

1. What are your results for ten complex functions?
   * Did all methods (tools vs. manual count) get the same result?
   * Are the results clear?
2. Are the functions just complex, or also long?
3. What is the purpose of the functions?
4. Are exceptions taken into account in the given measurements?
5. Is the documentation clear w.r.t. all the possible outcomes?


### NOTES

Here we can add notes from our work on the questions above (before we revise and
finish the report).

#### @nolanderc

| Function                      | nLOC | `lizard` CCN | Manual CCN |
| --------                      | ---: | ---------: | ---------: |
| `BinaryHeapArray.heapDown`    | 62   | 41         | 38         |
| `IntervalTree.Interval.query` | 44   | 27         | 27         |

##### 1.

`lizard` seems to count ternary operators (`condition ? if_true : if_false`) as
having cyclomatic complexity 1. I did the same in the manual results above. The
difference between `lizard`'s and my manual results is a bit harder to explain. In
my manual version I subtracted 1 from the CCN for each exit point (`return`) in
the code, using the following formula
([source](https://en.wikipedia.org/wiki/Cyclomatic_complexity#Definition)):
```
CCN = d - e + 2
```
where `d` is the number of decicion points (`if`s, `for`s, `while`s, `&&`, `||`,
etc.) and `e` the number of exit points (ie. `return`s). If we ignore the term
`e` and pretend that there's a single exit point (ie. `e = 1`) we would end up
with the same answer as `lizard`.

##### 2.

The complexity of the functions seems to be correlated with their length.

##### 3.

A large source of the complexity in the `heapDown` function is handling cases
where either some value is `null` or checking what "mode" we are in (sorting in
ascending or descending order). Other than that, the code is quite simple in nature, all its doing is finding the relative order between three elements.

For `query` we have a similar situation, there are a lot of checks for `null`,
and code is duplicated depending on if a number is less than another, or not.

##### 4.

Every function call/`throw` could potentially be thought of as another branch
either resulting in a branch (if it is caught in a `try-catch`) or an exit point
(if its not caught).


##### 5.

The documentation in the `query` function is quite lacking. It is not
immediately obvious what the function even does (not to mention explaining what
branches check for). The `heapDown` documentation is somewhat better, which at
least includes comments on what the branches are checking for. But the actual
function has no documentation comment, which could make it difficult to understand what it's doing if you aren't familiar with heaps.


#### @mantaur

| Function                                                           | nLOC | `lizard` CCN   | Manual CCN |
| --------                                                           | ---- | -------------- | ---------- |
| `SegmentTree.FlatSegmentTree.NonOverlappingSegment.query`          | 62   | 28             | 18         |
| `SegmentTree.DynamicSegmentTree.OverlappingSegment.createFromList` | 44   | 17             | 17         |

##### 1.
My manual count of the createFromList function mathces that of lizards counting, however my manual count of query is off by almost 30% or by a count of 10. If however I do not consider the numerous returns scattered throughout the function as decreasing the CCN by one I get the same count as lizard.

##### 2.
For the two functions analyzed there seems to be some correlation between nloc and ccn.

##### 3.
###### query
The datastructure who's query function this concerns returns another custom datastructure of non-overlapping segment(s) if they exist.

###### createFromList
Create's a segment tree from corresponding data in a list with segments.

##### 4.
Neither function throw any exceptions.

##### 5.
Both functions are members of the `SegmentTree` class datastructure. Neither of the functions are very clear on the possible outcomes in the form of comments. Rather to understand the possible outcomes one would get a better understanding by looking at the actual code and class structure. 

#### @psalqvist


| Function                                   | nLOC | `lizard` CCN | Manual CCN |
| --------                                   | ---: | ---------: | ---------: |
| `BinarySearchTree.replaceNodeWithNode`     | 45   | 22         | 22         |
| `BinarySearchTree.getDFS`                  | 60   | 23         | 23         |

##### 1.
The results of manual count and lizard's count are equal for CNN. In the manual count, I count a ternary operation as adding 1 to the CNN, as lizard seems to do so. CNN = 2 initially, then I add 1 for `if`, `for`, `while`, `else if`, `&&` and `||` (not for `else`), and subtract 1 to CNN when reaching a `return` statement.

##### 2.
It seems that nLOC correlates somewhat with CNN.

##### 3.
###### replaceNodeWithNode
Takes `nodeToRemoved` and `replacementNode` as input, updates the children of `replacementNode` and finally it's parent.

###### getDFS
Takes `order` as input, which determines if we should run inorder, preorder or postorder on the DFS. Arranges nodes in an array `nodes` in order according to the DFS search, and returns that array.

##### 4.
No need to handle exceptions in either of the functions.

##### 5.
###### replaceNodeWithNode
It is stated that `replacementNode` can be null and that `nodeToRemoved` can't be null in the documentation. Although it is not specified in what way the outcome differs in respect to whether any of these to inputs are null or not null.

###### getDFS
Could be stated in the documentation that if the root of the BST is null the function simply returns an empty array. Shouldn't have to browse through the code to find this fact. Although it is stated that the input `order` determines how the array is sorted, this could be explained in more detail.


#### @Kubha99
| Function                                   | nLOC | `lizard` CCN | Manual CCN |
| --------                                   | ---: | ---------: | ---------: |
| `RedBlackTree.balanceAfterDelete`           | 72   | 22         | 21         |
| `RedBlackTree.balanceAfterInsert`          | 46   | 18         | 15         |

##### 1.

Like @psalqvist, I set CCN=2 and for each `if`, `for`, `while`, `else if`, `&&` and `||` (not for `else`) i added 1 and for each return i subtracted with 1. There was a slight difference between the results computed from manual count and the counting from lizard tool.

##### 2. 
There does exist a similarity between the length of the function and the complexity for it. 

##### 3. 
###### balanceAfterInsert
Has input of `RedBlackNode` as input and balances the given tree, this function is called once we insert a node in the tree

###### balanceAfterDelete
Similar to `balanceAfterInsert` this function takes a `RedBlackNode` and balances the tree after a delete

##### 4. 
In `balanceAfterDelete` there exists a case where an execption needs to be handled. 

##### 5. 
Both of the functions are well documented and there exists line comments explaining what operations are done and sometimes why. 
There also exists documentation for input as well as output.

#### @ekorre1001

| Function                                   | nLOC | `lizard` CCN | Manual CCN |
| --------                                   | ---: | ---------: | ---------: |
| `BTree.validateNode`                       | 59   | 22         | 6          |
| `Multiplication.multiplyUsingFFT`          | 68   | 21         | 18         |

##### 1.

Like @psalqvist, we start with CCN = 2 then add 1 for `if`, `for`, `while`, `else if`, `&&` and `||` (not for `else`), and subtract 1 to CCN when reaching a `return` statement. The result shows a lower manual CCN. It is because that in both functions there are more than 1 return point, especially in the `BTree.validateNode`, almost every `if` statement is followed by a `return` code. 

##### 2.
Looking at the CCN result from lizard it seems like NLOC correlates with CCN. The manual count for `Multiplication.multiplyUsingLogs` also indicates that.

##### 3.
###### validateNode
Takes a `node` object as input and validates the node according to the B-Tree invariants. Returns `True` if valid, else `false`.

###### multiplyUsingFFT
Takes two `string` objects as input and extract the numbers, then multiply the two numbers using Fast Fourier transform method. Returns the result as a `string`.

##### 4.
There are no exceptions in either of the functions.

##### 5.
###### validateNode
This function is well documented since there are many comments that explain what some part of the function does. It is also clear what the input and output are.

###### multiplyUsingFFT
There are no comments in the code which makes it harder for the reader to know what each part does. However, if you are familiar with the FFT method it can be intuitive. 




## Refactoring

Plan for refactoring complex code:

Estimated impact of refactoring (lower CC, but other drawbacks?).

Carried out refactoring (optional, P+):

git diff ...

### @psalqvist: `BinarySearchTree.replaceNodeWithNode`

Refactor to reduce duplication of `if` statements and `&&` operations mainly. To provide an example:

```java
// Remove link from replacementNode's parent to replacement
Node<T> replacementParent = replacementNode.parent;
if (replacementParent != null && replacementParent != nodeToRemoved) {
    Node<T> replacementParentLesser = replacementParent.lesser;
    Node<T> replacementParentGreater = replacementParent.greater;
    if (replacementParentLesser != null && replacementParentLesser == replacementNode) {
        replacementParent.lesser = replacementNodeGreater;
        if (replacementNodeGreater != null)
            replacementNodeGreater.parent = replacementParent;
    } else if (replacementParentGreater != null && replacementParentGreater == replacementNode) {
        replacementParent.greater = replacementNodeLesser;
        if (replacementNodeLesser != null)
            replacementNodeLesser.parent = replacementParent;
    }
}
```

is reduced to:

```java
public void removeParent(Node<T> removed, Node<T> replacement, Node<T> replacementLesser, Node<T> replacementGreater) {
    if (replacement.parent == null || replacement.parent == removed) return;

    if (replacement.parent.lesser == replacement) {
        replacement.parent.lesser = replacementGreater;
        if (replacementGreater != null) replacementGreater.parent = replacement.parent;
        return;
    }
    replacement.parent.greater = replacementLesser;
    if(replacementLesser != null) replacementLesser.parent = replacement.parent;
}
```

`replaceNodeWithNode` originally had an NCC of 30. Now the function is broken down into 4 functions with an NCC of 2, 5, 6 and 6.

For the full changes, see:

```sh
git show 901117ab917522fbe1bce573726f2a26c5446634
```

### @nolanderc: `BinaryHeapArray.heapDown`

The main goal of refactoring should be to reduce the amount of duplication in the `if` statements. For example, there is one that looks like this:
```java
if ((type == Type.MIN && left != null && right != null && value.compareTo(left) > 0 && value.compareTo(right) > 0)
 || (type == Type.MAX && left != null && right != null && value.compareTo(left) < 0 && value.compareTo(right) < 0) {
    ...
}
```
Here the checks for `left != null` and `right != null` are duplicated twice each. Also the comparisons against `value` are repeated twice, but with different operators (`<` and `>`). This pattern is repeated an additional 2-4 times, depending on how you count. 

We can reduce the cyclomatic complexity of this code by restructuring the code so that each check for null only happens once, and which comparison to do against the value is determined by the `type` only a single time. Applying these changes results in something the following:

```java
// determine the order we want nodes in once
int desiredOrder = (type == Type.MIN) ? -1 : 1;
int undesiredOrder = -desiredOrder;

// Do checks against null and perform comparisons against the parent value.
// If their order does not match the desired, we need to swap them.
boolean leftShouldSwap = left != null && Integer.signum(value.compareTo(left)) == undesiredOrder;
boolean rightShouldSwap = right != null && Integer.signum(value.compareTo(right)) == undesiredOrder;

// handle different cases depending on which child needs to swap with the parent
if (leftShouldSwap & rightShouldSwap) {
    // if both need to swap, make sure that swapping preserves the desired order
    return (Integer.signum(left.compareTo(right)) == desiredOrder) ? leftIndex : rightIndex;
} else if (leftShouldSwap) {
    return leftIndex;
} else if (rightShouldSwap) {
    return rightIndex;
} else {
    return -1;
}
```

This is essentially everything the old 46 nLOC function did, but with multiple levels of nested `if` statements and convuluted logic. In the end, the new version uses two functions with a cyclomatic complexity of 2 and 10, respectively. Compare this to the old version which had a cyclomatic complexity of 41.

For a full diff, run the following:
```sh
git show 9b4599289de7c734e4cd7364ce8535fc7d32be90
```

### @nolanderc: `IntervalTree.query`

Here we use the same techniques as before: we remove duplicated code by recognizing that the only differences between two branches are a few variables. This means we can move everything but assignment of these variables outside the ifs, reducing the amount of duplicated code. For example, this was originally in the code:

```java
if (index < center) {
    if (left != null) {
        IntervalData<O> temp = left.query(index);
        if (results == null && temp != null)
            results = temp;
        else if (results != null && temp != null)
            results.combined(temp);
    }
} else if (index >= center) {
    if (right != null) {
        IntervalData<O> temp = right.query(index);
        if (results == null && temp != null)
            results = temp;
        else if (results != null && temp != null)
            results.combined(temp);
    }
}
```

Notice that the only difference between these branches is `left` and `right`. Thus, we can replace the above with:

```java
IntervalData<O> next = index < center ? left : right;
if (next != null) {
    IntervalData<O> temp = next.query(index);
    if (temp != null) results = appendToInterval(results, temp);
}
```

where `appendToInterval` is a helper function performing the same function as the if statements before.

We can then reuse these principles again to further reduce the complexity of the function down from 27 to one function with CCN 7 and another with 2.

```sh
git show 8246a9edbbf6aafb92b3c7e8cf7eb1b33ffb7ab5
```


### @ekorre1001: `Multiplication.multiplyUsingFFT`

To improve the cyclomatic complexity we want to either remove or reduce the use of `if`, `for`, `while`, `else if`, `&&` and `||`. In the multiplyUsingFFT we can find a lot of if statements used to investigate both of the input numbers since they are strings. For instance the following is used to check whether the product is negative.

```java
if ((a.charAt(0) == '-' && b.charAt(0) != '-') || (a.charAt(0) != '-' && b.charAt(0) == '-')) {
      negative = true;
}
```
This can be improved by converting both of the strings to integers and check if the product is negative or not.

```java
int x = Integer.parseInt(a);
int y = Integer.parseInt(b);
if(x*y < 0) negative = true;
```
By doing this we have reduced the cyclomatic complexity but the drawback is that we initiate new variables and we are dependent on another library.

Lastly, we can remove the use of some commonly used operations by promoting them to a function. For instance, since both strings are edited to remove the minus symbol (the following code), we can reduce the complexity by adding a helper function that gets called for each string. The drawback is of course those additional functions.
```java
if (a.charAt(0) == '-') {
    a = a.substring(1);
}
if (b.charAt(0) == '-') {
    b = b.substring(1);
}
```

In the end, we managed to reduce the CCN from 21 to 13.

Git diff: Check the refactor section [here](https://docs.google.com/document/d/1qRhKoisnicSaKS3oRQEs6EaFpCoqO1QLV4kNYcLeAFo/edit?usp=sharing).

### `BTree.validateNode`

As with the previous function we aim to reduce the use of `if`, `for`, `while`, `else if`, `&&` and `||`. In this case a lot of if statements were used to check a specific condition and directly followed by a `return`. For example the following:

```java
if (keySize < minKeySize) {
    return false;
} else if (keySize > maxKeySize) {
    return false;
} else if (childrenSize == 0) {
    return true;
} else if (keySize != (childrenSize - 1)) {
    return false;
} else if (childrenSize < minChildrenSize) {
    return false;
} else if (childrenSize > maxChildrenSize) {
    return false;
}
```

This can be reduced by creating a helper function that does the same thing and then we just need to check the value returned by the helper function. The code above can be replaced with the following:

```java
// make the check in another function and save the result
int checkNonRoot = validateNonRootHelper(keySize, childrenSize);
// return the corresponding boolean
if (checkNonRoot == 0) {
    return false;
} else if (checkNonRoot == 1) {
    return true;
}
```
The drawback is that we need to add a few additional functions and variables.

In the end, we managed to reduce the CCN from 22 to 14.

Git diff: Check the refactor section [here](https://docs.google.com/document/d/1qRhKoisnicSaKS3oRQEs6EaFpCoqO1QLV4kNYcLeAFo/edit?usp=sharing).


## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?

### NOTES

#### @ekorre1001

The code coverage tool I am using is OpenClover which works with the Ant build tool. I followed the provided quick start guide and managed to integrate it with Ant. It was quite easy to do the setup since only a few steps were required, although a few things did not work out initially.

### Your own coverage tool

Show a patch (or link to a branch) that shows the instrumented code to
gather coverage measurements.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff ...

What kinds of constructs does your tool support, and how accurate is
its output?

#### @nolanderc

See `git show 9ef482092816b3367f4d4b45214821ee11019fe3`

It supports `if` statements, `while` loops and `for` loops. The output should
show exactly how many times a code block was executed, and also notify if a code
block has not been executed. Example:

```
BranchCoverageTest.branchCoverageWithNotReached:
  - entry point: 1
  - not reached: 0 <-- NOT REACHED
```

### Evaluation

1. How detailed is your coverage measurement?

2. What are the limitations of your own tool?

3. Are the results of your tool consistent with existing coverage tools?

## Coverage improvement

Show the comments that describe the requirements for the coverage.

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

Number of test cases added: two per team member (P) or at least four (P+).

### NOTES

#### @psalqvist

`BinarySearchTree.replaceNodeWithNode` before: 0%, after: 96,9%

Previously, there existed no explicit test cases for this function. Thus, branch coverage was 0%. Added 8 test cases to improve branch coverage to 96,9%. In the branch coverage report I only run explicit tests for `replaceNodeWithNode`. If not, implicit tests covered a lot of branches unintentionally. This way, the progression of the new explicit tests are more easy to follow.

Branch coverage report: https://docs.google.com/document/d/1n01CraeifGIsWPX0nC88pzylQhwQNforvvrhc141y6M/edit

New test cases:

```sh
git show cf3a7a4078b8bd8208ffc5c74101e9dd44c1ad69
```

#### @ekorre1001

Changed to another function because:

BTree::validateNode: Barely any test for the data structure and no test for this specific function which makes it harder to understand.

Multiplication::multiplyUsingFFT: Above 98% code coverage

The requirements + report can be found [here](https://docs.google.com/document/d/1qRhKoisnicSaKS3oRQEs6EaFpCoqO1QLV4kNYcLeAFo/edit?usp=sharing)

5 Test cases added and can be found in the PrimeTest.java


#### @nolanderc

`BinaryHeapArray.heapDown` before: 94.1%, after: 100.0%.

Branch coverage report: https://docs.google.com/document/d/1IVLQTIkl8IiemVskQ_JFw1sNe5EBXXEWpTxYIQ4-NV0/edit?usp=sharing

For new test cases, see:

```sh
git show 395749c08a93e8b8a063e87849e44543fe1189ac
```

Since the `heapDown` function already had such high branch coverage I also wrote
tests for `BinaryHeapArray.validateNode`:

`BinaryHeapArray.validateNode` before: 57.7%, after: 100.0%.

```sh
git show 8e6d8c7d8d36417133fe66f2c8d80a153d23b3f9 
```

While writing these tests, I also found a bug in the source code. The fix can be seen here: 

```sh
git show 12d42662a86bc770915c15f5d2d24d877b107c06
```

## Self-assessment: Way of working

Current state according to the Essence standard: ...

Was the self-assessment unanimous? Any doubts about certain items?

How have you improved so far?

Where is potential for improvement?

## Overall experience

What are your main take-aways from this project? What did you learn?

Is there something special you want to mention here?
