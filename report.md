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

## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?

### Your own coverage tool

Show a patch (or link to a branch) that shows the instrumented code to
gather coverage measurements.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff ...

What kinds of constructs does your tool support, and how accurate is
its output?

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

## Self-assessment: Way of working

Current state according to the Essence standard: ...

Was the self-assessment unanimous? Any doubts about certain items?

How have you improved so far?

Where is potential for improvement?

## Overall experience

What are your main take-aways from this project? What did you learn?

Is there something special you want to mention here?
