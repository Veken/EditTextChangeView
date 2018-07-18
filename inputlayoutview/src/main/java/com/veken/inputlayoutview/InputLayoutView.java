package com.veken.inputlayoutview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * @author Veken
 * @date on 2018/1/15 14:28
 * @describe 自定义EditText输入监听事件
 */

public class InputLayoutView extends RelativeLayout {
    //输入框左边的图片
    private ImageView imageView;
    //原始图片资源
    private int orginalImageResource;
    //输入后的图片资源
    private int inputImageResource;
    //输入框
    private EditText editText;
    //输入框输入类型
    private int inputType;
    //输入框允许最大长度
    private int maxLength;
    //输入框最大行数
    private int maxLine;
    //输入框提示内容
    private String inputHint;
    //下划线
    private View view;
    //原始的下划线颜色
    private int orginalLineColor;
    //输入后的下划线颜色
    private int inputLineColor;
    //EditTextHintColor
    private int hintColor;
    //EditTextColor
    private int textColor;


    public InputLayoutView(Context context) {
        this(context, null);
    }

    public InputLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @SuppressLint("ResourceType")
    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputLayoutView);
        //初始化控件
        imageView = new ImageView(context);
        editText = new EditText(context);
        view = new View(context);
        //图片
        LayoutParams params1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //添加相应的规则
        params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params1.addRule(RelativeLayout.CENTER_VERTICAL);
        //设置控件的位置
        params1.setMargins(0, 0, 0, 0);//左上右下
        imageView.setLayoutParams(params1);
        imageView.setId(1);
        //添加View
        this.addView(imageView, params1);

        //输入框
        LayoutParams params2 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //添加相应的规则
        params2.addRule(RelativeLayout.RIGHT_OF, 1);
        //设置控件的位置
        params2.setMargins(10, 0, 0, 0);//左上右下
        params2.addRule(RelativeLayout.CENTER_VERTICAL);
        editText.setLayoutParams(params2);
        editText.setId(2);
        this.addView(editText, params2);

        //下划线 默认高度为1px，可自行修改
        LayoutParams params3 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        //添加相应的规则
        params3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 2);
        //设置控件的位置
        params3.setMargins(0, 5, 0, 0);//左上右下
        view.setLayoutParams(params3);
        this.addView(view, params3);

        orginalImageResource = typedArray.getResourceId(R.styleable.InputLayoutView_orginalImageView, 0);
        inputImageResource = typedArray.getResourceId(R.styleable.InputLayoutView_inputImageView, 0);
        orginalLineColor = typedArray.getColor(R.styleable.InputLayoutView_orginalLineColor, Color.parseColor("#cccccc"));
        inputLineColor = typedArray.getColor(R.styleable.InputLayoutView_inputLineColor, Color.parseColor("#399ae4"));
        hintColor = typedArray.getColor(R.styleable.InputLayoutView_hintColor,Color.parseColor("#cccccc"));
        textColor = typedArray.getColor(R.styleable.InputLayoutView_textColor,Color.parseColor("#000000"));
        inputType = typedArray.getInt(R.styleable.InputLayoutView_inputType,0);
        maxLength = typedArray.getInt(R.styleable.InputLayoutView_maxLength, 32);
        maxLine = typedArray.getInt(R.styleable.InputLayoutView_maxLine, 1);
        inputHint = typedArray.getString(R.styleable.InputLayoutView_inputHint);
        //输入框inputType 如果有其他类型需要可以再往后叠加
            switch (inputType) {
                case 1:
                    editText.setInputType(InputType.TYPE_CLASS_PHONE);  //拨号键盘
                    break;
                case 2:
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);  //密码
                    break;
                case 3:
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);  //数字
                    break;
                default:
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);  //默认
                    break;
            }
        //输入框最大行数
        editText.setMaxLines(maxLine);
        //输入框允许输入的最大长度
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        //输入框提示内容
        editText.setHint(inputHint);
        //输入框提示内容颜色
        editText.setHintTextColor(hintColor);
        //输入框输入内容后颜色
        editText.setTextColor(textColor);
        //设置输入框无背景
        editText.setBackground(null);
        //默认图片
        imageView.setImageResource(orginalImageResource);
        //默认下划线
        view.setBackgroundColor(orginalLineColor);
        //editText输入监听事件
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    imageView.setImageResource(inputImageResource);
                    view.setBackgroundColor(inputLineColor);
                } else {
                    imageView.setImageResource(orginalImageResource);
                    view.setBackgroundColor(orginalLineColor);
                }
                onEditTextChangeListener.onEditTextChangeListener(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        typedArray.recycle();
    }

    public void setOnEditTextChangeListener(OnEditTextChangeListener onEditTextChangeListener) {
        this.onEditTextChangeListener = onEditTextChangeListener;
    }

    private OnEditTextChangeListener onEditTextChangeListener;

    public interface OnEditTextChangeListener{
        void onEditTextChangeListener(String text);
    }
}
