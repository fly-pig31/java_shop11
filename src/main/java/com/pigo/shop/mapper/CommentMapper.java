package com.pigo.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pigo.shop.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getList();

    List<Comment> selectThingCommentList(String thingId, String order);

    List<Comment> selectUserCommentList(String userId);
}
