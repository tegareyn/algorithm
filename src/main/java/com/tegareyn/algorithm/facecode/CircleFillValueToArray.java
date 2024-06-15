package com.tegareyn.algorithm.facecode;

/**
 * @ClassName CircleFillValueToArray
 * @Description 请描述类的业务用途
 * @Author mocheng
 * @Since 2021/11/7 12:58
 * @Version 1.0
 **/
public class CircleFillValueToArray {

    public static void main(String[] args) {
        fillAndPrintValue(3, 4);
    }



    public static void fillAndPrintValue (int startNum, int range) {
        if (range >= 0) {
            int [][] array = new int[range][range];
            fillArrayValue(startNum, array);
            printArrayValue(array);
        }
    }

    public static void printArrayValue(int[][] array) {
        if (array != null && array.length > 0) {
            for (int[] ints : array) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] fillArrayValue(int startNum, int[][] array) {
        if (array != null && array.length > 0) {
            int beginIndex = 0;
            int endIndex = array.length -1;
            while (beginIndex < endIndex) {// multi circle fill value operate
                startNum = circleFillArrayValue(startNum, beginIndex, endIndex, array);
                beginIndex++;
                endIndex--;
            }
            if (endIndex > -1 && endIndex == beginIndex) {
                array[endIndex][beginIndex] = startNum;
            }
            return array;
        }
        return null;
    }

    public static int circleFillArrayValue(int startNum, int beginIndex, int endIndex, int [][] array) {
//        System.out.println("moved operate num: " + operateNum + ", start num: " + startNum + ", index: " + beginIndex + "~" + endIndex);
        for(int i = 0; i < 4; i++) {
            startNum = fillArrayValueByOperateNum(i, startNum, beginIndex, endIndex, array);
        }
        return startNum;
    }

    /**
     *
     * @param operateNum 0:right 1:down 2:left 3:up
     * @param startNum the file num of beginning
     * @param beginIndex
     * @param endIndex
     * @param array
     * @return
     */
    public static int fillArrayValueByOperateNum(int operateNum, int startNum, int beginIndex, int endIndex, int [][] array) {
        if (endIndex > beginIndex) {
            if (operateNum > -1 && operateNum < 4) {//move operate
                if (operateNum == 0) {//right move by add col index
                    for(int movedIndex = beginIndex; movedIndex <= endIndex; movedIndex++) {
                        array[beginIndex][movedIndex] = startNum;
                        startNum++;
                    }
                } else if (operateNum == 1){//down move by add row index
                    for(int movedIndex = beginIndex + 1; movedIndex <= endIndex; movedIndex++) {
                        array[movedIndex][endIndex] = startNum;
                        startNum++;
                    }
                } else if (operateNum == 2){//left move by minus col index
                    for(int movedIndex = endIndex - 1; movedIndex >= beginIndex; movedIndex--) {
                        array[endIndex][movedIndex] = startNum;
                        startNum++;
                    }
                } else {//up move by minus row index
                    for(int movedIndex = endIndex - 1; movedIndex > beginIndex; movedIndex--) {
                        array[movedIndex][beginIndex] = startNum;
                        startNum++;
                    }
                }
            }
        }
        return startNum;
    }

}
