package com.jwhh.jim.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mlayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        mContext = context;
        mNotes = notes;
        mlayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mlayoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NoteInfo note = mNotes.get(position);
        holder.mtextCourse.setText(note.getCourse().getTitle());
        holder.mtextTitle.setText(note.getTitle());
        holder.mId = note.getId();
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mtextCourse;
        public final TextView mtextTitle;
        public int mId;

        public ViewHolder(View itemView) {
            super(itemView);
            mtextCourse = itemView.findViewById(R.id.text_course);
            mtextTitle = itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
