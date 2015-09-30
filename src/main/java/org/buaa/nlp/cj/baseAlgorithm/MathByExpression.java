package org.buaa.nlp.cj.baseAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 中缀表达式： nifix expression
 * 前缀表达式： prefix expression
 * 后缀表达式： suffix expression
 * 中缀表达式转前缀表达式
 * 中缀表达式转后缀表达式
 * 前缀表达式计算数学表达式
 * 后缀表达式计算数学表达式
 * !!!!!! 为了简化，此处仅考虑简单的加减乘除运算, 不包括类似于 ++ 等有两个字符组成的运算符
 * Created by Administrator on 2015/9/30.
 */
public class MathByExpression {
    private static Map<String, Integer> opPriorityMap = new HashMap<>();


    public static void main(String[] args) {
        String[] nifix = {"1","+","(", "(", "2", "+", "3", ")", "*", "4", ")", "-", "5"};
        String[] prefix = nifix2prefix(nifix);
        System.out.println("prefix: " + Arrays.toString(prefix));
        int preRes = calculateByPrefix(prefix);
        System.out.println("res by prefix: " + preRes);

        String[] suffix = nifix2suffix(nifix);
        System.out.println("suffix: " + Arrays.toString(suffix));
        int sufRes = calculateBySuffix(suffix);
        System.out.println("res by suffix: " + sufRes);
    }

    public static int calculateBySuffix(String[] suffix) {
        Stack<Integer> tmpRes = new Stack<>();

        int i = 0;
        while (i < suffix.length) {
            while (i < suffix.length && isOp(suffix[i])) {
                String tmpOp = suffix[i];
                int tnum = Integer.MIN_VALUE;
                int t1 = tmpRes.pop();
                int t2 = tmpRes.pop();
                switch (tmpOp) {
                    case "+" :
                        tnum = t2 + t1;
                        break;
                    case "-" :
                        tnum = t2 - t1;
                        break;
                    case "*" :
                        tnum = t2 * t1;
                        break;
                    case "/" :
                        tnum = t2 / t1;
                        break;
                }
                tmpRes.push(tnum);
                i++;
            }
            while (i < suffix.length && !isOp(suffix[i])) {
                tmpRes.push(Integer.valueOf(suffix[i]));
                i++;
            }
        }
        return tmpRes.pop();
    }

    /**
     * calculate by prefix expression
     * @param prefix
     * @return calculated result
     */
    public static int calculateByPrefix(String[] prefix) {
        Stack<Integer> tmpRes = new Stack<>();

        for (int i = prefix.length-1; i >= 0;) {
            while (i >= 0 && isOp(prefix[i])) {
                String tmpOp = prefix[i];
                int tnum = Integer.MIN_VALUE;
                int t1 = tmpRes.pop();
                int t2 = tmpRes.pop();
                switch (tmpOp) {
                    case "+" :
                        tnum = t1 + t2;
                        break;
                    case "-" :
                        tnum = t1 - t2;
                        break;
                    case "*" :
                        tnum = t1 * t2;
                        break;
                    case "/" :
                        tnum = t1 / t2;
                        break;
                }
                tmpRes.push(tnum);
                i--;
            }
            while (i >= 0 && !isOp(prefix[i])){
                tmpRes.push(Integer.valueOf(prefix[i]));
                i--;
            }
        }
        return tmpRes.pop();
    }

    /**
     * nifix expression to prefix expression
     * (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2；
     (2) 从右至左扫描中缀表达式；
     (3) 遇到操作数时，将其压入S2；
     (4) 遇到运算符时，比较其与S1栈顶运算符的优先级：
     (4-1) 如果S1为空，或栈顶运算符为右括号“)”，则直接将此运算符入栈；
     (4-2) 否则，若优先级比栈顶运算符的较高或相等，也将运算符压入S1；
     (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较；
     (5) 遇到括号时：
     (5-1) 如果是右括号“)”，则直接压入S1；
     (5-2) 如果是左括号“(”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到右括号为止，此时将这一对括号丢弃；
     (6) 重复步骤(2)至(5)，直到表达式的最左边；
     (7) 将S1中剩余的运算符依次弹出并压入S2；
     (8) 依次弹出S2中的元素并输出，结果即为中缀表达式对应的前缀表达式。
     * @param nifix
     * @return
     */
    public static String[] nifix2prefix(String[] nifix) {
        Stack<String> op = new Stack<>();
        Stack<String> num = new Stack<>();

        int i = nifix.length - 1;
        while (i >= 0) {
            // operator
            while (i >= 0 && isOp(nifix[i])) {
                String tmp = nifix[i];
//                String top = op.peek();
                if (tmp.equals("(")) {
//                    String ctmp = op.peek();
                    String top = op.peek();
                    if (top.equals(")")) {
                        op.pop();
                        i--;
                    } else {
                        num.push(op.pop());
                    }
                } else if (op.isEmpty() || tmp.equals(")") || op.peek().equals(")")) {
                    op.push(tmp);
                    i--;
                } else if (opCompare(tmp, op.peek()) >= 0) {
                    op.push(tmp);
                    i--;
                } else if (opCompare(tmp, op.peek()) < 0){
                    num.push(op.pop());
                }
            }
            // numbers
            while (i >= 0 && !isOp(nifix[i])) {
                String ntmp = nifix[i];
                num.push(ntmp);
                i--;
            }
        }
        while (!op.isEmpty()) {
            num.push(op.pop());
        }
//        StringBuffer sb = new StringBuffer();
        String[] res = new String[num.size()];
        int j = 0;
        while (!num.isEmpty()) {
//            sb.append(num.pop());
            res[j++] = num.pop();
        }
        return res;
    }

    /**
     * nifix expression to suffix expression
     * 与转换为前缀表达式相似，遵循以下步骤：
     (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2；
     (2) 从左至右扫描中缀表达式；
     (3) 遇到操作数时，将其压入S2；
     (4) 遇到运算符时，比较其与S1栈顶运算符的优先级：
     (4-1) 如果S1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     (4-2) 否则，若优先级比栈顶运算符的高，也将运算符压入S1（注意转换为前缀表达式时是优先级较高或相同，而这里则不包括相同的情况）；
     (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较；
     (5) 遇到括号时：
     (5-1) 如果是左括号“(”，则直接压入S1；
     (5-2) 如果是右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃；
     (6) 重复步骤(2)至(5)，直到表达式的最右边；
     (7) 将S1中剩余的运算符依次弹出并压入S2；
     (8) 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式（转换为前缀表达式时不用逆序）。
     * @param nifix
     * @return
     */
    public static String[] nifix2suffix(String[] nifix) {
        Stack<String> op = new Stack<>();
        Stack<String> num = new Stack<>();

        int i = 0;
        while (i < nifix.length) {
            // operator
            while (i < nifix.length && opPriorityMap.containsKey(nifix[i])) {
                String tmpOp = nifix[i];
                if (tmpOp.equals(")")) {
                    String top = op.peek();
                    if (top.equals("(")) {
                        op.pop();
                        i++;
                    } else {
                        num.push(op.pop());
                    }
                } else if (op.isEmpty() || tmpOp.equals("(") || op.peek().equals("(")) {
                    op.push(tmpOp);
                    i++;
                } else if (opCompare(tmpOp, op.peek()) > 0) {
                    op.push(tmpOp);
                    i++;
                } else if (opCompare(tmpOp, op.peek()) <= 0) {
                    num.push(op.pop());
                }
            }
            // numbers
            while (i < nifix.length && !opPriorityMap.containsKey(nifix[i])) {
                num.push(nifix[i]);
                i++;
            }
        }

        while (!op.isEmpty()) {
            num.push(op.pop());
        }

        // reverse 逆序
        while (!num.isEmpty()) {
            op.push(num.pop());
        }

//        StringBuilder sb = new StringBuilder();
        String[] res = new String[op.size()];
        int j = 0;
        while (!op.isEmpty()) {
//            sb.append(op.pop());
            res[j++] = op.pop();
        }

        return res;
    }

    /**
     * compare the priority between {@param op1} and {@param op2}
     * return 1 if op1>op2, 0 if op1==op2, -1 if op1 < op2
     * @param op1
     * @param op2
     * @return
     */
    public static int opCompare(String op1, String op2) {
        if (!opPriorityMap.containsKey(op1) || !opPriorityMap.containsKey(op2))
            throw new IllegalArgumentException();
        int tmp = opPriorityMap.get(op1) - opPriorityMap.get(op2);
        if (tmp < 0) {
            return 1;
        } else if (tmp == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * return true if is operator, or return false
     * @param op
     * @return
     */
    public static boolean isOp(String op) {
        return opPriorityMap.containsKey(op);
    }

    static {
        opPriorityMap.put("(",1);
        opPriorityMap.put(")",1);
        opPriorityMap.put("[",1);
        opPriorityMap.put("]",1);
        opPriorityMap.put(".",1);
        opPriorityMap.put("!",2);
        opPriorityMap.put("~",2);
        opPriorityMap.put("++",2);
        opPriorityMap.put("--",2);
        opPriorityMap.put("*",3);
        opPriorityMap.put("/",3);
        opPriorityMap.put("%",3);
        opPriorityMap.put("+",4);
        opPriorityMap.put("-",4);
        opPriorityMap.put("<<",5);
        opPriorityMap.put(">>",5);
        opPriorityMap.put(">>>",5);
        opPriorityMap.put("<",6);
        opPriorityMap.put(">",6);
        opPriorityMap.put("<=",6);
        opPriorityMap.put(">=",6);
        opPriorityMap.put("instanceof",6);
        opPriorityMap.put("==",7);
        opPriorityMap.put("!=",7);
        opPriorityMap.put("&", 8);
        opPriorityMap.put("^", 9);
        opPriorityMap.put("|", 10);
        opPriorityMap.put("&&", 11);
        opPriorityMap.put("||", 12);
        opPriorityMap.put("?:", 13);
        opPriorityMap.put("=", 14);
        opPriorityMap.put("+=", 14);
        opPriorityMap.put("-=", 14);
        opPriorityMap.put("*=", 14);
        opPriorityMap.put("/=", 14);
        opPriorityMap.put("%=", 14);
        opPriorityMap.put("&=", 14);
        opPriorityMap.put("|=", 14);
        opPriorityMap.put("^=", 14);
        opPriorityMap.put("~=", 14);
        opPriorityMap.put("<<=", 14);
        opPriorityMap.put(">>=", 14);
        opPriorityMap.put(">>>=", 14);
    }

}
