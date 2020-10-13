package edu.scut.acoustics;

import org.junit.Test;

public class MirrorVectorScanner {
    String string;
    int index = 0;
    String token = "";
    String command = "MLHVCSQTAZmlhvcsqtaz";

    public MirrorVectorScanner(String s) {
        string = s;
    }

    public String getToken() {
        return token;
    }

    public void scan() throws Exception {
        while (index < string.length() && (string.charAt(index) == ' ' || string.charAt(index) == '\n'
                || string.charAt(index) == '\r' || string.charAt(index) == '\t')) {
            index += 1;
        }
        if (index == string.length()) {
            token = "#";
        }
        if (Character.isLetter(string.charAt(index)) && command.indexOf(string.charAt(index)) > -1) {
            token = String.valueOf(string.charAt(index++));
            return;
        }
        if (Character.isDigit(string.charAt(index))) {
            StringBuilder stringBuffer = new StringBuilder(10);
            while (Character.isDigit(string.charAt(index))) {
                stringBuffer.append(index++);
            }
            if (string.charAt(index) == '.') {
                stringBuffer.append(string.charAt(index++));
                if (!Character.isDigit(string.charAt(index))) {
                    throw new Exception("小数点后面不是数字，错误在第" + index + "个字符");
                }
                while (Character.isDigit(string.charAt(index))) {
                    stringBuffer.append(index++);
                }
            }
            token = stringBuffer.toString();
            return;
        }
        if (string.charAt(index) == '-' || string.charAt(index) == '+') {
            StringBuilder stringBuffer = new StringBuilder(10);
            stringBuffer.append(string.charAt(index++));
            if (!Character.isDigit(string.charAt(index))) {
                throw new Exception("正负号后面不是数字，错误在第" + index + "个字符");
            }
            while (Character.isDigit(string.charAt(index))) {
                stringBuffer.append(index++);
            }
            if (string.charAt(index) == '.') {
                stringBuffer.append(string.charAt(index++));
                if (!Character.isDigit(string.charAt(index))) {
                    throw new Exception("小数点后面不是数字，错误在第" + index + "个字符");
                }
                while (Character.isDigit(string.charAt(index))) {
                    stringBuffer.append(index++);
                }
            }
            token = stringBuffer.toString();
            return;
        }
        if (string.charAt(index) == ',') {
            token = ",";
            index += 1;
            return;
        }
        throw new Exception("无法识别的字符，在第" + index + "个字符");
    }

    @Test
    public void test() throws Exception {
        String string = "M17,20c-0.29,0 -0.56,-0.06 -0.76,-0.15 -0.71,-0.37 -1.21,-0.88 -1.71,-2.38 -0.51,-1.56 -1.47,-2.29 -2.39,-3 -0.79,-0.61 -1.61,-1.24 -2.32,-2.53C9.29,10.98 9,9.93 9,9c0,-2.8 2.2,-5 5,-5s5,2.2 5,5h2c0,-3.93 -3.07,-7 -7,-7S7,5.07 7,9c0,1.26 0.38,2.65 1.07,3.9 0.91,1.65 1.98,2.48 2.85,3.15 0.81,0.62 1.39,1.07 1.71,2.05 0.6,1.82 1.37,2.84 2.73,3.55 0.51,0.23 1.07,0.35 1.64,0.35 2.21,0 4,-1.79 4,-4h-2c0,1.1 -0.9,2 -2,2zM7.64,2.64L6.22,1.22C4.23,3.21 3,5.96 3,9s1.23,5.79 3.22,7.78l1.41,-1.41C6.01,13.74 5,11.49 5,9s1.01,-4.74 2.64,-6.36zM11.5,9c0,1.38 1.12,2.5 2.5,2.5s2.5,-1.12 2.5,-2.5 -1.12,-2.5 -2.5,-2.5 -2.5,1.12 -2.5,2.5z";
        MirrorVectorScanner scanner = new MirrorVectorScanner(string);
        while (!scanner.getToken().equals("#")) {
            scanner.scan();
            System.out.println(scanner.getToken());
        }
    }
}
