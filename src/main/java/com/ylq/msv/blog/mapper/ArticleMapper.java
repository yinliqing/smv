package com.ylq.msv.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ylq.msv.blog.bean.Article;

@Mapper
public interface ArticleMapper {
	Article findArticleById(Integer id);
	int updateArticle(Article article);
}
