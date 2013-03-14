AndroidClipDrawableExample
==========================

Example of pretty simple implementation of progress bars in Android based on ClipDrawable

```xml
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <bitmap android:src="@drawable/pb_empty"/>
    </item>
    <item>
        <clip
                android:clipOrientation="vertical"
                android:gravity="bottom"
                android:drawable="@drawable/pb_full"/>
    </item>
</layer-list>
```

![Screenshot][1]

 [1]: https://raw.github.com/mgrzechocinski/AndroidClipDrawableExample/master/pb_screenshot.png
