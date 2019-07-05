package com.example.android.miwok;

/**
 * Created by jamesbeaton on 01/10/2017.
 */

public class Word {

    /* default translation for the word */
    private String mDefaultYTranslation;
    /* miwok translation for the word */
    private String mMiwokTranslation;
    /* image resource id for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /* audio resource id for the word */
    private int mAudioResourceId;
    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /* constructor */
    public Word(String DefaultYTranslation, String MiwokTranslation, int AudioResourceId) {
        mDefaultYTranslation = DefaultYTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceId = AudioResourceId;
    }

    /* constructor */
    public Word(String DefaultYTranslation, String MiwokTranslation, int ImageResourceId, int AudioResourceId) {
        mDefaultYTranslation = DefaultYTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }
    /* getter method */
    public String getmDefaultYTranslation() {
        return mDefaultYTranslation;

    }
    /* getter method */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /* because the int variable was initialised in the Word constructor above
     any outside caller can assess it through this public method */
    /* getter method */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * boolean method is exposed to return an image
     */
    /* getter method */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /* getter method */
    /** return the audio resource of the word **/
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }


    /*log statement used below is to figure out the state of the app
      * cmd +n is the shortcut to bring up toString methods */

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultYTranslation='" + mDefaultYTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}