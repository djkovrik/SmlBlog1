import model.SmlArticlePreviewAdvanced;

public class SmlDisplayArticlesAdvanced {

  public static void main(String[] args) {

    RetrofitHelper
        .createRetrofitInstance()
        .create(BlogLoader.class)
        .loadBlogPageAdvanced()
        .subscribe(
            blogPage -> {
              System.out.println("VK: " + blogPage.vkLink);
              System.out.println("Facebook: " + blogPage.facebookLink);
              System.out.println("Twitter: " + blogPage.twitterLink);
              System.out.println("");
              blogPage.articles.forEach(SmlDisplayArticlesAdvanced::prettyPrintArticle);
            },
            throwable ->
                System.out.println("Ошибка загрузки: " + throwable.getMessage()));
  }

  private static void prettyPrintArticle(SmlArticlePreviewAdvanced article) {
    System.out.println("Заголовок: " + article.title);
    System.out.println("Ссылка на статью: " + article.link);
    System.out.println("Автор: " + article.author);
    System.out.println("Превью-текст: " + article.preview);
    System.out.println("Файл превью: " + article.previewImage);
    System.out.println("");
  }
}
