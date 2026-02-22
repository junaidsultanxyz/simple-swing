package com.junaid.simpleswing.core;

import com.junaid.simpleswing.components.SimplePage;
import com.junaid.simpleswing.exceptions.PageNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel parent = new JPanel(cardLayout);
    private static final HashMap<String, JPanel> pages = new HashMap<>();
    private static String homePage;
    private static String currentPage;

    public static void showPage (String page){
        if (!pages.containsKey(page)){
            throw new PageNotFoundException("Page " + page + " not found");
        }

        if (currentPage != null){
            ((SimplePage) pages.get(currentPage)).OnExit();
        }

        currentPage = page;
        ((SimplePage) pages.get(currentPage)).OnInit();
        ((CardLayout) parent.getLayout() ).show(parent, page);
    }

    protected static void populatePages (String basePackage){
        pages.putAll(PageRegistry.scanAndRegister(basePackage));
        homePage = PageRegistry.homePage;

        for (Map.Entry<String, JPanel> entry : pages.entrySet()) {
            parent.add(entry.getValue(), entry.getKey());
        }
    }

    protected static String getHomePage() {
        return homePage;
    }

    protected static JPanel getParentPanel() {
        return parent;
    }
}
