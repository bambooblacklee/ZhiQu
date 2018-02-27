package com.bamboolmc.modulenews.module.newsDetail.detFragment;

import java.util.List;

/**
 * Created by limc on 18/2/7.
 */
public class NewsHotModuleBean {
    ThreadTotalBean threadTotal;
    HotCommentListBean hotCommentList;

    public static class ThreadTotalBean{
        int againstcount;
        String audioLock;
        String code;
        String joinCountSwitch;
        String needCheck;
        int prcount;
        int ptcount;
        int threadAgainst;
        int threadVote;
        int votecount;
    }

    public static class HotCommentListBean{
        List<String> commentIds;
        CommentsBean comments;
        ThreadInfoBean threadInfo;

        public static class CommentsBean{
//            List<Map<"39289239",CommentBean>>

        }

        public static class ThreadInfoBean{
            String audioLock;
            String isTagOff;
            String url;
            String againstLock;
        }
    }

}
