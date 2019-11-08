package com.rtstjkx.jkxlistener.util;

import com.rtstjkx.jkxlistener.entity.Dsignal;
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
        byte[] bytes = new byte[13];
        int sum=0;
        bytes[0]=0X7D;
        bytes[1]=0X7D;
        bytes[2]=0X0E;
        bytes[3]=0X01;
        bytes[4]=(byte)order;
        bytes[5]=0X00;
        bytes[6]=0X02;
        bytes[7]=(byte)0XAA;
        bytes[8]=0X55;
        //求校验和
        for(int i=0;i<9;i++){
            sum+=(long)bytes[i]>=0?(long)bytes[i]:((long)bytes[i]+256);
        }
        byte[] by = int2bytes(sum);
        bytes[9]=by[0];
        bytes[10]=by[1];
        bytes[11]=0X0D;
        bytes[12]=0X0D;
        return bytes;
    }
    //10进制转byte[],2字节
    public static byte[] int2bytes(int n) {
        int temp1 = 0;
        int  temp2= 0;
        byte[] hex = new byte[2];
        if(n < 256){
            hex[1] = (byte) n;
        } else {
            temp1 = n & 0xff;
            hex[1] = (byte)temp1;//高位
            temp2 = n >> 8;
            hex[0] = (byte)temp2;//低位
        }
        return hex;
    }
    public static byte[] orderMsg(Dsignal dsignal){
        byte[] bytes = new byte[14];
        int sum=0;
        bytes[0]=0X7D;
        bytes[1]=0X7D;
        bytes[2]=0X0E;
        bytes[3]=0X01;
        bytes[4]=(byte)0X84;
        bytes[5]=0X00;
        bytes[6]=0X03;
        bytes[7]=int2bytes(Integer.parseInt(dsignal.getDsZTBYTEA(),2))[1];
        bytes[8]=int2bytes(Integer.parseInt(dsignal.getDsZTBYTEB(),2))[1];
        bytes[9]=int2bytes(Integer.parseInt(dsignal.getDsZTBYTEC(),2))[1];
        //求校验和
        for(int i=0;i<10;i++){
            sum+=(long)bytes[i]>=0?(long)bytes[i]:((long)bytes[i]+256);
        }
        byte[] by = int2bytes(sum);
        bytes[10]=by[0];
        bytes[11]=by[1];
        bytes[12]=0X0D;
        bytes[13]=0X0D;
        return bytes;
    }
}
