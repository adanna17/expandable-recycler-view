package kr.ac.mashup.jungmin.samplekjm;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import kr.ac.mashup.jungmin.samplekjm.model.ChildData;

public class Genre extends ExpandableGroup<ChildData> {

  private int iconResId;

  public Genre(String title, List<ChildData> items, int iconResId) {
    super(title, items);
    this.iconResId = iconResId;
  }

  public int getIconResId() {
    return iconResId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Genre)) return false;

    Genre genre = (Genre) o;

    return getIconResId() == genre.getIconResId();

  }

  @Override
  public int hashCode() {
    return getIconResId();
  }
}

