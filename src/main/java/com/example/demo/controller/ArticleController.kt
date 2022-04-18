package com.example.demo.controller

import com.example.demo.helper.JSONFormatter
import com.example.demo.helper.JSONResponse
import com.example.demo.model.Article
import com.example.demo.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ArticleController {
    @Autowired
    private val articleRepository: ArticleRepository? = null

    @PostMapping("/article")
    fun addArticle(@RequestBody article: Article): String {
        articleRepository?.save(article)

        return "SAVED"
    }

    @PutMapping("/article/{id}")
    fun updateArticle(@PathVariable("id") id: Int, @RequestBody article: Article): String {
        article.id = id
        articleRepository?.save(article)

        return "UPDATED"
    }

    @GetMapping("/article")
    fun getArticle(): JSONResponse<Article>? {
        val jsonFormatter : JSONFormatter<Article> = JSONFormatter()
        return jsonFormatter.response(200, "Success", articleRepository?.findAll())
    }
}