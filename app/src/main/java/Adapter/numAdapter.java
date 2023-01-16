package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.R;

import java.util.List;

public class numAdapter extends RecyclerView.Adapter<numAdapter.ViewHolder> {
    public numAdapter(List<num> list) {
        mList = list;
    }

    private List<num>mList;
    @NonNull
    @Override
    public numAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.numlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull numAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(String.valueOf(mList.get(position).getNum()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_0);
        }
    }
}
