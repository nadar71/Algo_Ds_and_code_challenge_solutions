/*
Bracket Match
A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.
Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.
Explain the correctness of your code, and analyze its time and space complexities.
Examples:
input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2

Constraints:
[time limit] 5000ms
[input] string text
1 ≤ text.length ≤ 5000
[output] integer

*/

/*

NB : check in Problems/Stack_pb too for other solutions

- var diffCounter keep trace of the last difference, var answer of all the previous ones
- diffCounter increase at ( and decrease at )
- when diffCounter < 0 , increment it and answer var too

*/

class Main {
  
  static int bracketMatch(String text) {
    int length = text.length();
    int answer = 0;
    int diffCounter = 0;
    for(int i=0; i < length; i++){
      if (text.charAt(i) == '(') diffCounter++;    
      else if (text.charAt(i) == ')') diffCounter--;
      
      if (diffCounter < 0) {
        diffCounter++;
        answer++;
      }
    }
    
    return answer + diffCounter;
    
  }

  public static void main(String[] args) {
    System.out.println("Result for : (()) " + bracketMatch("(())"));
    System.out.println("Result for : (() "  + bracketMatch("(()"));    
    System.out.println("Result for : ())( " + bracketMatch("())("));
    System.out.println("Result for : ((( " + bracketMatch("((("));
    System.out.println("Result for : ))) " + bracketMatch(")))"));    
    
  }

}


/*
Result for : (()) 0
Result for : (() 1
Result for : ())( 2
Result for : ((( 3
Result for : ))) 3
*/
