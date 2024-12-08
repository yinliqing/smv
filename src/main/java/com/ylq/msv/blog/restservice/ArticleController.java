package com.ylq.msv.blog.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ylq.msv.blog.bean.Article;
import com.ylq.msv.blog.bean.Comment;
import com.ylq.msv.blog.bean.Greeting;
import com.ylq.msv.blog.mapper.ArticleMapper;
import com.ylq.msv.blog.mapper.CommentMapper;

@RestController
public class ArticleController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	@Autowired // 注入评论映射器bean
	private CommentMapper commentMapper;
	@Autowired  // 注入文章映射器bean
	private ArticleMapper articleMapper;
	
	@GetMapping("/comment")
	public Comment findCommentById(@RequestParam(value = "id", defaultValue = "1") Integer id) {
	    // 定义标识符变量
		// Integer id = 1;
	    // 调用评论映射器实体的按标识符查询评论方法
	    Comment comment = commentMapper.findById(id);
	    // 判断查询是否成功
	    if (comment != null) { // 成功
	        System.out.println(comment);
	        return comment;
	    } else { // 失败
	        System.out.println("标识符为[" + id + "]的评论未找到~");
	    }
		return comment;
	}

	@GetMapping("/article")
	public Article findArticleById(@RequestParam(value = "id", defaultValue = "1") Integer id) {
	    // 定义标识符变量
		// Integer id = 1;
	    // 调用评论映射器实体的按标识符查询评论方法
		Article article = articleMapper.findArticleById(id);
	    // 判断查询是否成功
	    if (article != null) { // 成功
	        System.out.println(article);
	        return article;
	    } else { // 失败
	        System.out.println("标识符为[" + id + "]的评论未找到~");
	    }
		return article;
	}

	@GetMapping("/index")
	public String index(@RequestParam(value = "id", defaultValue = "1") Integer id) {
	    // 定义标识符变量
		// Integer id = 1;
		// 添加模型数据
        // 返回视图名称，对应src/main/resources/templates/目录下的someview.ftl文件
		// <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
        return "<script src=\"https://unpkg.com/vue@3/dist/vue.global.js\"></script><div id=\"app\">{{ message }}</div><script> const { createApp, ref } = Vue;  createApp({    setup() {      const message = ref('Hello YinLiQing!');      return {        message      }    }  }).mount('#app');</script>";
        // return "<script src=\"https://unpkg.com/vue@3/dist/vue.global.js\"></script><template>  <div>    <input v-model=\"name\" placeholder=\"Enter your name\">    <button @click=\"greet\">Greet</button>    <p>{{ greetingMessage }}</p>  </div></template><script>export default {  data() {    return {      name: '',      greetingMessage: ''    }  },  methods: {    greet() {      fetch('/api/greeting?name=' + this.name)        .then(response => response.text())        .then(message => {          this.greetingMessage = message;        });    }  }}</script>";
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "YinLiQing") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
