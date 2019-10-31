package com.developersbreach.navigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NavigatorAdapter extends RecyclerView.Adapter<NavigatorAdapter.NavigatorViewHolder> {

    private Context mContext;
    private List<Navigator> mNavigatorList;
    private NavigatorAdapterListener mListener;

    /**
     * Constructor for our adapter class
     */
    NavigatorAdapter(Context context, List<Navigator> navigatorList, NavigatorAdapterListener listener) {
        this.mContext = context;
        this.mNavigatorList = navigatorList;
        this.mListener = listener;
    }

    /**
     * The interface that receives onClick listener.
     */
    public interface NavigatorAdapterListener {
        void onNavigatorSelected(Navigator navigator, View view);
    }

    /**
     * Children views
     */
    class NavigatorViewHolder extends RecyclerView.ViewHolder {

        private ImageView mNavigatorIconImageView;
        private TextView mNavigatorNameTextView;

        NavigatorViewHolder(@NonNull final View itemView) {
            super(itemView);
            mNavigatorIconImageView = itemView.findViewById(R.id.direction_icon_image_item_view);
            mNavigatorNameTextView = itemView.findViewById(R.id.direction_name_text_item_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onNavigatorSelected(mNavigatorList.get(getAdapterPosition()), itemView);
                }
            });
        }
    }

    /**
     * Called when RecyclerView needs a new {@link NavigatorViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public NavigatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_navigator, parent, false);
        return new NavigatorViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link NavigatorViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull NavigatorViewHolder holder, int position) {
        Navigator navigator = mNavigatorList.get(position);
        holder.mNavigatorIconImageView.setImageResource(navigator.getNavigatorIcon());
        holder.mNavigatorNameTextView.setText(navigator.getNavigatorName());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mNavigatorList.size();
    }
}
