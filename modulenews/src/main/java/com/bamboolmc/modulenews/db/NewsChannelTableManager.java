package com.bamboolmc.modulenews.db;

import com.bamboolmc.modulenews.R;
import com.bamboolmc.modulenews.app.NewsAppConstant;
import com.bamboolmc.modulenews.app.NewsApplication;
import com.bamboolmc.modulenews.module.news.ListSpecialBean;
import com.bamboolmc.modulenews.module.news.NewsChannelBean;
import com.bamboolmc.modulenews.module.news.NewsTopicBean;
import com.bamboolmc.modulenews.utils.FileCacheUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by limc on 18/1/9.
 */
public class NewsChannelTableManager {

    /**
     * 转换所有的新闻类型
     */
    public static List<ListSpecialBean.TopicBean> exchangeAllTabList(ListSpecialBean mListSpecialBean) {
        List<String> allChannel = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.news_channel_all));
        ArrayList<ListSpecialBean.TopicBean> allTabList = new ArrayList<>();

        for (int i = 0; i <allChannel.size() ; i++) {
            String channelName = allChannel.get(i);
            for (int j = 0; j < mListSpecialBean.gettList().size(); j++) {
                if (channelName.equals(mListSpecialBean.gettList().get(j).getTname())){
                    allTabList.add(mListSpecialBean.gettList().get(j));
                }
            }
        }
        return allTabList;
    }

    /**
     * 首次加载并获取我的channel
     * "头条"
     */
    public static List<NewsChannelBean> loadNewsChannelMine(NewsTopicBean mNewsTopicBean) {
        //根据存储的allChannel,来补充网络下载的myChannel内缺失的TName,TId等
        ArrayList<ListSpecialBean.TopicBean> allTabList = (ArrayList<ListSpecialBean.TopicBean>) FileCacheUtil
                .get(NewsApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_ALL);
        List<String> eNameList = mNewsTopicBean.getData().getTopics();

        List<String> channelEName = new ArrayList<>();
        List<String> channelTName = new ArrayList<>();
        List<String> channelTId = new ArrayList<>();
        for (int i = 0; i < eNameList.size(); i++) {
            String EName = eNameList.get(i);
            for (int j = 0; j < allTabList.size(); j++) {
                if (EName.equals(allTabList.get(j).getEname())) {
                    channelEName.add(allTabList.get(j).getEname());//清除无效的ename
                    channelTName.add(allTabList.get(j).getTname());
                    channelTId.add(allTabList.get(j).getTid());
                }
            }
        }
        //将所有字段组合为NewsChannelBean_List,以便后面存储到File中
        List<String> urlTouTiao = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_toutiao));
        List<String> urlDlist = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_dlist));
        List<String> urlNc = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_nc));

        List<NewsChannelBean> newsChannelBeanMine = new ArrayList<>();
        for (int i = 0; i < channelEName.size(); i++) {
            if (urlTouTiao.contains(channelTName.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTName.get(i), channelEName.get(i), channelTId.get(i), NewsAppConstant.TYPE_URL_TOUTIAO, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanMine.add(entity);
            } else if (urlDlist.contains(channelTName.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTName.get(i), channelEName.get(i), channelTId.get(i), NewsAppConstant.TYPE_URL_DLIST, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanMine.add(entity);
            } else if (urlNc.contains(channelTName.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTName.get(i), channelEName.get(i), channelTId.get(i), NewsAppConstant.TYPE_URL_NC, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanMine.add(entity);
            }
        }
        return newsChannelBeanMine;
    }


    /**
     * 首次加载并获取其他channel
     * "头条"
     */
    public static List<NewsChannelBean> loadNewsChannelOthers(NewsTopicBean mNewsTopicBean) {
        //根据存储的allChannel,来补充网络下载的myChannel内缺失的TName,TId等
        ArrayList<ListSpecialBean.TopicBean> allTabList = (ArrayList<ListSpecialBean.TopicBean>) FileCacheUtil
                .get(NewsApplication.getAppContext()).getAsObject(NewsAppConstant.CHANNEL_ALL);
        List<String> eNameList = mNewsTopicBean.getData().getTopics();

        List<String> channelENameOthers = new ArrayList<>();
        List<String> channelTNameOthers = new ArrayList<>();
        List<String> channelTIdOthers = new ArrayList<>();
        for (int i = 0; i < allTabList.size(); i++) {
            String ENameOthers = allTabList.get(i).getEname();
            String TNameOthers = allTabList.get(i).getTname();
            String TIdOthers = allTabList.get(i).getTid();
            if (!eNameList.contains(ENameOthers)) {
                channelENameOthers.add(ENameOthers);
                channelTNameOthers.add(TNameOthers);
                channelTIdOthers.add(TIdOthers);
            }
        }
        //将所有字段组合为NewsChannelBean_List,以便后面存储到File中

        List<String> urlTouTiao = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_toutiao));
        List<String> urlDlist = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_dlist));
        List<String> urlNc = Arrays.asList(NewsApplication.getAppContext().getResources().getStringArray(R.array.url_type_nc));

        List<NewsChannelBean> newsChannelBeanOthers = new ArrayList<>();
        for (int i = 0; i < channelENameOthers.size(); i++) {
            if (urlTouTiao.contains(channelTNameOthers.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTNameOthers.get(i), channelTNameOthers.get(i), channelTNameOthers.get(i), NewsAppConstant.TYPE_URL_TOUTIAO, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanOthers.add(entity);
            } else if (urlDlist.contains(channelTNameOthers.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTNameOthers.get(i), channelTNameOthers.get(i), channelTNameOthers.get(i), NewsAppConstant.TYPE_URL_DLIST, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanOthers.add(entity);
            } else if (urlNc.contains(channelTNameOthers.get(i))) {
                NewsChannelBean entity = new NewsChannelBean(channelTNameOthers.get(i), channelTNameOthers.get(i), channelTNameOthers.get(i), NewsAppConstant.TYPE_URL_NC, NewsAppConstant.TYPE_BEAN_CHANNEL,true, 0, false);
                newsChannelBeanOthers.add(entity);
            }
        }
        return newsChannelBeanOthers;
    }

}
