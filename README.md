# Simple Swing

---
Simple Swing is a Java Swing framework that simplifies the GUI implementation and improve the experience
for new Java programmers.

___
## Features Implemented

### 1. Easy Page Routing

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

There are 2 more methods to override, `OnInit()` and `OnExit()`, which are called when the page loads or unloads respectively
___
### 2. Easier Layout Management
Hides all the complex layout function and lets you manage layout in easy and understandable way.

___
### 3. Simpler Component System
Easy to use components without adding 
___

## Feature Plan

| Feature Planning                       | Status    |
|----------------------------------------|-----------|
| Easy Page Routing                      | COMPLETED |
| Simpler & Better Layout System         | PLANNING  |
| Basic Simple Components                | PLANNING  |
| Better Style System for Components     | N/A       |
| Database Handling & Quering            | N/A       |
| Multithreading and Dispatcher Handling | N/A       |
| Reactive Data Binding (Signals)        | N/A       |
| More Custom Components                 | N/A       |

___

## Contribution
Contributions are welcomed. If you would like to collaborate, feel free to reach out to me.
