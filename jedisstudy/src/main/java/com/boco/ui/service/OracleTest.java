package com.boco.ui.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleTest  {
    public static void main(String[] args) {
        Integer integer = 2;
        System.out.println(integer == 2 ? "si" : "fou");
        Map<String,Object> map = new HashMap<String, Object>();
        System.out.println((String)map.get("s"));
        List list = new ArrayList();
        list.add(null);
        System.out.println(list);
    }
}
