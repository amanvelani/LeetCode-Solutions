package src.solutions.Blind75.Valid_Parentheses;

import java.util.Stack;

public class validParentheses{
    public static void main(String[] args){
        String s_1 = "()";
        String s_2 = "()[]{}";
        String s_3 = "(]";
        String s_4 = "([)]";
        String s_5 = "{[]}";
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.isValid(s_1)));
        System.out.println("Test 2: " + (s.isValid(s_2)));
        System.out.println("Test 3: " + (!s.isValid(s_3)));
        System.out.println("Test 4: " + (!s.isValid(s_4)));
        System.out.println("Test 5: " + (s.isValid(s_5)));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
/*
    Logic:
    1. We will use a stack to keep track of the opening brackets.
    2. If we encounter a closing bracket we will check if the top of the stack is the corresponding opening bracket.
    3. If it is the corresponding opening bracket then we will pop the element from the stack.
    4. If it is not the corresponding opening bracket then we will push the element to the stack.
    5. If the stack is empty then the string is valid.
*/
class Solution{
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                int peekElem = stack.peek();
                if(c == ')' && peekElem == '('){
                    stack.pop();
                }else if(c == ']' && peekElem == '['){
                    stack.pop();
                }else if(c == '}' && peekElem == '{'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}