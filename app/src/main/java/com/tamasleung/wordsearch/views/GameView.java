package com.tamasleung.wordsearch.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ListView;

import com.tamasleung.wordsearch.R;
import com.tamasleung.wordsearch.model.Board;
import com.tamasleung.wordsearch.utils.GridAdapter;
import com.tamasleung.wordsearch.utils.UnusedGridAdapter;
import com.tamasleung.wordsearch.utils.StringLengthComparator;
import com.tamasleung.wordsearch.utils.WordListAdapter;

import java.util.Arrays;
import java.util.List;

public class GameView extends AppCompatActivity {

    static final int size = 10;
    static String[] words = { "SWIFT", "KOTLIN", "OBJECTIVEC", "VARIABLE", "JAVA", "MOBILE" };
    static Board board;

//    GridView gridView;
    RecyclerView gridView;
    ListView wordlistView;

    private boolean inAttempt = false;
    private int position;
    private List<Integer> validOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        //Sorting words by length from longest to shortest
        Arrays.sort(words, new StringLengthComparator());

        //Creating a gameboard
        board = new Board(size, words);

        //Recieving board as an 1D array for the gridAdapter
        char[] boardLetters = board.getBoardAs1DArray();

        //Setting GridView
//        gridView = (GridView) findViewById(R.id.gameview_grid);
//        gridView.setNumColumns(size);
//        GridAdapter gridAdapter = new GridAdapter(this, boardLetters);
//        gridView.setAdapter(gridAdapter);

        gridView = (RecyclerView) findViewById(R.id.gameview_grid);
        gridView.setLayoutManager(new GridLayoutManager(this));


        //Setting Word List View
        wordlistView = (ListView) findViewById(R.id.gameview_word_list);
        WordListAdapter wordListAdapter = new WordListAdapter(this, words);
        wordlistView.setAdapter(wordListAdapter);

//        //Controlling Clicks for gridView
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

//        gridView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View arg0, MotionEvent arg1) {
//
//                if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
//
//                    gridAdapter.ActionDown();
//
//                }
//                if (arg1.getAction() == MotionEvent.ACTION_UP) {
//
//                    gridAdapter.ActionUp();
//                }
//
//                return false;
//            }
//        });

    }

//    public void addNewInputPosition(int position){
//        int x, y;
//
//        if(inAttempt) {
//
//        } else {
//            createValidOptions(x, y);
//
//        }
//    }
//
//    public void createValidOptions(int x, int y);
}
