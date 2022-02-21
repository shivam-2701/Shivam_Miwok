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
    private static final int  NO_IMAGE_PROVIDED=-1;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    //Initialises the word class with its correct values
    public Word(String mDefaultTranslation,String mMiwokTranslation,int mAudioResourceId){
        this.mDefaultTranslation=mDefaultTranslation;
        this.mMiwokTranslation=mMiwokTranslation;
        this.mAudioResourceId=mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId,int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId=mAudioResourceId;
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
    //returns if the image is present or not
    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
