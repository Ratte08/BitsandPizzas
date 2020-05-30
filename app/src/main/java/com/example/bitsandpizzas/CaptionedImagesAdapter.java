package com.example.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.PizzaViewHolder> {

    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);
        return new PizzaViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);

        holder.imageView.setImageDrawable(drawable);
        holder.imageView.setContentDescription(captions[position]);
        holder.textView.setText(captions[position]);
    }

    interface Listener {
        void onClickPizza(int position);
    }

    public void setPizzaListener(Listener listener) {
        this.listener = listener;
    }

    public class PizzaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cardView;
        ImageView imageView;
        TextView textView;

        public PizzaViewHolder(CardView v) {
            super(v);
            cardView = v;

            cardView.setOnClickListener(this);

            imageView = (ImageView)cardView.findViewById(R.id.iv_pizza_card);
            textView = (TextView)cardView.findViewById(R.id.tv_pizza_name_card);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClickPizza(getAdapterPosition());
            }
        }
    }
}
