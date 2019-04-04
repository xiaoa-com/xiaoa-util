package com.xiaoa.utils.excel;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestT
 * @Description TODO
 * @Author wanmeng
 * @Date 2019/3/12 9:29
 * @Version 1.0
 **/
public class TestT {
    @Test
    public void testT() {
        Map<Integer, String> headNames = new HashMap<Integer, String>();
        headNames.put(0,"A");
        headNames.put(1,"B");
        headNames.put(3,"D");
        headNames.put(4,"E");
        headNames.put(5,"F");
        int beginRownum = 0;
        ReadExcel2003 excel = new ReadExcel2003();
        List<Map<String, String>> read = excel.read("D:\\a\\1.xls", headNames, beginRownum);
        System.out.println(read);
    }
    @Test
    public void testTT() {
        Map<Integer, String> headNames = new HashMap<Integer, String>();
        headNames.put(0,"A");
        headNames.put(1,"B");
        headNames.put(2,"C");
        headNames.put(3,"D");
        headNames.put(4,"E");
        headNames.put(5,"F");
        int beginRownum = 0;
        ReadExcel2007 excel = new ReadExcel2007();
        List<Map<String, String>> read = excel.read("D:\\a\\a.xlsx", headNames, beginRownum);
        System.out.println(read);
    }

}
