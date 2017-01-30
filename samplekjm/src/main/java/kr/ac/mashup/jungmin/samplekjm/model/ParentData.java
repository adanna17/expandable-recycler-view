package kr.ac.mashup.jungmin.samplekjm.model;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ParentData extends MultiCheckExpandableGroup {

    private String title;
    private int totalPrice;
    private int checkedCount;
    private List<ChildData> childDataList;

    public ParentData(String title, List<ChildData> items) {
        super(title, items);
        this.title = title;
        this.childDataList = items;
        sumPrice();
        sumChecked();
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getCheckedCount() {
        return checkedCount;
    }

    private void sumPrice() {
        totalPrice = 0;
        for (int i = 0; i < childDataList.size(); i++) {
            totalPrice += childDataList.get(i).getChildPrice();
        }
    }

    public void sumChecked(){
        checkedCount = 0;
        for(int i = 0; i < childDataList.size(); i++){
            if(childDataList.get(i).isFavorite()){
                checkedCount += 1;
            }
        }
    }
}
