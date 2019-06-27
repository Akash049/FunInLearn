package com.example.administrator.storyapp.Quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08-06-2016.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

  private static final String TAG = "SQL";

  // Specifying the DATABASE VERSION
  private static final int DATABASE_VERSION = 1;

  // Specifying the database name
  private static final String DATABASE_NAME = "QUIZ";

  // Specifying the TABLE NAME
  private static final String TABLE_NAME = "Level_1";
  private static final String TABLE_ECONOMICS_1 = "ECONOMICS_Level_1";
  private static final String TABLE_TECHNOLOGY_1 = "TECHNOLOGY_Level_1";
  private static final String TABLE_CURRENT_AFFAIRS_1 = "CURRENT_AFFAIRS_Level_1";
  private static final String TABLE_SCIENCE_1 = "SCIENCE_Level_1";
  private static final String TABLE_PROGRAMMING_1 = "PROGRAMMING_Level_1";

  //Specifying the fields
  private static final String KEY_QUESTION_NUMBER = "Q_Number";
  private static final String KEY_QUESTION = "Question";
  private static final String KEY_OPTION_1 = "Opt_1";
  private static final String KEY_OPTION_2 = "Opt_2";
  private static final String KEY_OPTION_3 = "Opt_3";
  private static final String KEY_OPTION_4 = "Opt_4";

  private static final String KEY_ANSWER = "Answer";

  private static final String KEY_OPTION_SELECTED = "Opt_selected";

  private static final String KEY_SCORE = "Score";


  public DataBaseHandler(Context context) {
    super(context, DATABASE_NAME, null  , DATABASE_VERSION);
  }

  // Created Tables for the questions of all subjects
  @Override
  public void onCreate(SQLiteDatabase db) {

    String query = "CREATE TABLE " + TABLE_NAME + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";

    String Economics_level_1_query = "CREATE TABLE " + TABLE_ECONOMICS_1 + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";

    String Technology_level_1_query = "CREATE TABLE " + TABLE_TECHNOLOGY_1 + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";

    String Current_Affairs_level_1_query = "CREATE TABLE " + TABLE_CURRENT_AFFAIRS_1 + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";

    String Science_level_1_query = "CREATE TABLE " + TABLE_SCIENCE_1 + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";

    String Programming_level_1_query = "CREATE TABLE " + TABLE_PROGRAMMING_1 + " ( " + KEY_QUESTION_NUMBER + " INTEGER , " + KEY_QUESTION + " TEXT , " +
      KEY_OPTION_1 + " TEXT , " +  KEY_OPTION_2  + " TEXT , " + KEY_OPTION_3 + " TEXT , " + KEY_OPTION_4 +
      " TEXT , " +  KEY_ANSWER + " TEXT , " +  KEY_OPTION_SELECTED + " TEXT , " + KEY_SCORE + " INTEGER  ) ";


    db.execSQL(query);
    db.execSQL(Economics_level_1_query);
    db.execSQL(Technology_level_1_query);
    db.execSQL(Current_Affairs_level_1_query);
    db.execSQL(Science_level_1_query);
    db.execSQL(Programming_level_1_query);




  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  /**
   * Methods to add questions
   * @param data
     */

  /**
   * ECONOMICS
   * @param data
     */
  public void add_Economics_Level_1_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_ECONOMICS_1,null,values);
    db.close();

  }

  /**
   * CURRENT AFFAIRS
   * @param data
   */
  public void add_Current_Affairs_Level_1_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_CURRENT_AFFAIRS_1 ,null,values);
    db.close();

  }


  /**
   * Science
   * @param data
   */
  public void add_Science_Level_1_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_SCIENCE_1 ,null,values);
    db.close();

  }


  /**
   * Technology
   * @param data
   */
  public void add_Technology_Level_1_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_TECHNOLOGY_1  ,null,values);
    db.close();

  }

  /**
   * Programming
   * @param data
   */
  public void add_Programming_Level_1_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_PROGRAMMING_1 ,null,values);
    db.close();

  }



  //Methods to add questions to the Database
  public void add_question(Quiz_Data_Model data)
  {
    final SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(KEY_QUESTION_NUMBER,data.getQ_Num());
    values.put(KEY_QUESTION,data.getQuestion());
    values.put(KEY_OPTION_1,data.getQ_Opt_1());
    values.put(KEY_OPTION_2,data.getQ_Opt_2());
    values.put(KEY_OPTION_3,data.getQ_Opt_3());
    values.put(KEY_OPTION_4,data.getQ_Opt_4());
    values.put(KEY_ANSWER,data.getAnswer());
    values.put(KEY_OPTION_SELECTED,data.getQ_Opt_Selected());
    values.put(KEY_SCORE,data.getQ_Score());

    db.insert(TABLE_NAME,null,values);
    db.close();

  }

  public Quiz_Data_Model GetQuestion_From_Table(int Q_Num,String Table_Name)
  {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.query(Table_Name, new String[] { KEY_QUESTION_NUMBER,KEY_QUESTION,KEY_OPTION_1,KEY_OPTION_2,KEY_OPTION_3,
        KEY_OPTION_4, KEY_ANSWER,KEY_OPTION_SELECTED,KEY_SCORE}, KEY_QUESTION_NUMBER + "=?",
      new String[] { String.valueOf(Q_Num) }, null, null, null, null);

    if(cursor!=null)
      cursor.moveToFirst();

    Quiz_Data_Model data = new Quiz_Data_Model(Integer.parseInt(cursor.getString(0))  , cursor.getString(1),
      cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),
      Integer.parseInt(cursor.getString(8)));

    return data;
  }

  public Quiz_Data_Model GetQuestion(int Q_Num)
  {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_QUESTION_NUMBER,KEY_QUESTION,KEY_OPTION_1,KEY_OPTION_2,KEY_OPTION_3,
        KEY_OPTION_4, KEY_ANSWER,KEY_OPTION_SELECTED,KEY_SCORE}, KEY_QUESTION_NUMBER + "=?",
      new String[] { String.valueOf(Q_Num) }, null, null, null, null);

    if(cursor!=null)
         cursor.moveToFirst();

    Quiz_Data_Model data = new Quiz_Data_Model(Integer.parseInt(cursor.getString(0))  , cursor.getString(1),
      cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),
      Integer.parseInt(cursor.getString(8)));

    return data;
  }

  public boolean isEmpty()
  {
    SQLiteDatabase db = this.getWritableDatabase();
    String count = "SELECT count(*) FROM " + TABLE_NAME;
    Cursor mcursor = db.rawQuery(count,null);
    mcursor.moveToFirst();
    int icount = mcursor.getInt(0);
    if(icount>0)
      return false;
    else
      return true;
  }

  public List<Quiz_Data_Model> Quiz_data()
  {
    List<Quiz_Data_Model> quiz = new ArrayList<Quiz_Data_Model>();
    String query = "SELECT  * FROM " + TABLE_NAME;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(query,null);

    if(cursor.moveToFirst())
    {
      do{
           Quiz_Data_Model data = new Quiz_Data_Model();
           data.setQ_Num(Integer.parseInt(cursor.getString(0)));
           data.setQuestion(cursor.getString(1));
           data.setQ_Opt_1(cursor.getString(2));
           data.setQ_Opt_2(cursor.getString(3));
           data.setQ_Opt_3(cursor.getString(4));
           data.setQ_Opt_4(cursor.getString(5));
           data.setAnswer(cursor.getString(6));
           data.setQ_Opt_Selected(cursor.getString(7));
           data.setQ_Score(Integer.parseInt(cursor.getString(8)));
        }while (cursor.moveToNext());
    }
    return quiz;
  }

}
