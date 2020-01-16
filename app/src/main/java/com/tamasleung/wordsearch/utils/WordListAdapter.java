package com.tamasleung.wordsearch.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tamasleung.wordsearch.R;

public class WordListAdapter extends BaseAdapter {

    Context context;
    private String[] words;
    View view;
    LayoutInflater layoutInflater;

    public WordListAdapter(Context context, String[] words) {
        this.context = context;
        this.words = words;
    }

    @Override
    public int getCount() {
        return words.length;
    }

    @Override
    public Object getItem(int position) {
        return words[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_word, null);
            TextView wordView = (TextView) view.findViewById(R.id.singleword_word);
            wordView.setText(words[position]);
        }

        return view;
    }
}
