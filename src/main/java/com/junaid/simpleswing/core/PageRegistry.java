package com.junaid.simpleswing.core;

import com.junaid.simpleswing.annotations.Page;
import com.junaid.simpleswing.components.SimplePage;
import com.junaid.simpleswing.exceptions.DuplicatePageException;
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

            if (!SimplePage.class.isAssignableFrom(clazz)) {
                throw new IncompatiblePageException(
                        clazz.getName() + " is annotated with @Page but does not extend SimplePage. Every page must extend SimplePage"
                );
            }

            Page page = clazz.getAnnotation(Page.class);
            String title = page.title();

            try {
                SimplePage instance = (SimplePage) clazz.getDeclaredConstructor().newInstance();
                instance.render();

                if (page.home()) {
                    if (homePage != null) {
                        throw new IllegalStateException(
                                "Multiple pages marked as home: \"" + homePage + "\" and \"" + page.title() + "\""
                        );
                    }
                    homePage = page.title();
                }

                if (!panels.containsKey(title)){
                    panels.put(title, instance);
                }
                else {
                    throw new DuplicatePageException(title + " page title already exist. Every page must have unique title");
                }

            }
            catch (NoSuchMethodException e) {
                throw new IllegalStateException(
                        clazz.getName() + " must have a public no-arg constructor, otherwise Router can't use that page"
                );
            }
            catch (Exception e) {
                throw new RuntimeException("Failed to instantiate " + clazz.getName(), e);
            }
        }

        if (homePage == null) {
            throw new IllegalStateException("No page marked as home. It can be done by @Page(.., home = true)");
        }

        return panels;
    }
}