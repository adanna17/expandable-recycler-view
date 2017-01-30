package kr.ac.mashup.jungmin.samplekjm;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.ac.mashup.jungmin.samplekjm.model.ChildData;

public class MultiCheckArtistViewHolder extends CheckableChildViewHolder {

  public static final String TAG = MultiCheckArtistViewHolder.class.getSimpleName();

  @BindView(R.id.checkedTextView_debtor_name)
  CheckedTextView ctvDebtorNm;

  @BindView(R.id.textView_child_price)
  TextView tvChildPrice;

  @BindView(R.id.imageView_KaKaoLink)
  ImageView imgKaKaoLink;

  public MultiCheckArtistViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  @Override
  public Checkable getCheckable() {
    return ctvDebtorNm;
  }

  public void bind(ChildData childData){

    Log.v(TAG, "======child view holder======");

    String priceReceiveIndividualKRW = NumberFormat.getInstance(Locale.KOREA).format(childData.getChildPrice());
    tvChildPrice.setText(priceReceiveIndividualKRW+"원");
    ctvDebtorNm.setText(childData.getDebtorName());

    imgKaKaoLink.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // click kakao link
      }
    });

  }

}
