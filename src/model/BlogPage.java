package model;

import java.util.List;
import pl.droidsonroids.jspoon.annotation.Selector;

public class BlogPage {

  @Selector("div.news__item")
  public List<model.SmlArticlePreview> articles;
}
