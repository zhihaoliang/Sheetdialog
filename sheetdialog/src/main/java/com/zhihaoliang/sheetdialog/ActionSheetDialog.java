package com.zhihaoliang.sheetdialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2019/1/29
 * 描述:类似于ios的SheetDialog
 * 作者:支豪亮
 */

public class ActionSheetDialog {
    private Context mContext;
    private Dialog mDialog;
    //dialog的Title
    private TextView mTxtVtitle;
    //dialog的取消按钮
    private TextView mTxtVCancel;
    //表示装按钮的的LinearLayout
    private LinearLayout mLinContent;
    //用于控制高度，如果按钮太多用来滑动
    private ScrollView mScrContent;
    //是否展示
    private boolean mShowTitle = false;
    //存放按钮的的数组
    private List<SheetItem> mSheetItemList;
    //用于展示的设置
    private Display mDisplay;

    public ActionSheetDialog(Context context) {
        this.mContext = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        mDisplay = windowManager.getDefaultDisplay();
    }

    public ActionSheetDialog builder() {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.sheetdialog_layout, null);

        view.setMinimumWidth(mDisplay.getWidth());

        mScrContent =  view.findViewById(R.id.sheetdialog_scr_content);
        mLinContent = view.findViewById(R.id.sheetdialog_lin_content);
        mTxtVtitle =  view.findViewById(R.id.sheetdialog_txtV_title);
        mTxtVCancel =  view.findViewById(R.id.sheetdialog_txtV_cancel);
        mTxtVCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        mDialog = new Dialog(mContext, R.style.SheetDialogStyle);
        mDialog.setContentView(view);
        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);

        return this;
    }

    public ActionSheetDialog setTitle(String title) {
        mShowTitle = true;
        mTxtVtitle.setVisibility(View.VISIBLE);
        mTxtVtitle.setText(title);
        return this;
    }

    public ActionSheetDialog setCancelable(boolean cancel) {
        mDialog.setCancelable(cancel);
        return this;
    }

    public ActionSheetDialog setCanceledOnTouchOutside(boolean cancel) {
        mDialog.setCanceledOnTouchOutside(cancel);
        return this;
    }


    public ActionSheetDialog addSheetItem(String strItem, SheetItemColor color,
                                          OnSheetItemClickListener listener) {
        if (mSheetItemList == null) {
            mSheetItemList = new ArrayList<SheetItem>();
        }
        mSheetItemList.add(new SheetItem(strItem, color, listener));
        return this;
    }

    private void setSheetItems() {
        if (mSheetItemList == null || mSheetItemList.size() <= 0) {
            return;
        }

        int size = mSheetItemList.size();

        if (size >= 7) {
            LayoutParams params = (LayoutParams) mScrContent
                    .getLayoutParams();
            params.height = mDisplay.getHeight() / 2;
            mScrContent.setLayoutParams(params);
        }

        for (int i = 1; i <= size; i++) {
            final int index = i;
            SheetItem sheetItem = mSheetItemList.get(i - 1);
            String strItem = sheetItem.name;
            SheetItemColor color = sheetItem.color;
            final OnSheetItemClickListener listener =  sheetItem.itemClickListener;

            TextView textView = new TextView(mContext);
            textView.setText(strItem);
            textView.setTextSize(18);
            textView.setGravity(Gravity.CENTER);

            if (size == 1) {
                if (mShowTitle) {
                    textView.setBackgroundResource(R.drawable.sheetdialog_bottom_selector);
                } else {
                    textView.setBackgroundResource(R.drawable.sheetdialog_single_selector);
                }
            } else {
                if (mShowTitle) {
                    if (i >= 1 && i < size) {
                        textView.setBackgroundResource(R.drawable.sheetdialog_middle_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.sheetdialog_bottom_selector);
                    }
                } else {
                    if (i == 1) {
                        textView.setBackgroundResource(R.drawable.sheetdialog_top_selector);
                    } else if (i < size) {
                        textView.setBackgroundResource(R.drawable.sheetdialog_middle_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.sheetdialog_bottom_selector);
                    }
                }
            }

            if (color == null) {
                textView.setTextColor(Color.parseColor(SheetItemColor.Blue
                        .getName()));
            } else {
                textView.setTextColor(Color.parseColor(color.getName()));
            }

            float scale = mContext.getResources().getDisplayMetrics().density;
            int height = (int) (45 * scale + 0.5f);
            textView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setMinHeight(height);

            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(index);
                    mDialog.dismiss();
                }
            });

            mLinContent.addView(textView);
        }
    }

    public void show() {
        setSheetItems();
        mDialog.show();
    }

    public interface OnSheetItemClickListener {
        void onClick(int which);
    }

    private class SheetItem {
        String name;
        OnSheetItemClickListener itemClickListener;
        SheetItemColor color;

        public SheetItem(String name, SheetItemColor color,
                         OnSheetItemClickListener itemClickListener) {
            this.name = name;
            this.color = color;
            this.itemClickListener = itemClickListener;
        }
    }

    public enum SheetItemColor {
        Blue("#037BFF"), Red("#FD4A2E");

        private String name;

        private SheetItemColor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}