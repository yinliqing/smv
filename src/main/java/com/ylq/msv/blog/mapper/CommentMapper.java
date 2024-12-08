package com.ylq.msv.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ylq.msv.blog.bean.Comment;

@Mapper // 交给Spring容器管理
public interface CommentMapper {
	@Insert("insert into t_comment values(#{id}, #{content}, #{author}, #{aId})")
    int insert(Comment comment); // 插入评论记录

    @Delete("delete from t_comment where id = #{id}")
    int deleteById(Integer id); // 按标识符删除评论

    @Update("update t_comment set content = #{content}, author = #{author} where id = #{id}")
    int update(Comment comment); // 更新评论

    @Select("select * from t_comment where id = #{id}")
    Comment findById(Integer id); // 按标识符查询评论

    @Select("select * from t_comment")
    List<Comment> findAll(); // 查询全部评论
}
