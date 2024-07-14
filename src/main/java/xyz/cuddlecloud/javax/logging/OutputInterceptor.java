package xyz.cuddlecloud.javax.logging;

import java.io.PrintStream;

public final class OutputInterceptor {

    private static PrintStream originalOut = System.out;
    private static PrintStream interceptor;

    private OutputInterceptor() {}

    public static void a() {
            interceptor = new PrintStream(originalOut) {
            @Override
            public void print(boolean b) {
                super.print(Loggy.getLoggy("").b(b));
            }

            @Override
            public void print(char c) {
                super.print(Loggy.getLoggy("").b(c));
            }

            @Override
            public void print(int i) {
                super.print(Loggy.getLoggy("").b(i));
            }

            @Override
            public void print(long l) {
                super.print(Loggy.getLoggy("").b(l));
            }

            @Override
            public void print(float f) {
                super.print(Loggy.getLoggy("").b(f));
            }

            @Override
            public void print(double d) {
                super.print(Loggy.getLoggy("").b(d));
            }

            @Override
            public void print(char[] s) {
                super.print(Loggy.getLoggy("").b(s));
            }


            @Override
            public void print(String s) {
                super.print(Loggy.getLoggy("").b(s));
            }

            @Override
            public void print(Object obj) {
                super.print(Loggy.getLoggy("").b(obj));
            }
        };

        System.setOut(interceptor);
    }

    static void print(String s) {
        System.setOut(originalOut);
        System.out.print(s);
        System.setOut(interceptor);
    }

    static void println(String s) {
        System.setOut(originalOut);
        System.out.println(s);
        System.setOut(interceptor);
    }
}
