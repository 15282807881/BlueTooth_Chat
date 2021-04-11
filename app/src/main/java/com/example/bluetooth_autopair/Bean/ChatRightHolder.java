package com.example.bluetooth_autopair.Bean;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bluetooth_autopair.R;

public class ChatRightHolder extends RecyclerView.ViewHolder {
    private TextView tvContent;
    private TextView tvName;

    public ChatRightHolder(View itemView) {
        super(itemView);
        tvContent = (TextView) itemView.findViewById(R.id.tv_right);
        tvName = (TextView) itemView.findViewById(R.id.tv_device);
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public void setTvContent(TextView tvContent) {
        this.tvContent = tvContent;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }
}
