package xyz.cuddlecloud.javax.logging;

import java.io.PrintStream;

public final class OutputInterceptor {

    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static PrintStream interceptorOut;
    private static PrintStream interceptorErr;

    private OutputInterceptor() {}

    public static void a() {
            interceptorOut = new PrintStream(originalOut) {
            @Override
            public void print(boolean b) {
                super.print(Loggy4J.getLoggy("").b(b));
            }

            @Override
            public void print(char c) {
                super.print(Loggy4J.getLoggy("").b(c));
            }

            @Override
            public void print(int i) {
                super.print(Loggy4J.getLoggy("").b(i));
            }

            @Override
            public void print(long l) {
                super.print(Loggy4J.getLoggy("").b(l));
            }

            @Override
            public void print(float f) {
                super.print(Loggy4J.getLoggy("").b(f));
            }

            @Override
            public void print(double d) {
                super.print(Loggy4J.getLoggy("").b(d));
            }

            @Override
            public void print(char[] s) {
                super.print(Loggy4J.getLoggy("").b(s));
            }


            @Override
            public void print(String s) {
                super.print(Loggy4J.getLoggy("").b(s));
            }

            @Override
            public void print(Object obj) {
                super.print(Loggy4J.getLoggy("").b(obj));
            }
        };
        interceptorErr = new PrintStream(originalErr) {
            @Override
            public void print(boolean b) {
                super.print(Loggy4J.getLoggy("").brr(b));
            }

            @Override
            public void print(char c) {
                super.print(Loggy4J.getLoggy("").brr(c));
            }

            @Override
            public void print(int i) {
                super.print(Loggy4J.getLoggy("").brr(i));
            }

            @Override
            public void print(long l) {
                super.print(Loggy4J.getLoggy("").brr(l));
            }

            @Override
            public void print(float f) {
                super.print(Loggy4J.getLoggy("").brr(f));
            }

            @Override
            public void print(double d) {
                super.print(Loggy4J.getLoggy("").brr(d));
            }

            @Override
            public void print(char[] s) {
                super.print(Loggy4J.getLoggy("").brr(s));
            }


            @Override
            public void print(String s) {
                super.print(Loggy4J.getLoggy("").brr(s));
            }

            @Override
            public void print(Object obj) {
                super.print(Loggy4J.getLoggy("").brr(obj));
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
