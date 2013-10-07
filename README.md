Android Empty Layout
====================

A library for showing different types of layouts when a list view is empty. These layouts can be shown when,
* the list is loading
* the list has no item to display
* an error occured trying to load items

Loading animation is also supported.

Screenshots
-----------
![alt text](https://github.com/alamkanak/Android-Empty-Layout/raw/master/Screenshots/Screen01.png "List")
![alt text](https://github.com/alamkanak/Android-Empty-Layout/raw/master/Screenshots/Screen02.png "Loading state")
![alt text](https://github.com/alamkanak/Android-Empty-Layout/raw/master/Screenshots/Screen03.png "Empty state")
![alt text](https://github.com/alamkanak/Android-Empty-Layout/raw/master/Screenshots/Screen04.png "Error state")

Usage
-----
1. Import the [library project](https://github.com/alamkanak/Android-Empty-Layout/tree/master/EmptyLayout) into your workspace.
2. Use the imported [project as a library](http://developer.android.com/tools/projects/projects-eclipse.html#ReferencingLibraryProject) for your project.
3. In the `onCreate` event of your activity use the following code.

  ```java
  EmptyLayout emptyLayout = new EmptyLayout(this, getListView());
  ```
4. When you want to show the loading animation, use this code.

  ```java
  emptyLayout.showLoading();
  ```
5. When you want to show any error, use this code.

  ```java
  emptyLayout.showError();
  ```
6. When your list doesn't have any item to show, use this code.

  ```java
  emptyLayout.showEmpty();
  ```
Thats all you have to do to use this library. You customize its behavior though.

Customization
-------------
There are bunch of methods to let you customize this pattern. Use the methods like this.

```java
emptyLayout.setLoadingMessage("Please wait...");
```

Some useful methods are given below
* `showEmpty`
* `showLoading`
* `setLoadingView`
* `setEmptyView`
* `setErrorView`
* `setLoadingAnimation`
* `setErrorMessage`
* `setLoadingMessage`
* `setEmptyMessage`

and there is more...

Example
-------
A [simple example](https://github.com/alamkanak/Android-Empty-Layout/tree/master/EmptyLayoutSample) is also available.