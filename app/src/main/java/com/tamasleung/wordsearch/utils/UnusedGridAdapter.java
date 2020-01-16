package com.tamasleung.wordsearch.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tamasleung.wordsearch.Constants;
import com.tamasleung.wordsearch.R;
import com.tamasleung.wordsearch.views.GameView;

public class UnusedGridAdapter extends BaseAdapter {


    private Context context;
    private final char[] letters;
    private Holder holder;
    private GameView gameView;

    private View view;
    private LayoutInflater layoutInflater;


    public UnusedGridAdapter(Context context, char[] letters, GameView gameView) {
        this.context = context;
        this.letters = letters;
        this.gameView = gameView;
    }

    class Holder {
        TextView charView;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int position) {
        return letters[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        holder = new Holder();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.single_char, null);

            holder.charView = (TextView) convertView.findViewById(R.id.singlechar_char);



            convertView.setTag(holder);

//            view = new View(context);
//            view = layoutInflater.inflate(R.layout.single_char, null);
//            TextView charView = (TextView) view.findViewById(R.id.singlechar_char);
//            charView.setText(String.valueOf(letters[position]));

//            view.setOnHoverListener(new View.OnHoverListener() {
//                @Override
//                public boolean onHover(View v, MotionEvent event) {
//                    Log.v(Constants.DebugTag, "Testing 123: "+letters[position]);
//                    return true;
//                }
//            });


        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.charView.setText(String.valueOf(letters[position]));

//        convertView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    Log.v(Constants.DebugTag, "Testing Down " + letters[position]);
//                }
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    Log.v(Constants.DebugTag, "Testing Up " + letters[position]);
//                }
//                return true;
//            }
//        });

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v(Constants.DebugTag, "Testing Click " + letters[position]);
//             //   gameView.addNewInputPosition(position);
//            }
//        });

        convertView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.v(Constants.DebugTag, "Testing Click " + letters[position]);
                return false;
            }
        });

        return convertView;
    }

//    public void ActionDown(){
//        Log.v(Constants.DebugTag, "Testing down ");
//
//    }
//
//    public void ActionUp() {
//        Log.v(Constants.DebugTag, "Testing Up ");
//    }
}
