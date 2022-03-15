package com.company;

public class Main {
    
    public static String convertToTime(int num, String format) {
        StringBuilder s = new StringBuilder("");
        int o = 0;
        int p = 0;
        p = num % 60;
        o = num / 60;
        s.append(Integer.toString(o));
        s.append(format);
        if (p<10) s.append("0");
        s.append(Integer.toString(p));
        return s.toString();
    }

    public static void main(String[] args) {
        new StartPage();
    }
}
