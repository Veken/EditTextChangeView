# EditTextChangeView
EditText监听事件
监听输入框的改变，从而改变左边文字和下划线，不用每次都写一个ImageView，一个EditText，一个View的下划线，监听事件也统一封装在自定义View中，只需要获取输入框的值即可

![效果图](https://github.com/Veken/EditTextChangeView/raw/master/screenshot/GIF.gif)</br> 

## 使用方式

#### 1.在 build.gradle 中添加依赖
```
    compile 'com.veken:edittextchangeview:1.0.1'

```
#### 2.在XML布局文件中添加
```
 <com.veken.inputlayoutview.InputLayoutView
        android:id="@+id/rl_user"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginLeft="30dp"
        android:layout_marginRight="30dp"
        android:layout_marginTop="50dp"
        android:gravity="center_vertical"
        app:inputHint="请输入手机号"
        app:inputImageView="@mipmap/ic_phone_pre"
        app:hintColor="#cccccc"
        app:maxLength="11"
        app:maxLine="1"
        app:inputType="3"
        app:orginalLineColor="#cccccc"
        app:inputLineColor="#399ae4"
        app:orginalImageView="@mipmap/ic_phone">

    </com.veken.inputlayoutview.InputLayoutView>
```
#### 3.在 Activity 或者 Fragment 中添加代码
```
  rlUser.setOnEditTextChangeListener(new InputLayoutView.OnEditTextChangeListener() {
            @Override
            public void onEditTextChangeListener(String text) {
                tvUser.setText(text);
            }
        });
```
#### Blog
[EditText监听事件](https://www.jianshu.com/p/e502cd24bfa1)
