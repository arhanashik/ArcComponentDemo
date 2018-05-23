package com.blackspider.archcomponentdemo.notelist;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 12:33 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blackspider.archcomponentdemo.R;
import com.blackspider.archcomponentdemo.database.NoteModel;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<NoteModel> mNotes;
    private OnNoteClickListener mListener;

    NoteAdapter(List<NoteModel> notes){
        mNotes = notes;
    }

    public void setListener(OnNoteClickListener listener){
        mListener  = listener;
    }

    public void addNote(List<NoteModel> notes){
        mNotes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, null);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(mNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvDescription;

        NoteViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.txt_title);
            tvDescription = itemView.findViewById(R.id.txt_description);
        }

        void bind(NoteModel noteModel){
            tvTitle.setText(noteModel.getTitle());
            tvDescription.setText(noteModel.getDescription());
        }
    }

    public interface OnNoteClickListener{
        void onNoteClicked(NoteModel noteModel);
    }
}
