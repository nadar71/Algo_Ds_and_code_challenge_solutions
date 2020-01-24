

public class Main{


    public static int opPrec(char ch){
    	switch(ch){
    		case '+':
    		case '-':
    			return 1;
    		case '*':
    		case '/':
    		case '%':
    			return 2;
    		case '^': 
    			return 3;
    		default:
    			return -1;
    	}
    	
    }



	public static String infixToPostfix(String expr){
		MyStack<Character> stack = new MyStack<Character>();
		String output = "";
		char out;
		int length = expr.length();		

		for(int i=0; i < length; i++){
			char ch = expr.charAt(i);
			if (ch <= '9' && ch >= '0') output += ch;
			else {
				switch(ch){
					case '+':
					case '-':
					case '*':
					case '/':
					case '^':
					case '%':
						while( stack.getLength() != 0 && opPrec(ch) <= opPrec((Character)stack.peekAt(stack.getLength())) ){
							out    = stack.pop();
							output = output + " " + out; 
						}				
						stack.push(ch);
						output = output + " ";
						break;
					case '(':
						stack.push(ch);
						break;
					case ')':
					    out = stack.pop();
						while( stack.getLength() != 0  &&  out != '('){
							output = output + " " + out + " ";
							out = stack.pop();
						}
						break;
					default:
						break;
				}
			}
		}

		while( stack.getLength() != 0 ){
			out = stack.pop();
			output = output + " " + out;
		}
		
		return output;

	}


    // Replace '(' with ')' and viceversa
    public static char replaceParenthesis(char tmp){
    	if (tmp == ')') return '(';
		  if (tmp == '(') return ')';
		  return tmp;
    }


    
    // Revese string and replace '(' with ')' and viceversa
    public static String reverse(String str){
  		StringBuilder strb = new StringBuilder(str);
  
  		int upper 		 = str.length()-1;
  		int lower 		 = 0;
  		
  
  		while(lower < upper){
  			char tmp     = replaceParenthesis(strb.charAt(upper));			
  			char lowTerm = replaceParenthesis(strb.charAt(lower));
  
  			strb.setCharAt(upper, lowTerm);
  			strb.setCharAt(lower, tmp);
  			
  			lower++;
  			upper--;
  		}
  		System.out.println("reverse result : "+strb.toString());
  		return strb.toString();

    }



    public static String infixToPre_fix(String expr){
    	String reversedString = reverse(expr);          // reverse and change '(' with ')' and viceversa
    	return reverse(infixToPostfix(reversedString)); // apply infix to postfix and reverse again
    }




	public static void main(String args[]){
		String expr   = "(10+3)*5/(16-4)";
		String result = infixToPre_fix(expr);
		System.out.println("Infix Expr : "+expr);
		System.out.println("Prefix Expr : "+result);

	}

}


/*
reverse result : (4-61)/5*(3+01)
reverse result : *  + 10 3 / 5  - 16 4
Infix Expr : (10+3)*5/(16-4)
Prefix Expr : *  + 10 3 / 5  - 16 4

*/