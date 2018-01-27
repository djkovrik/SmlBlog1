package model;

import java.util.Date;
import pl.droidsonroids.jspoon.annotation.Selector;

public class SmlArticlePreviewAdvanced {

  @Selector(value = "a.title")
  public String title;

  @Selector(value = "a.title", attr = "href")
  public String titleLink;

  @Selector(value = "a > img", attr = "src", defValue = "")
  public String previewImage;

  @Selector(value = ".author")
  public String author;

  @Selector(value = ".date-tag", format = "d MMMMM YYYY", locale = "ru")
  public Date date;

  @Selector(value = "p.preview")
  public String preview;
}
