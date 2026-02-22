package com.junaid.simpleswing.components;

import javax.swing.*;

public abstract class SimplePage extends JPanel {
    public abstract void render();

    public void OnInit() {
        IO.println("OnInit() called on page " + getClass().getSimpleName());
    }
    public void OnExit() {
        IO.println("OnExit() called on page " + getClass().getSimpleName());
    }
}
