package org.buaa.nlp.cj;

/**
 * Created by Administrator on 2015/7/28.
 */
public class _20_ValidParenthese {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length()%2 != 0)
            return false;
        boolean result = false;
        char[] stack = new char[s.length()+1];
        stack[0] = '#';
        stack[1] = s.charAt(0);
        int top = 1;
        int i = 1;
        while (i < s.length()) {
            if (stack[top] == '#') {
                stack[++top] = s.charAt(i);
                i++;
            } else if (isPair(stack[top], s.charAt(i))) {
                top--;
                i++;
            } else {
                stack[++top] = s.charAt(i);
                i++;
            }
        }
        if (stack[top] == '#')
            result = true;
        return result;
    }

    boolean isPair(char c1, char c2) {
        boolean flag = false;
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))
            flag = true;
        return flag;
    }

    public static void main(String[] args) {
        _20_ValidParenthese validParenthese = new _20_ValidParenthese();
        boolean result = validParenthese.isValid("()[]");
        System.out.println(result);
    }
}
