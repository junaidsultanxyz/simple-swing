# Simple Swing

---
Simple Swing is a framework for Java Swing, to simplify the GUI implementation and improve the experience
for new Java programmers. It simplifies many 

___
## Features

### 1. Page Routing

Automatically create different screens using the folder structure, and switching screens is just 1 function call away.
```
    pages/
    │
    ├── home/
    │   └── Page.java
    │
    ├── about/
    │   └── Page.java
    │
    └── Page.java (home page)
```
Here, each folder name under `pages/` indicates a screen or scene (for example, /about),
think of it as a web page.

To switch to different screen, call `Router.goto("name")` and it switches to that screen.
Here, "name" indicates to page name (which is the folder name).
Every folder name must be unique, otherwise it will cause confusion to Router. The `pages/Page.java` represents the home page.
It will be executed as soon the application starts. 

This removes the pain of finding a way to switch screens along with the difficulty and time it takes to set everything up.

___
### 2. Easy component Management
Defining reusable components is easier and using them is even easier.

___
### 3. Simpler event handling
Removes all the boilerplate that used to be required to define just a simple event handler. 
___
### 4. Easier Layout Management
Hides all the complex layout function and lets you manage layout in easy and understandable way.

*and more qol functions*

___

## Feature Calender

| Release Date      | Functionality ID | Feature                        |
|-------------------|------------------|--------------------------------|
| 25 December, 2025 | **FR-01**        | Page Routing                   |
| N/A               | **FR-02**        | Event Handlers                 |
| N/A               | **FR-03**        | Navbars                        |
| N/A               | **FR-03-01**     | Side Panel                     |
| N/A               | **FR-04**        | Component System               |
| N/A               | **FR-05**        | Simpler Layouts                |
| N/A               | **FR-06**        | Better ready to use components |

___

## Contribution
Contributions are welcomed. If you would like to collaborate, feel free to reach out to me.