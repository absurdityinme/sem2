package org.aisd.dz;

import java.util.Stack;

public class PostfixResulting {
    float convert(String s) throws Exception {
        Stack<Float> stack = new Stack<>();
        float temp;
        String[] str = s.split("\\s+");
        for (String string : str) {
            if (Character.isDigit(string.charAt(0))) stack.push(Float.parseFloat(string));
            else {
                temp = switch (string) {
                    case "+" -> stack.pop() + stack.pop();
                    case "-" -> -1 * stack.pop() + stack.pop();
                    case "*" -> stack.pop() * stack.pop();
                    case "/" -> 1 / stack.pop() * stack.pop();
                    default -> throw new Exception("Unrecognizable operand");
                };
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}
