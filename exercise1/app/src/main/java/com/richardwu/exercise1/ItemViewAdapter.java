package com.richardwu.exercise1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<String> mItems;

    public ItemViewAdapter(List<String> items) {
        mItems = new ArrayList<>();
//        mItems = items; //赋值可以理解为指针赋值，是内存空间的直接复用，这样的话就会导致清空mItems的时候将主窗口的items也清空了
        mItems.addAll(items);
    }
    //创建ViewHolder实例,并把加载的布局传入到构造函数去,再把ViewHolder实例返回。
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        ItemViewHolder holder = new ItemViewHolder(view);//用从layout获取view初始化一个holder
        return holder;
    }
    //用于对子项的数据进行赋值,会在每个子项被滚动到屏幕内时执行。position得到当前项的Fruit实例。
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String item = mItems.get(position);
        holder.itemText.setText(item);
    }
    //返回RecyclerView的子项数目, 也就是position的最大值
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    //自定义方法：按照传入的筛选准则更改mItems并通知
    public void dataChangedHandler(List<String> newItems) {
        mItems.clear();
//        mItems = newItems;
        mItems.addAll(newItems);
        notifyDataSetChanged();
    }
}
