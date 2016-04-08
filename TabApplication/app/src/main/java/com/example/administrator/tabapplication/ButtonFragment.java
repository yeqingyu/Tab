package com.example.administrator.tabapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ButtonFragment extends Fragment{
	Button myButton;  
    
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View rootView = inflater.inflate(R.layout.guide_1, container, false);//���������ļ�  
          
        myButton = (Button)rootView.findViewById(R.id.mybutton);//���rootView�ҵ�button  

        myButton.setOnClickListener(new View.OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Toast.makeText(ButtonFragment.this.getActivity(), "button is click!", Toast.LENGTH_SHORT).show();  
            }  
        });  
          
          
        return rootView;  
    }  
}
