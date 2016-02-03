package com.arjunkumbakkara.codillenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Arjun Kumbakkara on 30-01-2016.
 */
    public  class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        @SuppressWarnings("unused")
        private static final String TAG = Adapter.class.getSimpleName();
        private static Context mcontext;
        public static class ViewHolder extends RecyclerView.ViewHolder {

            TextView title;
            TextView subtitle;
            ImageView urlimv;

            public ViewHolder(View itemView) {
                super(itemView);

                title = (TextView) itemView.findViewById(R.id.title);
                subtitle = (TextView) itemView.findViewById(R.id.subTitle);
                urlimv=(ImageView)itemView.findViewById(R.id.urlimv);



            }
        }


    private List<Item> items;

    public Adapter(Context context,List<Item> items) {
        super();
        this.mcontext=context;
        this.items=items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = items.get(position);

        holder.title.setText(item.getprduct_name());
        holder.subtitle.setText(item.getprice());
        Picasso.with(mcontext)
                .load(item.getProduct_image())
                .into(holder.urlimv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}

