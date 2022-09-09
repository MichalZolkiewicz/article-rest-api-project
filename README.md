### Description

Project is an implementation of an online store backend layer. It based on REST architecture.

### Demo

Project is not uploaded to remote server yet.

### Requirements

* Java Virtual Machine
* MySQL
* Gradle 7.5
* Spring Boot 2.1.1
* Lombok 1.18.24

### Running the project

In order to launch project, You you need to run ArticleRestApplication class. 
Endpoints operation can be checked on http://localhost:3306 address.

### Endpoints description

v1/article/getArticles - GET method, no parameters. Endpoint will retrieve all articles.
v1/article/getArticle - GET method, articleId. Retrieve one article according to it's id number.
v1/article/addArticle - POST method, articleDTO. Create new article using articleDTO body. Returns id number of the created article.
v1/article/updateArticle - PUT method, articleID, articleTitle, articleContent. Endpoint can be used to update article content.
v1/article/deleteArticle - DELETE method, articleId. Delete article by it's id number.
v1/article/searchArticleKeyword - GET method, keyword. Endpoint returns the list of articles that contains chosen keyword either in title or in content.
