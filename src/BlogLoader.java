import io.reactivex.Single;
import model.BlogPage;
import model.BlogPageAdvanced;
import retrofit2.http.GET;

public interface BlogLoader {

  @GET("/blog/razrabotka/")
  Single<BlogPage> loadBlogPage();

  @GET("/blog/razrabotka/")
  Single<BlogPageAdvanced> loadBlogPageAdvanced();
}
