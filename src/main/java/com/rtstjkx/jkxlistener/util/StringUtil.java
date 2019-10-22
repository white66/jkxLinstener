package com.rtstjkx.jkxlistener.util;

import org.springframework.util.StringUtils;

public class StringUtil {
    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString
     *            16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] toByteArray(String hexString) {
        if (StringUtils.isEmpty(hexString))
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }

    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray
     *            需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

    /**
     * 十进制正负数转二进制字符串
     * @param number
     * @return
     */
    public static String tenTurnTwo(int number) {
        StringBuffer sb = new StringBuffer();
        if (number > 0) {
            while (number != 0) {
                if (number > 0) {
                    sb.insert(0,number % 2);
                    number = number / 2;
                }
            }
        } else if (number < 0) {
            for (int i = 0; i < 8; i++) {
                // 0x80000000 是一个首位为1，其余位数为0的整数
                int t = (number & 0x80000000 >>> i) >>> (31 - i);
                sb.append(t);
            }
        } else if(number==0){
            sb.append("00000000");
        }
        while(sb.length()<8){
            sb.reverse();
            sb.append("0");
            sb.reverse();
        }
        return sb.toString();
    }
    public static int fuTurnzheng(int number){
        int resultNum=0;
        if(number>=0){
            resultNum = number;
        }else if(number<0){
            resultNum= 256+number;
        }
        return resultNum;
    }

    /**
     * 接受下位机的数据检验成功后返回一条数据
     * @param order
     * @return
     */
    public static byte[] backMag(int order ){
        byte[] backMsg = new byte[13];
        backMsg[0]=0X7D;
        backMsg[1]=0X7D;
        backMsg[2]=0X0E;
        backMsg[3]=0X01;
        backMsg[4]= (byte)order;
        backMsg[5]=0X00;
        backMsg[6]=0X02;
        backMsg[7]= (byte) 0XAA;
        backMsg[8]=0X55;
        backMsg[9]=0X02;
        backMsg[10]= (byte) 0X8C;
        backMsg[11]=0X0D;
        backMsg[12]=0X0D;
        return backMsg;
    }
}
