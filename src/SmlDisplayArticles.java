import model.SmlArticlePreview;

public class SmlDisplayArticles {

  public static void main(String[] args) {

    RetrofitHelper
        .createRetrofitInstance()
        .create(BlogLoader.class)
        .loadBlogPage()
        .subscribe(
            blogPage ->
                blogPage.articles.forEach(SmlDisplayArticles::prettyPrintArticle),
            throwable ->
                System.out.println("Ошибка загрузки: " + throwable.getMessage()));
  }

  private static void prettyPrintArticle(SmlArticlePreview article) {
    System.out.println("Заголовок: " + article.title);
    System.out.println("Ссылка на статью: " + article.link);
    System.out.println("Автор: " + article.author);
    System.out.println("Превью-текст: " + article.preview);
    System.out.println("");
  }
}
