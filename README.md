Android Empty Layout
====================

**Please note that this project is not being maintained now. Hopefully a new version will be available soon.**

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
  mListAdapter.clear();
  EmptyLayout emptyLayout = new EmptyLayout(this, getListView());
  ```
4. When you want to show the loading animation, use this code.

  ```java
  mListAdapter.clear();
  emptyLayout.showLoading();
  ```
5. When you want to show any error, use this code.

  ```java
  mListAdapter.clear();
  emptyLayout.showError();
  ```
6. When your list doesn't have any item to show, use this code.

  ```java
  mListAdapter.clear();
  emptyLayout.showEmpty();
  ```
Thats all you have to do to use this library. You may want to customize its behavior though.

P.S. Make sure you always clear the list adapter before calling `showEmpty`, `showLoading` and `showError`. The list have to empty after all.

Customization
-------------
There are bunch of methods to let you customize this pattern. Use the methods like this.

```java
emptyLayout.setLoadingMessage("Please wait...");
```

Some useful methods are given below
* `showEmpty`
* `showLoading`
* `showError`
* `setLoadingView`
* `setEmptyView`
* `setErrorView`
* `setLoadingAnimation`
* `setErrorMessage`
* `setLoadingMessage`
* `setEmptyMessage`
* `setEmptyViewButtonClickListener`
* `setLoadingViewButtonClickListener`
* `setErrorViewButtonClickListener`
* `setShowEmptyButton`
* `setShowLoadingButton`
* `setShowErrorButton`

and there is more...

Example
-------
A [simple example](https://github.com/alamkanak/Android-Empty-Layout/tree/master/EmptyLayoutSample) is also available.

License
----------

    Copyright 2014 Raquib-ul-Alam

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
