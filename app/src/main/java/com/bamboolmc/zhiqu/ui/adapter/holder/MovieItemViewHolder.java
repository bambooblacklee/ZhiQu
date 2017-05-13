package com.bamboolmc.zhiqu.ui.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.base.BaseViewHolder;
import com.bamboolmc.zhiqu.model.bean.Movie;
import com.bamboolmc.zhiqu.util.StringFetcher;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by limc on 17/3/14.
 */
public class MovieItemViewHolder extends BaseViewHolder<Movie> {

    @BindView(R.id.movie_list_item)
    View mListItem;

    @BindView(R.id.img_photo)
    ImageView mPhotoImg;

    @BindView(R.id.movie_txt_name)
    TextView mMovieName;

    @BindView(R.id.movie_txt_year)
    TextView mMovieYear;

    @BindView(R.id.movie_txt_original)
    TextView mMovieOriginal;

    public MovieItemViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Movie movie) {

//        mPhotoImg.loadMoviePhoto(movie);
        Picasso.with(itemView.getContext())
                .load(movie.getImage().getSmall())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resizeDimen(R.dimen.movieitem_image_width,R.dimen.movieitem_image_height)
                .centerCrop()
                .into(mPhotoImg);
        mMovieName.setText(movie.getTitle());
        mMovieYear.setText(StringFetcher.getString(R.string.label_movie_year,
                movie.getYear()));
        mMovieOriginal.setText(StringFetcher.getString(R.string.label_movie_original,
                movie.getOriginalTitle()));


    }

}
