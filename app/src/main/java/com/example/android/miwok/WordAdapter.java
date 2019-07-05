package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jamesbeaton on 02/10/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColourResourceId;
    /**
     * added a colour id that the constructor can use
     */
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of Word objects to display in a list
     */
    /* the constructer name WordAdapter needs to match the class names */
    public WordAdapter(Activity context, ArrayList<Word> words, int colourResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words); /* we pass 0 here as the layout resource id as were inflating the layout ourselves in
         the getView method */
        mColourResourceId = colourResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getmMiwokTranslation());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getmDefaultYTranslation());
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        if (currentWord.hasImage()) {
            miwokImageView.setImageResource(currentWord.getmImageResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        /* make sure the visibility is set to gone */
        else {
            miwokImageView.setVisibility(View.GONE);
        }

        // set the theme colour for the list view
        View textContainer = listItemView.findViewById(R.id.text_container);

        // find the colour that the resource ID maps to
        int colour = ContextCompat.getColor(getContext(), mColourResourceId);

        // set the background colour of the text container view
        textContainer.setBackgroundColor(colour);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}