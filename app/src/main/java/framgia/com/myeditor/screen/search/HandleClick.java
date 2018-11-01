package framgia.com.myeditor.screen.search;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import framgia.com.myeditor.data.model.Collection;

public class HandleClick {

    private Activity mActivity;
    private FragmentManager mManager;

    public HandleClick(FragmentManager manager) {
        mManager = manager;
    }

    public HandleClick(Activity activity) {
        mActivity = activity;
    }

    public void backToHome() {
        mActivity.onBackPressed();
    }

    public void clickItemTrend(String trend) {
        SearchFragment.newInstance().clickItem(trend);
    }

    public void clickItemRecent(RecentSearch recentSearch) {
        SearchFragment.newInstance().clickItem(recentSearch.getRecentSearch());
    }

    public void deleteRecentSearch(RecentSearch recentSearch) {
        SearchFragment.newInstance().deleteRecentSearch(recentSearch);
    }

    public void clickItemCollectionSearch(Collection collection) {
        CollectionFragment collectionFragment =
                CollectionFragment.newInstance(collection.getId(), collection.getTitle());
        FragmentTransactionUtils.addFragment(mManager, collectionFragment, R.id.frame_main,
                CollectionFragment.TAG, true);
    }
}
