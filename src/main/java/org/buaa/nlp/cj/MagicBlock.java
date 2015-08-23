package org.buaa.nlp.cj;

/**
 * Created by whisky-yonk on 8/23/2015.
 * 手里拿着一个六面魔方，正面对着的是白色，左侧是绿色，上面是白色
 * 阿里2016笔试：主观题第一题
 *
 * 解析：
 * 0-正：
 1-上：
 2-左
 3-右
 4-下
 5-背

 顺时针旋转90度:
 上:0:0,1,2->2:0,1,2->5:6,7,8->3:0,1,2
 右：0:2,5,8->1:2,5,8->5:2,5,8->4:2,5,8
 左：0:0,3,6->4:0,3,6->5:0,3,6->1:0,3,6
 正：1:6,7,8->3:0,3,6->4:0,1,2->2:8,5,2
 下：2:6,7,8->5:0,1,2->3:6,7,8->0:6,7,8
 背：1:0,1,2<-3:2,5,8<-4:6,7,8<-2:0,3,6
 */
public class MagicBlock {
    char[][] block = new char[6][9];

    public void init() {
        for (int i = 0; i < 9; i++) {
            block[0][i] = 'R'; // 红色
            block[1][i] = 'W'; // 白色
            block[2][i] = 'G'; // 绿色
            block[3][i] = 'Y'; // 黄色
            block[4][i] = 'O'; // 橙色
            block[5][i] = 'B'; // 蓝色
        }
    }

    /**
     * 最上边的一面顺时针旋转90度
     */
    public void Uoperate() {
        char[] tmp = new char[3];
        tmp[0] = block[0][0];
        tmp[0] = block[0][1];
        tmp[0] = block[0][2];

        block[0][0] = block[3][0];
        block[0][1] = block[3][1];
        block[0][2] = block[3][2];

        block[3][0] = block[5][8];
        block[3][1] = block[5][7];
        block[3][2] = block[5][6];

        block[5][8] = block[2][0];
        block[5][7] = block[2][1];
        block[5][6] = block[2][2];

        block[2][0] = tmp[0];
        block[2][1] = tmp[1];
        block[2][2] = tmp[2];
    }

    /**
     * 右侧的一面顺时针旋转90度
     */
    public void Doperate() {
        char[] tmp = new char[9];
        for (int i = 2; i < 9; i += 3) {
            tmp[i] = block[5][i];
            block[4][i] = block[5][i];
            block[5][i] = block[1][i];
            block[1][i] = block[0][i];
            block[0][i] = tmp[i];
        }
    }

    /**
     * 左侧的一面顺时针旋转90度
     */
    public void Foperate() {
        char[] tmp = new char[9];
        for (int i = 0; i < 9; i += 3) {
            tmp[i] = block[0][i];
            block[0][i] = block[1][i];
            block[1][i] = block[5][i];
            block[5][i] = block[4][i];
            block[4][i] = tmp[i];
        }
    }

    /**
     * 正对着的一面顺时针旋转90度
     */
    public void Boperate() {
        char[] tmp = new char[9];
        tmp[0] = block[1][6];
        tmp[1] = block[1][7];
        tmp[2] = block[1][8];

        block[1][6] = block[2][8];
        block[1][7] = block[2][5];
        block[1][8] = block[2][2];

        block[2][2] = block[4][0];
        block[2][5] = block[4][1];
        block[2][8] = block[4][2];

        block[4][0] = block[3][6];
        block[4][1] = block[3][3];
        block[4][2] = block[3][0];

        block[3][0] = tmp[0];
        block[3][3] = tmp[1];
        block[3][6] = tmp[2];
    }

    /**
     * 下面的一面顺时针旋转90度
     */
    public void Loperate() {
        char[] tmp = new char[3];
        tmp[0] = block[0][6];
        tmp[1] = block[0][7];
        tmp[2] = block[0][8];

        block[0][6] = block[3][6];
        block[0][7] = block[3][7];
        block[0][8] = block[3][8];

        block[3][6] = block[5][2];
        block[3][7] = block[5][1];
        block[3][8] = block[5][0];

        block[5][2] = block[2][6];
        block[5][1] = block[2][7];
        block[5][0] = block[2][8];

        block[2][6] = tmp[0];
        block[2][7] = tmp[1];
        block[2][8] = tmp[2];
    }

    /**
     * 背对着的一面顺时针旋转90度
     */
    public void Roperate() {
        char[] tmp = new char[3];
        tmp[0] = block[1][0];
        tmp[1] = block[1][1];
        tmp[2] = block[1][2];

        block[1][0] = block[3][2];
        block[1][1] = block[3][5];
        block[1][2] = block[3][8];

        block[3][2] = block[4][8];
        block[3][5] = block[4][7];
        block[3][8] = block[4][6];

        block[4][8] = block[2][6];
        block[4][7] = block[2][3];
        block[4][6] = block[2][0];

        block[2][6] = tmp[0];
        block[2][3] = tmp[1];
        block[2][0] = tmp[2];


    }

    public void printblocki(int i) {
        System.out.print(block[i][4]);
        System.out.print(block[i][6]);
        System.out.print(block[i][7]);
        System.out.print(block[i][8]);
        System.out.print(block[i][5]);
        System.out.print(block[i][2]);
        System.out.print(block[i][1]);
        System.out.print(block[i][0]);
        System.out.print(block[i][3]);
        System.out.println();
    }

    public void printblock() {
        for (int i = 0; i < 6; i ++)
            printblocki(i);
    }

    public static void main(String[] args) {
        MagicBlock magicBlock = new MagicBlock();
        magicBlock.init();
        magicBlock.printblock();
        magicBlock.Boperate();
        System.out.println();
        magicBlock.printblock();
    }

}
