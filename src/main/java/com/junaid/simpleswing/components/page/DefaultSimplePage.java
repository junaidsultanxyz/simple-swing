package com.junaid.simpleswing.components.page;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class DefaultSimplePage extends SimplePage {
    @Override
    public void render() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel heading = new JLabel("How to add custom page:");
        heading.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        heading.setAlignmentX(CENTER_ALIGNMENT);

        JTextArea body = new JTextArea("""
                1. Add '@Page(title = "your_page", home = true)' on class declaration.
                    1.1 `home = true` means it is the initial/first page that will be shown.
                    1.2  if the page is not home, you don't have to write home parameter.
                2. Extend that class with SimplePage and implement render method.
                3. Write UI login in render method.
                4. Use `Router.showPage("page_title")` to switch to that page.
                """);
        body.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        body.setEditable(false);

        JLabel linkLabel = new JLabel("<html><a href=''>Read full documentation here</a></html>");
        linkLabel.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 18));
        linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.github.com/junaidsultanxyz/simple-swing"));
                } catch (Exception ex) { ex.printStackTrace(); }
            }
        });
        linkLabel.setAlignmentX(CENTER_ALIGNMENT);


        add(heading);
        add(body);
        add(linkLabel);
    }
}
