package com.example.administrator.storyapp.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.storyapp.Model.SubjectData;
import com.example.administrator.storyapp.ViewHolders.SubjectListViewHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 01-07-2016.
 */
public class SubjectListAdapters extends BaseAdapter {
  ArrayList<SubjectData> data = new ArrayList<>();
  Context context;

  public SubjectListAdapters(ArrayList<SubjectData> data, Context context) {
    this.data = data;
    this.context = context;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int position) {
    return data.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {

    SubjectListViewHolder subjectListViewHolder = (SubjectListViewHolder)convertView;
    if(subjectListViewHolder == null)
    {
      subjectListViewHolder = new SubjectListViewHolder(context);
    }
    SubjectData data = (SubjectData)getItem(position);
    subjectListViewHolder.Set_Subject(data);
    return subjectListViewHolder;
  }
}
