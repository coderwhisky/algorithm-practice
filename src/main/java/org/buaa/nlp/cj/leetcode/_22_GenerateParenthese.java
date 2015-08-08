package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 采用递归树的思想，当左括号数大于右括号数时可以加左或者右括号，否则只能加左括号，当左括号数达到n时，剩下全部加右括号
 * Created by Administrator on 2015/7/28.
 */
public class _22_GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public void generate(ArrayList<String> res, String tmp, int lhs, int rhs, int n)
    {
        if(lhs == n)
        {
            for(int i = 0; i < n - rhs; i++)
            {
                tmp += ")";
            }
            res.add(tmp);
            return ;
        }
        generate(res, tmp + "(", lhs + 1, rhs, n);
        if(lhs > rhs)
            generate(res, tmp + ")", lhs, rhs + 1, n);
    }

    public static void main(String[] args) {
        _22_GenerateParenthese generateParenthese = new _22_GenerateParenthese();
        List<String> result = generateParenthese.generateParenthesis(3);
        System.out.println(result.toString());
    }
}
