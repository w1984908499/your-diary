package sunxl8.your_diary.ui.diary.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sunxl8.your_diary.R;
import sunxl8.your_diary.db.entity.DiaryEntity;
import sunxl8.your_diary.util.TimeUtils;

/**
 * Created by sunxl8 on 2017/2/13.
 */

public class DiaryListAdapter extends RecyclerView.Adapter<DiaryListAdapter.DiaryListViewHolder> {

    private Context mContext;
    private List<DiaryEntity> mList;

    public DiaryListAdapter(Context context, List<DiaryEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public DiaryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DiaryListViewHolder holder =
                new DiaryListViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_diary_list, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(DiaryListViewHolder holder, int position) {
        final DiaryEntity entity = mList.get(position);
        if (entity.getShowDate()) {
            holder.tvDate.setText(TimeUtils.date2String(entity.getDate(), new SimpleDateFormat("dd")));
            holder.tvDate.setVisibility(View.VISIBLE);
        } else {
            holder.tvDate.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class DiaryListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_diray_list_date)
        TextView tvDate;

        public DiaryListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
