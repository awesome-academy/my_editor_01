package framgia.com.myeditor.screen.home;

import android.databinding.DataBindingUtil;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import framgia.com.myeditor.databinding.ItemRandomImageBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuD HniM on 18/10/03.
 */
public class RandomPagerAdapter extends PagerAdapter {

    private List<Image> mRandomList;

    RandomPagerAdapter() {
        mRandomList = new ArrayList<>();
    }

    void setRandomList(List<Image> list) {
        if (list.size() > 0) {
            mRandomList.clear();
            mRandomList.addAll(list);
        }
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ItemRandomImageBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),
                        R.layout.item_random_image, container, false);
        View view = binding.getRoot();
        binding.setItem(
                new ItemViewPager.Builder().mPath(mRandomList.get(position).getUrls().getFull())
                        .build());
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public int getCount() {
        return mRandomList == null ? 0 : mRandomList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}