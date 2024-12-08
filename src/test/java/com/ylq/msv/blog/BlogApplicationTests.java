package com.ylq.msv.blog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ylq.msv.blog.bean.Article;
import com.ylq.msv.blog.bean.Comment;
import com.ylq.msv.blog.mapper.ArticleMapper;
import com.ylq.msv.blog.mapper.CommentMapper;

@SpringBootTest
@AutoConfigureMockMvc
@MapperScan("com.ylq.msv.blog.mapper")
class BlogApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired // 注入评论映射器bean
	private CommentMapper commentMapper;
	@Autowired  // 注入文章映射器bean
	private ArticleMapper articleMapper;
	
	@Test // 测试按标识符查询评论
	public void testFindById() {
	    // 定义标识符变量
	    Integer id = 1;
	    // 调用评论映射器实体的按标识符查询评论方法
	    Comment comment = commentMapper.findById(id);
	    // 判断查询是否成功
	    if (comment != null) { // 成功
	        System.out.println(comment);
	    } else { // 失败
	        System.out.println("标识符为[" + id + "]的评论未找到~");
	    }
	}
	
	@Test // 测试查询全部评论                                                       
	public void testFindAll() {
	    // 调用评论映射器实体的查询全部评论方法
	    List<Comment> comments = commentMapper.findAll();
	    // 判断是否有评论
	    if (!comments.isEmpty()) { // 有评论
	        comments.forEach(comment -> System.out.println(comment));
	    } else { // 没有评论
	        System.out.println("温馨提示：评论表里没有记录~");
	    }
	}

	
	@Test // 测试插入评论
	public void testInsert() {
	    // 创建评论对象
	    Comment comment = new Comment();
	    // 设置评论对象属性
	    comment.setContent("写得很有用，赞一个~");
	    comment.setAuthor("尹立庆");
	    comment.setaId(2);
	    // 调用评论映射器实体的插入评论方法
	    int count = commentMapper.insert(comment);
	    // 判断评论是否插入成功
	    if (count > 0) { // 成功
	        System.out.println("恭喜，评论插入成功~");
	    } else { // 失败
	        System.out.println("遗憾，评论插入失败~");
	    }
	}
	
	@Test // 测试更新评论
	public void testUpdate() {
		// 获取标识符为7的评论对象
		Comment comment = commentMapper.findById(7);
		// 输出更新前的评论对象
		System.out.println("更新前：" + comment);
		// 修改评论对象
		comment.setContent("简单明了，讲解清晰，适合初学者~"); 
		comment.setAuthor("尹立庆"); 
		// 调用评论映射器实体的更新评论方法
		int count = commentMapper.update(comment);
		// 判断评论是否更新成功
		if (count > 0) { // 成功
			System.out.println("恭喜，评论更新成功~");
			System.out.println("更新后：" + commentMapper.findById(7));
		} else { // 失败
			System.out.println("遗憾，评论更新失败~");
		}
	}
	
	@Test // 测试按标识符删除评论
	public void testDeleteById() {
		// 定义标识符变量
		Integer id = 8;
		// 调用评论映射器实体的删除评论方法
		int count = commentMapper.deleteById(id);
		// 判断评论是否删除成功
		if (count > 0) { // 成功
			System.out.println("恭喜，评论删除成功~");
		} else { // 失败
			System.out.println("遗憾，评论删除失败~");
		}
	}
	
	@Test // 测试按照编号查询文章记录 
	public void testFindArticleById() { 
		Integer id = 1; 
		Article article = articleMapper.findArticleById(id);
		if (article != null) {
			System.out.println(article);
		} else {
			System.out.println("编号为[" + id + "]的文章未找到！"); 
		} 
	}
	
	@Test 
	public void testUpdateArticle() { 
		Article article = articleMapper.findArticleById(1); 
		System.out.println("更新前：" + article); 
		article.setContent("一步步接近企业真实项目~"); 
		int count = articleMapper.updateArticle(article); 
		// 判断是否更相信成功
		if (count > 0) {
			System.out.println("文章更新成功！");
			System.out.println("更新后：" + articleMapper.findArticleById(1));
		} else {
			System.out.println("文章更新失败！");
		} 
	}
	
	/****/
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, YinLiQing!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}
}
