# EditTextChangeView
EditText监听事件
监听输入框的改变，从而改变左边文字和下划线，不用每次都写一个ImageView，一个EditText，一个View的下划线，监听事件也统一封装在自定义View中，只需要获取输入框的值即可
![效果图](https://github.com/Veken/EditTextChangeView/raw/master/screenshot/GIF.gif) 

在布局中调用,可以直接设置默认左边的图片，输入后的图片，默认的下划线颜色，改变后的下划线颜色，当然还可以设置EditText的一些属性，比如inputType，长度等等。

```
  <com.veken.edittextchangeview.InputLayoutView
        android:id="@+id/rl_user"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginLeft="30dp"
        android:layout_marginRight="30dp"
        android:layout_marginTop="50dp"
        android:gravity="center_vertical"
        app:inputHint="请输入手机号"
        app:inputImageView="@mipmap/ic_phone_pre"
        app:maxLength="11"
        app:maxLine="1"
        app:inputType="3"
        app:orginalLineColor="#cccccc"
        app:inputLineColor="#399ae4"
        app:orginalImageView="@mipmap/ic_phone">

    </com.veken.edittextchangeview.InputLayoutView>
```
用接口回调获取输入的值
```
  rlUser.setOnEditTextChangeListener(new InputLayoutView.OnEditTextChangeListener() {
            @Override
            public void onEditTextChangeListener(String text) {
                tvUser.setText(text);
            }
        });
```
