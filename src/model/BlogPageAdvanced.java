package model;

import java.util.List;
import pl.droidsonroids.jspoon.annotation.Selector;

public class BlogPageAdvanced {

  @Selector(value = "a[id=id_vk_social]", attr = "href")
  public String vkLink;

  @Selector(value = "a[id=id_tw_social]", attr = "href")
  public String twitterLink;

  @Selector("div.news__item")
  public List<SmlArticlePreviewAdvanced> articles;
}
