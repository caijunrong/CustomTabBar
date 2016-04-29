package com.caijunrong.customtabbar;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.caijunrong.customtabbar.adapter.HomeTabAdapter;
import com.caijunrong.customtabbar.view.FragmentCart;
import com.caijunrong.customtabbar.view.FragmentCenter;
import com.caijunrong.customtabbar.view.FragmentHome;
import com.caijunrong.customtabbar.view.FragmentSearch;
import com.caijunrong.customtabbar.view.FragmentShareOrder;
import com.caijunrong.customtabbar.view.viewpager.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ImageView> imageViewList;
    private List<TextView> textViewList;
    private List<TextView> unReadMsgList;
    private  List<Fragment> fragmentList;

    private int index = 0;//再次点击的id
    private int currentTabIndex; //当前显示的id
    private HomeTabAdapter homeTabAdapter;
    private NoScrollViewPager viewPager_main;

    private FragmentHome fragmentHome;
    private FragmentSearch fragmentSearch;
    private FragmentShareOrder fragmentShareOrder;
    private FragmentCart fragmentCart;
    private FragmentCenter fragmentCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到每个view
        findView();

        homeTabAdapter = new HomeTabAdapter(getSupportFragmentManager(), fragmentList, viewPager_main);
        //最多5页
        viewPager_main.setOffscreenPageLimit(5);
        viewPager_main.setAdapter(homeTabAdapter);

        //更新第一个view的颜色为红色
        updataUI(0);
    }

    //初始化各种view
    private void findView(){

        imageViewList = new ArrayList<ImageView>();
        imageViewList.add((ImageView) findViewById(R.id.ib_home));
        imageViewList.add((ImageView) findViewById(R.id.ib_search));
        imageViewList.add((ImageView) findViewById(R.id.ib_share_order));
        imageViewList.add((ImageView) findViewById(R.id.ib_cart));
        imageViewList.add((ImageView) findViewById(R.id.ib_center));

        textViewList = new ArrayList<TextView>();
        textViewList.add((TextView) findViewById(R.id.tv_home));
        textViewList.add((TextView) findViewById(R.id.tv_search));
        textViewList.add((TextView) findViewById(R.id.tv_share_order));
        textViewList.add((TextView) findViewById(R.id.tv_cart));
        textViewList.add((TextView) findViewById(R.id.tv_center));

        unReadMsgList = new ArrayList<TextView>();
        unReadMsgList.add((TextView) findViewById(R.id.unread_home));
        unReadMsgList.add((TextView) findViewById(R.id.unread_search));
        unReadMsgList.add((TextView) findViewById(R.id.unread_share_order));
        unReadMsgList.add((TextView) findViewById(R.id.unread_cart));
        unReadMsgList.add((TextView) findViewById(R.id.unread_center));

        fragmentList = new ArrayList<Fragment>();
        fragmentHome = new FragmentHome();
        fragmentSearch = new FragmentSearch();
        fragmentShareOrder = new FragmentShareOrder();
        fragmentCart = new FragmentCart();
        fragmentCenter = new FragmentCenter();

        fragmentList.add(fragmentHome);
        fragmentList.add(fragmentSearch);
        fragmentList.add(fragmentShareOrder);
        fragmentList.add(fragmentCart);
        fragmentList.add(fragmentCenter);

        viewPager_main = (NoScrollViewPager)findViewById(R.id.viewpager_main_v2);
    }

    //底部按钮点击触发
    public void onTabClicked(View view){

        switch (view.getId()){
            case R.id.re_home:
                index = 0;
                break;
            case R.id.re_search:
                index = 1;
                break;
            case R.id.re_share_order:
                index = 2;
                break;
            case R.id.re_cart:
                index = 3;
                break;
            case R.id.re_center:
                index = 4;
                break;
        }

        updataUI(index);
    }

    //更新UI
    private void updataUI(int index){

        if (currentTabIndex != index && index != 3){
            TextView tv =  unReadMsgList.get(index);
            tv.setText("0");
            tv.setVisibility(View.INVISIBLE);
        }

        imageViewList.get(currentTabIndex).setSelected(false);
        imageViewList.get(index).setSelected(true);

        textViewList.get(currentTabIndex).setTextColor(this.getResources().getColor(R.color.colorDarkGrey));
        textViewList.get(index).setTextColor(this.getResources().getColor(R.color.barcolor));

        currentTabIndex = index;

        //点击事件之后，将fragment换到另一页
        homeTabAdapter.showFragmentWithID(index);
    }
}
