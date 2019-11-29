package com.grcen.global;

import java.util.Scanner;

public class TerminalUtils {

    private static final String CORRECT_FORMAT = "请输入正确的格式";
    private static final String CORRECT_INT = "请输入0-100的整数";
    private static final String CORRECT_LONG = "请输入1-9999的整数";
    private static final Scanner in = new Scanner(System.in);


    public static int getIntegerFromTerminal(String tip) {
        int result;
        try {
            result = Integer.parseInt(getStringFromTerminal(tip));
            if (result > 100 || result < 0)
                getIntegerFromTerminal(CORRECT_INT);
        } catch (NumberFormatException e) {
            result = getIntegerFromTerminal(CORRECT_FORMAT);
        }
        return result;
    }

    public static long getLongFromTerminal(String tip) {
        long result;
        try {
            result = Long.parseLong(getStringFromTerminal(tip));
            if (result > 9999 || result <= 0)
                getLongFromTerminal(CORRECT_LONG);
        } catch (NumberFormatException e) {
            result = getLongFromTerminal(CORRECT_FORMAT);
        }
        return result;
    }

    public static String getStringFromTerminal(String tip) {
        System.out.println(tip);
        return in.nextLine();
    }

    public static void enterToContinue() {
        TerminalUtils.getStringFromTerminal("输入任意以继续");
    }

    public static void close() {
        in.close();
    }

    public static void reset() {
        in.reset();
    }
}
