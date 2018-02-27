package com.bamboolmc.modulenews.module.picture.recList;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.base.LazyFragment;
import com.bamboolmc.modulenews.dagger.DaggerNewsComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 18/1/25.
 */
public class PicRecListFragment extends LazyFragment<PicRecListPresenter> implements PicRecListContract.View {

    @BindView(R.id.multi_pic_rec)
    MultiStateView mMultiStateView;
    @BindView(R.id.rv_pic_rec)
    RecyclerView mRecyclerView;

    private PicRecListAdapter mPicRecListAdapter;
    public static final String PIC_ID = "pic_id";
    private String picId;

    @Inject
    PicRecListPresenter mPresenter;

//    public static PicRecListFragment newInstance(String picId) {
//        PicRecListFragment fragment = new PicRecListFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(PIC_ID, picId);
//        fragment.setArguments(bundle);
//        return fragment;
//    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_pic_rec;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void setComponentInject() {
        DaggerNewsComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView() {
        picId = getArguments().getString(PIC_ID);
        mPicRecListAdapter = new PicRecListAdapter();
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(mPicRecListAdapter);
    }

    @Override
    protected void loadData() {
        mPresenter.getPicRecList(picId);
    }

    @Override
    public void showPicRecList(List<PicRecBean> picRecBeanList) {
        mPicRecListAdapter.setNewData(picRecBeanList);
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        }
    }

    @Override
    public void showError() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getPicRecList(picId);
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }
    }
}
