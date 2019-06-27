package com.example.administrator.storyapp.Quiz;

/**
 * Created by Administrator on 08-06-2016.
 */
public class Quiz_Data_Model {
  public int Q_Num;
  public String Question;
  public String Q_Opt_1;
  public String Q_Opt_2;
  public String Q_Opt_3;
  public String Q_Opt_4;
  public String Answer;
  public String Q_Opt_Selected;
  public int Q_Score;

  public Quiz_Data_Model()
  {

  }

  public Quiz_Data_Model(int Q_Num, String Question, String Q_Opt_1,String Q_Opt_2,String Q_Opt_3,String Q_Opt_4,String Answer,String Q_Opt_Selected,int Q_Score)
  {
             this.Q_Num = Q_Num;
             this.Question = Question;
             this.Q_Opt_1 = Q_Opt_1;
             this.Q_Opt_2 = Q_Opt_2;
             this.Q_Opt_3 = Q_Opt_3;
             this.Q_Opt_4 = Q_Opt_4;
             this.Answer = Answer;
             this.Q_Opt_Selected = Q_Opt_Selected;
             this.Q_Score = Q_Score;
  }


  public int getQ_Score() {
    return Q_Score;
  }

  public String getQ_Opt_Selected() {
    return Q_Opt_Selected;
  }

  public String getQ_Opt_4() {
    return Q_Opt_4;
  }

  public String getQ_Opt_3() {
    return Q_Opt_3;
  }

  public String getQ_Opt_2() {
    return Q_Opt_2;
  }

  public String getQ_Opt_1() {
    return Q_Opt_1;
  }

  public String getQuestion() {
    return Question;
  }

  public int getQ_Num() {
    return Q_Num;
  }

  public void setQ_Num(int q_Num) {
    Q_Num = q_Num;
  }

  public void setQuestion(String question) {
    Question = question;
  }

  public void setQ_Opt_1(String q_Opt_1) {
    Q_Opt_1 = q_Opt_1;
  }

  public void setQ_Opt_2(String q_Opt_2) {
    Q_Opt_2 = q_Opt_2;
  }

  public void setQ_Opt_3(String q_Opt_3) {
    Q_Opt_3 = q_Opt_3;
  }

  public void setQ_Opt_4(String q_Opt_4) {
    Q_Opt_4 = q_Opt_4;
  }

  public void setQ_Opt_Selected(String q_Opt_Selected) {
    Q_Opt_Selected = q_Opt_Selected;
  }

  public void setQ_Score(int q_Score) {
    Q_Score = q_Score;
  }

  public String getAnswer() {
    return Answer;
  }

  public void setAnswer(String answer) {
    Answer = answer;
  }
}
