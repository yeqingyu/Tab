package com.example.administrator.tabapplication;
import java.util.ArrayList;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity{
	 private ViewPager mPager;  
	    private ArrayList<Fragment> fragmentList;  
	    private TextView barText;  
	    private TextView view1, view2, view3, view4;  
	    private int currIndex;

	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.main);  
	          
	        InitTextView();  
	        InitTextBar();  
	        InitViewPager();  
	    }  

	    public void InitTextView(){  
	        view1 = (TextView)findViewById(R.id.tv_guid1);  
	        view2 = (TextView)findViewById(R.id.tv_guid2);  
	        view3 = (TextView)findViewById(R.id.tv_guid3);  
	        view4 = (TextView)findViewById(R.id.tv_guid4);  
	          
	        view1.setOnClickListener(new txListener(0));  
	        view2.setOnClickListener(new txListener(1));  
	        view3.setOnClickListener(new txListener(2));  
	        view4.setOnClickListener(new txListener(3));  
	    }  
	      
	      
	    public class txListener implements View.OnClickListener{  
	        private int index=0;  
	          
	        public txListener(int i) {  
	            index =i;  
	        }  
	        @Override  
	        public void onClick(View v) {  
	            mPager.setCurrentItem(index);  
	        }  
	    }  
	      
	      

	    public void InitTextBar(){  
	    	barText = (TextView) super.findViewById(R.id.cursor);
	    	Display display = getWindow().getWindowManager().getDefaultDisplay();
	        DisplayMetrics metrics = new DisplayMetrics();
	    	display.getMetrics(metrics);
	    	int  tabLineLength = metrics.widthPixels / 4;
	    	 LayoutParams lp = (LayoutParams) barText.getLayoutParams();
	    	 lp.width = tabLineLength;
	    	 barText.setLayoutParams(lp);
	    	        
	    }  

	    public void InitViewPager(){  
	        mPager = (ViewPager)findViewById(R.id.viewpager);  
	        fragmentList = new ArrayList<Fragment>();  
	        Fragment btFragment= new ButtonFragment();  
	        Fragment secondFragment = TestFragment.newInstance("this is second fragment");  
	        Fragment thirdFragment = TestFragment.newInstance("this is third fragment");  
	        Fragment fourthFragment = TestFragment.newInstance("this is fourth fragment");  
	        fragmentList.add(btFragment);  
	        fragmentList.add(secondFragment);  
	        fragmentList.add(thirdFragment);  
	        fragmentList.add(fourthFragment);  
	          	        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
	        mPager.setCurrentItem(0);
	        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	    }  
	  
	      
	    public class MyOnPageChangeListener implements OnPageChangeListener{  
	          
	        @Override  
	        public void onPageScrolled(int arg0, float arg1, int arg2) {  
	            // TODO Auto-generated method stub
                LayoutParams ll = (LayoutParams) barText
                        .getLayoutParams();
                
                if(currIndex == arg0){
                	 ll.leftMargin = (int) (currIndex * barText.getWidth() + arg1
                             * barText.getWidth());
                }else if(currIndex > arg0){
                	 ll.leftMargin = (int) (currIndex * barText.getWidth() - (1 - arg1)* barText.getWidth());
                }
                barText.setLayoutParams(ll);
	        }  
	          
	        @Override  
	        public void onPageScrollStateChanged(int arg0) {  
	            // TODO Auto-generated method stub  
	              
	        }  
	          
	        @Override  
	        public void onPageSelected(int arg0) {  
	            // TODO Auto-generated method stub  
	            currIndex = arg0;   
	            int i = currIndex + 1;  
	            Toast.makeText(MainActivity.this, "��ѡ���˵�"+i+"��ҳ��", Toast.LENGTH_SHORT).show();  
	        }  
	    }  
	  
	  
}
