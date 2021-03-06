package framgia.com.myeditor.data.source;

import framgia.com.myeditor.data.model.Collection;
import framgia.com.myeditor.data.model.Image;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by CuD HniM on 18/10/03.
 */
public interface ImageDataSource {

    /**
     * Local
     */

    interface ImageLocalDataSource {

    }

    /**
     * Remote
     */
    interface ImageRemoteDataSource {
        Single<List<Image>> getRandomImages();

        Single<List<Collection>> getCollections(int page);

        Single<List<Image>> getNewImages(int page, String apiKey);
    }
}
