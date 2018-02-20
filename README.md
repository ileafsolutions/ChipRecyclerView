[![](https://jitpack.io/v/ileafsolutions/ChipRecyclerView.svg)](https://jitpack.io/#ileafsolutions/ChipRecyclerView/)


# ChipRecyclerView
ChipRecyclerView library helps in showing chip views that can be laid out in horizontal direction, and can “flex” their sizes, either growing to fill unused space or shrinking to avoid overflowing the parent.

<img src="http://preview.ibb.co/jnzYdH/chip_recyclerview.png" width="300">


## Download library with Jitpack.io
**Step 1:** Add this in your root build.gradle at the end of repositories.
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2:** Add this to your dependencies in app level build.gradle file.
```java
	dependencies {
	        compile 'com.github.ileafsolutions:ChipRecyclerView:1.0'
	}
```


## Usage
Use ChipRecyclerView instead of normal RecyclerView in your layout. 
```xml
<com.ileaf.chiprecyclerviewlibrary.ChipRecyclerView
        android:id="@+id/rv_interest_multi"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
        app:multiSelection="true"/>
```

Check out the [adapter class](https://github.com/ileafsolutions/ChipRecyclerView/blob/master/app/src/main/java/com/ileaf/chip/InterestAdapter.java) in the sample app to see how the multiple selections are handled.

