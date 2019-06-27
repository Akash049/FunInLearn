package com.example.administrator.storyapp.Model;

/**
 * Created by Administrator on 01-07-2016.
 */
public class SubjectData {
  public String SubjectName;
  public String SubjectLevel;
  public int ImageId;

  public SubjectData(String subjectName, String subjectLevel, int imageId) {
    SubjectName = subjectName;
    SubjectLevel = subjectLevel;
    ImageId = imageId;
  }

  public SubjectData() {
  }

  public String getSubjectName() {
    return SubjectName;
  }

  public String getSubjectLevel() {
    return SubjectLevel;
  }

  public int getImageId() {
    return ImageId;
  }

  public void setSubjectName(String subjectName) {
    SubjectName = subjectName;
  }

  public void setSubjectLevel(String subjectLevel) {
    SubjectLevel = subjectLevel;
  }

  public void setImageId(int imageId) {
    ImageId = imageId;
  }
}
