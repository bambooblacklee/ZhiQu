package com.bamboolmc.modulenews.module.picture.detail;

import android.widget.TextView;

import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.base.BaseFragment;
import com.hwangjr.rxbus.RxBus;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by limc on 18/1/25.
 * https://github.com/chrisbanes/PhotoView  暂时缺少个数
 */
public class PicDetailFragment extends BaseFragment {

    @BindView(R.id.img_pic_det)
    PhotoView mPhotoView;
    @BindView(R.id.serial_img)
    TextView mTextView;

    public static final String POST_BEAN = "post_bean";
    private String picUrl;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_pic_detail;
    }

    @Override
    public void initView() {
        PicPostBean mPicPostBean = (PicPostBean) getArguments().getSerializable(POST_BEAN);
        picUrl = mPicPostBean.getImgUrl();

        Picasso.with(getActivity())
                .load(picUrl)
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher)
                .into(mPhotoView);
        RxBus.get().post(mPicPostBean);
    }

    @Override
    public void attachView() {

    }

    @Override
    public void setComponentInject() {

    }

    @Override
    protected void loadData() {

    }
}
