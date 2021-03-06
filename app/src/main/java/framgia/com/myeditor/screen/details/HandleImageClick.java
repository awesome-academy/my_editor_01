package framgia.com.myeditor.screen.details;

import android.content.Context;
import framgia.com.myeditor.data.model.ImageRandom;

import static framgia.com.myeditor.screen.home.adapter.RandomPagerAdapter.NUMBER_ONE;
import static framgia.com.myeditor.screen.home.adapter.RandomPagerAdapter.NUMBER_ZERO;

/**
 * Created by CuD HniM on 18/10/06.
 */
public class HandleImageClick {

    private Context mContext;
    private ImageDetailsViewModel mViewModel;

    HandleImageClick(Context context, ImageDetailsViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
    }

    public void OnLikeClickListener(ImageRandom imageRandom) {
        if (imageRandom.getLikeByUser() == NUMBER_ONE) {
            updateButton(imageRandom, NUMBER_ZERO);
        } else {
            updateButton(imageRandom, NUMBER_ONE);
        }
    }

    private void updateButton(ImageRandom imageRandom, int number) {
        imageRandom.setLikeByUser(number);
        mViewModel.updateImageLike(imageRandom);
    }

    public void OnDownloadClickListener(ImageRandom imageRandom) {
        mViewModel.download(imageRandom);
    }

    public void OnEditClickListener(ImageRandom imageRandom) {
        mContext.startActivity(EditActivity.getProfileIntent(mContext, imageRandom));
    }
}
