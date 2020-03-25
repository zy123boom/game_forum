package com.boomzy.validation;

import com.boomzy.domain.Post;
import org.apache.commons.lang3.StringUtils;

/**
 * 帖子有关验证
 *
 * @author boomzy
 * @date 2020/3/10 15:43
 */
public class PostValidation {
    /**
     * 发布帖子的校验
     *
     * @param post
     * @return
     */
    public static boolean publicPostValidate(Post post) {
        if (post == null) {
            return false;
        }
        if (StringUtils.isBlank(post.getOwnedSection()) || StringUtils.isBlank(post.getPostSubject()) ||
                StringUtils.isBlank(post.getPostContent())) {
            return false;
        }
        return true;
    }

    /**
     * 新增帖子评论的校验
     *
     * @param commentContent
     * @return
     */
    public static boolean addCommentValidate(String commentContent) {
        if (commentContent == null || commentContent.length() == 0) {
            return false;
        }
        if (StringUtils.isBlank(commentContent)) {
            return false;
        }
        return true;
    }

    /**
     * 新增回复评论的校验
     *
     * @param commentId
     * @return
     */
    public static boolean addReplyValidate(String commentId) {
        return addCommentValidate(commentId);
    }
}
