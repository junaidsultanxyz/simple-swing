package com.junaid.simpleswing;

import com.junaid.simpleswing.core.Router;

import javax.swing.*;

public class SwingApplication {

    private static final SimpleConfig DEFAULT_CONFIG = new SimpleConfig(
            "Swing Application", 800, 600
    );

    public static void run (SimpleConfig config){
        Router.populatePages(getBasePackage().getName());

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(config.title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(config.width, config.height);
            frame.setLocationRelativeTo(null);
            frame.add(Router.getParentPanel());
            Router.showPage(Router.getHomePage());

            frame.setVisible(true);
        });
    }

    public static void run(){
        run(DEFAULT_CONFIG);
    }

    private static Package getBasePackage() {
        for (StackTraceElement frame : Thread.currentThread().getStackTrace()) {
            if (frame.getMethodName().equals("main")) {
                try {
                    return Class.forName(frame.getClassName()).getPackage();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Could not resolve caller package", e);
                }
            }
        }
        throw new RuntimeException("Could not find main() on the call stack");
    }

    public static class SimpleConfig {
        public String title;
        public int width;
        public int height;

        public SimpleConfig(String title, int width, int height)
        {
            this.title = title;
            this.width = width;
            this.height = height;
        }
    }
}
