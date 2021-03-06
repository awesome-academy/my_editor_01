package framgia.com.myeditor.data.repository;

import framgia.com.myeditor.data.model.Collection;
import framgia.com.myeditor.data.model.Image;
import framgia.com.myeditor.data.source.local.ImageLocalDataSource;
import framgia.com.myeditor.data.source.remote.ImageRemoteDataSource;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by CuD HniM on 18/10/03.
 */
public class ImageRepository {

    private static ImageRepository sInstance;
    private ImageRemoteDataSource mRemoteDataSource;
    private ImageLocalDataSource mLocalDataSource;

    private ImageRepository(ImageRemoteDataSource remoteDataSource,
            ImageLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static synchronized ImageRepository getsInstance(
            ImageRemoteDataSource imageRemoteDataSource,
            ImageLocalDataSource imageLocalDataSource) {
        if (sInstance == null) {
            synchronized (ImageRemoteDataSource.class) {
                if (sInstance == null) {
                    sInstance = new ImageRepository(imageRemoteDataSource, imageLocalDataSource);
                }
            }
        }
        return sInstance;
    }

    public Single<List<Image>> getRandomImage() {
        return mRemoteDataSource.getRandomImages();
    }

    public Single<List<Collection>> getCollections(int page) {
        return mRemoteDataSource.getCollections(page);
    }

    public Single<List<Image>> getNewImages(int page, String apiKey) {
        return mRemoteDataSource.getNewImages(page, apiKey);
    }
}
