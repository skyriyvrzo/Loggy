package xyz.cuddlecloud.javax.logging;

import xyz.cuddlecloud.javax.logging.Loggy.Level;

class Test {
    public static void main(String...strings) throws InterruptedException {
        Loggy l = Loggy.getLoggy(null, true, true);

        System.out.println("Starting " + Test.class.getCanonicalName());
        l.setDebugLevel(Level.DEBUG);
        l.log(Level.ALL, l);
        l.log(Level.TRACE, l);
        l.log(Level.DEBUG, l);
        l.log(Level.INFO, l);
        l.log(Level.WARN, l);
        l.log(Level.ERROR, l);
        l.log(Level.FATAL, l);

        Thread.sleep(1000L);

        l.log(Level.ALL, l, l, l);
        l.log(Level.TRACE, l, l, l);
        l.log(Level.DEBUG, l, l, l);
        l.log(Level.INFO, l, l, l);
        l.log(Level.WARN, l, l, l);
        l.log(Level.ERROR, l, l, l);
        l.log(Level.FATAL, l, l, l);

        System.out.println();
        System.out.println("outln");
        System.err.println("errln");
    }
}
