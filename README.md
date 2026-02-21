# Simple Swing

---
Simple Swing is a Java Swing framework that simplifies the GUI implementation and improve the experience
for new Java programmers.

___
## Features

### 1. Page Router

Create multiple pages and route between them without any hassle. Easy to maintain and extend.

```java
@Page("dashboard") // creates a page
public class DashboardPage extends SimplePage {
    @Override
    public void render() {
        // page content here
    }
}

Router.showPage("dashboard"); // switches to home page
```

For creating a default page, use the home attribute in annotation:
```java
@Page("dashboard", home = true)
public class DashboardPage extends SimplePage {
    ...
}
```

The default page will be shown when the application starts.
___
### 2. Simpler event handling
Removes all the boilerplate that used to be required to define just a simple event handler.
```java
@OnEvent()
JButton button = new JButton("Click Me");
```
___
### 3. Easier Layout Management
Hides all the complex layout function and lets you manage layout in easy and understandable way.

___
### 4. Other Features In Plan
More features are planned to be added in the future like:
- Auto Multithreading Handling
- Real time data binding
- Plug and play components
- and more...

___

## Feature Plan

| Release Date      | Feature                        |
|-------------------|--------------------------------|
| N/A               | Page Router                    |
| N/A               | Event Handlers                 |
| N/A               | Navbars                        |
| N/A               | Side Panel                     |
| N/A               | Component System               |
| N/A               | Simpler Layouts                |

___

## Contribution
Contributions are welcomed. If you would like to collaborate, feel free to reach out to me.
