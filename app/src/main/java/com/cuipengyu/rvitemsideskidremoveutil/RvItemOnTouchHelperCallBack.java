package com.cuipengyu.rvitemsideskidremoveutil;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RvItemOnTouchHelperCallBack extends ItemTouchHelper.Callback {
    private RvItemHelperInterface mAnInterface;

    RvItemOnTouchHelperCallBack(RvItemHelperInterface mAnInterface) {
        this.mAnInterface = mAnInterface;
    }

    /**
     * Callback回调监听时先调用的，用来判断当前是什么动作，比如判断方向
     * 作用：哪个方向的拖动
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //我要监听的拖拽方向是哪个方向
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //我要监听的swipe侧滑方向是哪个方向
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return flags;
    }

    /**
     * @param recyclerView 当上下移动的时候回调的方法
     * @param viewHolder   被拖拽的条目所持有的viewHolder
     * @param target       目标条目所持有的viewHolder
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAnInterface.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 是否打开长按拖拽效果
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
//        if (actionState == ACTION_STATE_DRAG && viewHolder != null)
//            viewHolder.itemView.setAlpha(0.7f);
    }

    //防止复用出现问题
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
//        viewHolder.itemView.setAlpha(1f);
    }

    //侧滑行为
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //如果是侧滑行为
        if (actionState == ACTION_STATE_SWIPE) {
            int translax = mAnInterface.getMenuWidth(viewHolder); //获取菜单的宽度
            View contentView = mAnInterface.getContentView(viewHolder);//获取view的宽度
            if (contentView == null) return;
            if (dX < -translax) {//向左滑动dx是小于的 ，最大滑动距离当然不能超过菜单宽度了
                dX = -translax;
                contentView.setTranslationX(dX);
            } else {
                contentView.setTranslationX(dX);
            }
        } else {
            //不是侧滑，可能是长按拖拽也可能是上下滑动，点击啊 什么动作的执行原来的行为。
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }
}
