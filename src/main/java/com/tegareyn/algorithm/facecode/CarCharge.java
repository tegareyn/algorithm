package com.tegareyn.algorithm.facecode;

/**
 * 描述：靠谱的车
 * 程序员小明打了一辆出租车去上班.出租车司机解释说他不喜欢数字4,所以改装了计费表,任何数字位置调到数字4就直接跳过,其余功能都正常 比如:
 * 1. 23再多一块钱就变为25:
 * 2. 39再多一块钱变为50;
 * 3. 399再多一块线变为500:
 * 小明识破了司机的伎俩,准备利用自己的学附败司机的阴谋.
 * 给出计费表的表面读数,返回实际产生的费用
 *
 * @author mocheng
 * @version 1.0
 * @see CarCharge
 * @since 2024/1/24 16:36
 **/
public class CarCharge {

    public static void main(String[] args) {
        int charge = 53505;
        System.out.println(solution(charge));
    }

    public static int solution(int charge) {
        char[] array = (charge + "").toCharArray();
        if (array[array.length - 1] == '5') {
            array[array.length - 1] = '4';
            return Integer.parseInt(new String(array));
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == '0') {
                continue;
            }
            if (array[i] != '0' && array[i] == '5' ) {
                array[i] = '4';
                return Integer.parseInt(new String(array)) - (i == (array.length - 1) ? 0 : 1);
            } else {
                return charge;
            }
        }
        return charge;
    }
}
