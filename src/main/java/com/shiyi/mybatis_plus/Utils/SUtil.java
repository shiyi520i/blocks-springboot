package com.shiyi.mybatis_plus.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 工资工具类
 *
 * @author ：ShiYI
 * @date ：Created in 2022/3/23
 */
public class SUtil {
    public static List<Integer> sToM(String value) {
        List<Integer> out = new ArrayList<>(2);
        if ("1000元以下".equals(value)) {
            out.add(0,0);
            out.add(1,1);
        }
        else if ("1000-2000元".equals(value)) {
            out.add(0,1);
            out.add(1,2);
        }
        else if ("2000-3000元".equals(value)) {
            out.add(0,2);
            out.add(1,3);
        }
        else if ("3000-5000元".equals(value)) {
            out.add(0,3);
            out.add(1,5);
        }
        else if ("5000-8000元".equals(value)) {
            out.add(0,5);
            out.add(1,8);
        }
        else if ("8000-1.2万元".equals(value)) {
            out.add(0,8);
            out.add(1,12);
        }
        else if ("1.2万-2万元".equals(value)) {
            out.add(0,12);
            out.add(1,20);
        }else if ("2万元以上".equals(value)) {
            out.add(0,20);
            out.add(1,100);
        }else if ("面议".equals(value)) {
            out.add(0,0);
            out.add(1,100);
        }else {
            out.add(0,0);
            out.add(1,100);
        }
        return out;
    }


}

