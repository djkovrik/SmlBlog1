package model;

import pl.droidsonroids.jspoon.annotation.Selector;

public class SmlArticlePreview {

  @Selector(value = "a.title")
  public String title;

  @Selector(value = "a.title", attr = "href")
  public String titleLink;

  @Selector(value = "p.author")
  public String author;

  @Selector(value = "p.preview")
  public String preview;
}
