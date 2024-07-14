package xyz.cuddlecloud.javax.logging;

import java.io.PrintStream;

public final class OutputInterceptor {

    private static PrintStream originalOut = System.out;
    private static PrintStream originalErr = System.err;
    private static PrintStream interceptorOut;
    private static PrintStream interceptorErr;

    private OutputInterceptor() {}

    public static void a() {
            interceptorOut = new PrintStream(originalOut) {
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
        interceptorErr = new PrintStream(originalErr) {
            @Override
            public void print(boolean b) {
                super.print(Loggy.getLoggy("").brr(b));
            }

            @Override
            public void print(char c) {
                super.print(Loggy.getLoggy("").brr(c));
            }

            @Override
            public void print(int i) {
                super.print(Loggy.getLoggy("").brr(i));
            }

            @Override
            public void print(long l) {
                super.print(Loggy.getLoggy("").brr(l));
            }

            @Override
            public void print(float f) {
                super.print(Loggy.getLoggy("").brr(f));
            }

            @Override
            public void print(double d) {
                super.print(Loggy.getLoggy("").brr(d));
            }

            @Override
            public void print(char[] s) {
                super.print(Loggy.getLoggy("").brr(s));
            }


            @Override
            public void print(String s) {
                super.print(Loggy.getLoggy("").brr(s));
            }

            @Override
            public void print(Object obj) {
                super.print(Loggy.getLoggy("").brr(obj));
            }
        };

        System.setOut(interceptorOut);
        System.setErr(interceptorErr);
    }

    class out {
        static void print(String s) {
            System.setOut(originalOut);
            System.out.print(s);
            System.setOut(interceptorOut);
        }

        static void println(String s) {
            System.setOut(originalOut);
            System.out.println(s);
            System.setOut(interceptorOut);
        }
    }

    class err {
        static void print(String s) {
            System.setErr(originalOut);
            System.err.print(s);
            System.setErr(interceptorOut);
        }

        static void println(String s) {
            System.setErr(originalErr);
            System.err.println(s);
            System.setErr(interceptorErr);
        }
    }
}
