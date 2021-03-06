package com.example.mayikang.wowallet.ui.xwidget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.example.mayikang.wowallet.R;
import com.example.mayikang.wowallet.adapter.PopupListAdapter;
import com.sctjsj.basemodule.base.util.DpUtils;

import java.util.List;


/**
 * Created by cjlmonster on 2016/1/31.
 */
public class PopupDialog extends Dialog implements AdapterView.OnItemClickListener, View.OnClickListener {


    private Context context;
    private PopupListAdapter adapter;
    private ListView listview;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PopupDialog(Context context, @NonNull List<String> mData) {
        super(context, R.style.popup_dialog_style);
        setContentView(R.layout.popup_dialog_layout);
        this.context = context;
        init();
        adapter = new PopupListAdapter(context, mData);
        listview = (ListView) findViewById(R.id.listview);
        listview.getLayoutParams().height = mData.size() > 3 ? DpUtils.dpToPx(context, 180) : LinearLayout.LayoutParams.WRAP_CONTENT;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    private void init() {
        getWindow().getAttributes().width = context.getResources().getDisplayMetrics().widthPixels;
        getWindow().getAttributes().gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        setCanceledOnTouchOutside(false);
    }

    public void setData(List<String> mData) {
        listview.getLayoutParams().height = mData.size() > 3 ? DpUtils.dpToPx(context, 180) : LinearLayout.LayoutParams.WRAP_CONTENT;
        adapter.setData(mData);
    }

    @Override
    public void onClick(View v) {
        PopupDialog.this.dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (listener != null) {
            listener.onItemClick(view, position);
            PopupDialog.this.dismiss();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, final int position);
    }
}
