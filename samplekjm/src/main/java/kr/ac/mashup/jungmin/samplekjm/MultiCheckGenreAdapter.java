package kr.ac.mashup.jungmin.samplekjm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;


import java.util.List;

import kr.ac.mashup.jungmin.samplekjm.model.ChildData;
import kr.ac.mashup.jungmin.samplekjm.model.ParentData;

public class MultiCheckGenreAdapter extends
    CheckableChildRecyclerViewAdapter<GenreViewHolder, MultiCheckArtistViewHolder> {

  public static final String TAG = MultiCheckGenreAdapter.class.getSimpleName();

  public MultiCheckGenreAdapter(List<ParentData> groups) {
    super(groups);
  }


  @Override
  public MultiCheckArtistViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_child, parent, false);
    return new MultiCheckArtistViewHolder(view);
  }

  @Override
  public void onBindCheckChildViewHolder(MultiCheckArtistViewHolder holder, int position,
      CheckedExpandableGroup group, int childIndex) {
    final ChildData childData = (ChildData) group.getItems().get(childIndex);
    holder.bind(childData);
    Log.v(TAG, "======child adapter======");
  }

  @Override
  public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_list_parent, parent, false);
    return new GenreViewHolder(view);
  }

  @Override
  public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition,
      ExpandableGroup group) {
    holder.bind(group, flatPosition);
    Log.v(TAG, "======parent adapter======");
  }
}
