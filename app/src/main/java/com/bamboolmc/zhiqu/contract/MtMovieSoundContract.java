package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieAlbumBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieMusicBean;

/**
 * Created by limc on 17/6/6.
 */
public interface MtMovieSoundContract {

    interface View extends BaseContract.BaseView {
        void showMovieAlbum(MtMovieAlbumBean.DataBean movieAlbum);

        void showMovieMusic(MtMovieMusicBean.DataBean movieMusic);

        void showContent();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getMovieSound(int movieId);
    }
}
