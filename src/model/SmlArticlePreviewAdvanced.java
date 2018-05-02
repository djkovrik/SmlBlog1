package model;

import pl.droidsonroids.jspoon.annotation.Selector;

public class SmlArticlePreviewAdvanced {

  @Selector(value = "a.title")
  public String title;

  @Selector(value = "a.title", attr = "href")
  public String link;

  @Selector(value = ".author")
  public String author;

  @Selector(value = "p.preview")
  public String preview;

  @Selector(value = "a > img", attr = "src", regex = ".*/(.*)", defValue = "")
  public String previewImage;
}
