


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




	public static void main(String args[]){
		String expr   = "(10+3)*5/(16-4)";
		String result = infixToPostfix(expr);
		System.out.println("Infix Expr : "+expr);
		System.out.println("Postfix Expr : "+result);

	}

}