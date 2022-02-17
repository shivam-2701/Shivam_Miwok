package com.example.ud839_miwok_lesson_one;

public class Word {
    /**
     * For the Default translation of word in users preferred language of choice
     */
    private String mDefaultTranslation;
    /**
     * Miwok translation of the same word
     */
    private String mMiwokTranslation;
    private int mImageResourceId=-1;
    //Initialises the word class with its correct values
    public Word(String mDefaultTranslation,String mMiwokTranslation){
        this.mDefaultTranslation=mDefaultTranslation;
        this.mMiwokTranslation=mMiwokTranslation;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
    }

    //returns the default Translation of the word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    //returns the miwok Translation of the word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    //returns the id of the image associated
    public int getmImageResourceId(){ return mImageResourceId; }


}
