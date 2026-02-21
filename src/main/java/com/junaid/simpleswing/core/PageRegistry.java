package com.junaid.simpleswing.core;

import com.junaid.simpleswing.annotations.Page;
import com.junaid.simpleswing.exceptions.IncompatiblePageException;
import org.reflections.Reflections;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PageRegistry {
    protected static String homePage = null;

    protected static Map<String, JPanel> scanAndRegister(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Page.class);

        Map<String, JPanel> panels = new HashMap<>();

        for (Class<?> clazz : annotatedClasses) {

            // Enforce that the class extends JPanel
            if (!JPanel.class.isAssignableFrom(clazz)) {
                throw new IncompatiblePageException(
                        clazz.getName() + " is annotated with @Page but does not extend JPanel"
                );
            }

            Page page = clazz.getAnnotation(Page.class);
            String title = page.title();

            try {
                // Instantiate the user's panel using its no-arg constructor, then the custom render method
                SimplePage  instance = (SimplePage) clazz.getDeclaredConstructor().newInstance();
                instance.render();

                if (page.home()) {
                    if (homePage != null) {
                        throw new IllegalStateException(
                                "Multiple pages marked as home: \"" + homePage + "\" and \"" + page.title() + "\""
                        );
                    }
                    homePage = page.title();
                }

                panels.put(title, instance);
                System.out.println("Registered page: " + title + " → " + clazz.getName());
            }
            catch (NoSuchMethodException e) {
                throw new IllegalStateException(
                        clazz.getName() + " must have a public no-arg constructor"
                );
            }
            catch (Exception e) {
                throw new RuntimeException("Failed to instantiate " + clazz.getName(), e);
            }
        }

        if (homePage == null) {
            throw new IllegalStateException("No page marked as home");
        }

        return panels;
    }
}