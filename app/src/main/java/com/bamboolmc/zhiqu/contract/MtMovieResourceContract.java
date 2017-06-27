package com.bamboolmc.zhiqu.contract;

import com.bamboolmc.zhiqu.base.BaseContract;
import com.bamboolmc.zhiqu.model.bean.MtMovieDialoguesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieHighLightsBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieParentGuidancesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieRelatedCompaniesBean;
import com.bamboolmc.zhiqu.model.bean.MtMovieTechnicalsBean;

import java.util.List;

/**
 * Created by limc on 17/6/5.
 */
public interface MtMovieResourceContract {
    interface View extends BaseContract.BaseView {

        void showMtMovieHightLights(List<MtMovieHighLightsBean.DataBean> movieHighLightsBeanData);

        void showMtMovieDialogues(List<MtMovieDialoguesBean.DataBean> movieDialoguesBeanData);

        void showMtMovieParentGuidances(List<MtMovieParentGuidancesBean.DataBean.GovBean> govBeanList);

        void showMtMovieRelatedCompanies(List<MtMovieRelatedCompaniesBean.DataBean> movieRelatedCompaniesData);

        void showMtMovieTechnicals(MtMovieTechnicalsBean.DataBean technicalsBeanData);

        void showContent();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getMtMovieHightLights(int movieId);

        void getMtMovieDialogues(int movieId);

        void getMtMovieParentGuidances(int movieId);

        void getMtMovieRelatedCompanies(int movieId);

        void getMtMovieTechnicals(int movieId);

    }
}
