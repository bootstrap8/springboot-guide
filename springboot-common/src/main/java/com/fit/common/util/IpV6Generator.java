package com.fit.common.util;

import java.util.ArrayList;
import java.util.List;

public class IpV6Generator {


    public static void main(String[] args) {

        /**
         * 　格式为X:X:X:X:X:X:X:X，其中每个X表示地址中的16b，以十六进制表示，例如：
         　　ABCD:EF01:2345:6789:ABCD:EF01:2345:6789
         */

        //下面的A代表已经定义好的前缀，后面的,代表可以使用的子网IP范围
        String ipv6 = "AAAA:AAAA:AAAA:AAAA:AAAA:AAAA:,,,,:,,,,";
        new IpV6Generator().GetIPV6(ipv6);
    }

    String output(List<Character> characterList) {
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < characterList.size(); i++) {
            if (i > 0 && i % 4 == 0) {
                ss.append(":");
            }
            ss.append(characterList.get(i));
        }
        return ss.toString();
    }

    void GetIPV6(String knowIPV6) {
        int totalLength = knowIPV6.length();
        String preffix = knowIPV6.substring(0, knowIPV6.indexOf(","));//找到前缀
        //System.out.println(preffix);

        String genEnd = knowIPV6.substring(knowIPV6.indexOf(","), totalLength);//找到需要生成的
        System.out.println(genEnd);
        System.out.println("开始生成IPV6:");
        int genLength = genEnd.replaceAll(":", "").length();//需要生成的ip长度
        List<Character> genIP = new ArrayList<Character>();
        for (int i = 0; i < genLength; i++) {
            genIP.add('0');//每个都初始化为0，然后在0-9 A-Z轮询
        }
        System.out.println(preffix + output(genIP));//输出第一个
        List<String> finalString = new ArrayList<String>();
        finalString.add("F");
        finalString.add(":");//当最终生成的字符串只含有:F时就结束
        int thisIndex = genLength - 1;
        while (!genIP.containsAll(finalString) && thisIndex >= 0) {
            Character thisStr = (genIP.get(thisIndex));
            if (thisStr == '9') {
                genIP.set(thisIndex, 'A');
            } else if (thisStr == 'F') {
                //从后向前找一个不是F的，继续生成
                int tmpIndex = Integer.MAX_VALUE;
                for (int i = genLength - 1; i >= 0; i--) {
                    if (genIP.get(i) != 'F') {
                        tmpIndex = i;//可以处理tmpIndex了
                    }
                }
                if (tmpIndex == Integer.MAX_VALUE)//找不到可以处理的位数了
                {
                    break;
                } else {
                    Character tmpStr = (genIP.get(tmpIndex));
                    if (tmpStr == '9') {
                        genIP.set(tmpIndex, new Character('A'));
                    } else {
                        genIP.set(tmpIndex, new Character((char) ((int) tmpStr + 1)));
                    }

                    thisIndex = genLength - 1;
                    genIP.set(thisIndex, '0');
                }

            } else {
                genIP.set(thisIndex, new Character((char) ((int) thisStr + 1)));
            }

            System.out.println(preffix + output(genIP));//输出这个IPV6

        }
    }

}
