package com.example.bitsandpizzas;

public class Pizza {
    private String name;
    private int imageResourceId;

    public static final Pizza[] pizzas = {
      new Pizza("Diavolo", R.drawable.diavolo),
      new Pizza("Funghi", R.drawable.funghi),
      new Pizza("Pz3", R.drawable.diavolo),
      new Pizza("Pz4", R.drawable.diavolo),
      new Pizza("Pz5", R.drawable.diavolo),
      new Pizza("Pz6", R.drawable.diavolo),
      new Pizza("Pz7", R.drawable.diavolo),
      new Pizza("Pz8", R.drawable.diavolo),
      new Pizza("Pz9", R.drawable.diavolo),
      new Pizza("Pz10", R.drawable.diavolo),
    };

    public Pizza(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
