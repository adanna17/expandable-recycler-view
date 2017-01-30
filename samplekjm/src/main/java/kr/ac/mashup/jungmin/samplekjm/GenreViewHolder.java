package kr.ac.mashup.jungmin.samplekjm;

import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.ac.mashup.jungmin.samplekjm.model.ParentData;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class GenreViewHolder extends GroupViewHolder {

  public static final String TAG = GenreViewHolder.class.getSimpleName();

  @BindView(R.id.swipe_item)
  SwipeLayout swipeLayout;

  @BindView(R.id.textView_title)
  TextView tvTitle;

  @BindView(R.id.textView_debtor_count)
  TextView tvDeboterCount;

  @BindView(R.id.textView_parent_price)
  TextView tvParentPrice;

  @BindView(R.id.imageView_parent_arrow)
  ImageView imgArrow;

  public GenreViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void bind(ExpandableGroup parentData){

    Log.v(TAG, "======parent view holder======");

    swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
    swipeLayout.addDrag(SwipeLayout.DragEdge.Right,
            swipeLayout.findViewById(R.id.swipe_menu));

    tvTitle.setText(((ParentData) parentData).getTitle());

    String priceReceiveTotalKRW = NumberFormat.getInstance(Locale.KOREA).format(((ParentData) parentData).getTotalPrice());
    tvParentPrice.setText(priceReceiveTotalKRW+"원");

    int numOfTotalChild = ((ParentData) parentData).getItemCount();
    int countChecked = 0;

    for (int i=0; i<numOfTotalChild; i++){
      if (((ParentData) parentData).isChildChecked(i)){
        countChecked += 1;
      }
    }
    String countReceiveDebtors = countChecked + "명/" + numOfTotalChild + "명";
    tvDeboterCount.setText(countReceiveDebtors);
  }

  @Override
  public void expand() {
    animateExpand();
  }

  @Override
  public void collapse() {
    animateCollapse();
  }

  private void animateExpand() {
    RotateAnimation rotate =
        new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    imgArrow.setAnimation(rotate);
  }

  private void animateCollapse() {
    RotateAnimation rotate =
        new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    imgArrow.setAnimation(rotate);
  }
}
