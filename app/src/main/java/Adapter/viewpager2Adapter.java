package Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class viewpager2Adapter extends FragmentStateAdapter {
    private List<Fragment>mFragments;

    public viewpager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Fragment>fragments) {
        super(fragmentManager, lifecycle);
        mFragments = fragments;
        Log.d("TAG","适配器的构造函数");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d("TAG","这是第"+position+"个视图");
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        Log.d("TAG","返回"+mFragments.size());
        return mFragments.size();
    }
}
