package org.buaa.nlp.cj.cci150._8_1;

/**
 * Created by whisky-yonk on 8/26/2015.
 */
public class _1_1_HasDuplicateItem {
    /**
     * 方法一：构建一个Boolean类型的数组
     * @param str
     * @return
     */
    public boolean isUnique(String str) {
        int len = str.length();
        if (len > 256)
            return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < len; i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * 方法二：使用位向量，使得空间占用为原来的1/8
     * @param str
     * @return
     */
    public boolean isUnique2(String str) {
        if (str.length() > 256)
            return false;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        _1_1_HasDuplicateItem hasDuplicateItem = new _1_1_HasDuplicateItem();
        boolean result = hasDuplicateItem.isUnique2("uejfiey");
        System.out.println(result);
    }
}
