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

#### @psalqvist

#### @Kubha99

#### @ekorre1001



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
