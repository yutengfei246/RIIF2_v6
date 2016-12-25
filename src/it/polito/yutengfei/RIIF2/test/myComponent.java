package it.polito.yutengfei.RIIF2.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myComponent {
    private final List<String> exts = new ArrayList<String>() {{
        add("myCom1");
        add("myCom2");
    }};
    private final List<String> impls = new ArrayList<String>() {{
        add("temp1");
        add("temp2");
    }};
    private Double myPar=10.0;
    private Map<String,Double> myParAssoc= new HashMap<String,Double>() {{ put("it",null);put("is",null);}};
    private Double[ ][ ] myParVector= new Double[ ][ ] { {1.0,1.0},{2.0,2.0} };
    private final Double myConstant=10.0;
}