package cn.faisco.jenkin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenkins Chen on 2015/10/26.
 */
public class MainActivity extends Activity implements View.OnClickListener {


    private ViewPager mViewPager;
    private PagerAdapter mAdpater;
    private List<View> mViews = new ArrayList<View>();


    private LinearLayout mTab1;
    private LinearLayout mTab2;
    private LinearLayout mTab3;
    private LinearLayout mTab4;
    private LinearLayout mTab5;

    private ImageButton ib1;
    private ImageButton ib2;
    private ImageButton ib3;
    private ImageButton ib4;
    private ImageButton ib5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        initView();
        initEvents();

    }

    private void initEvents() {
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        ib1.setImageResource(R.drawable.abcde1);
                        break;
                    case 1:
                        ib2.setImageResource(R.drawable.abcde2);
                        break;
                    case 2:
                        ib3.setImageResource(R.drawable.abcde3);
                        break;
                    case 3:
                        ib4.setImageResource(R.drawable.abcde4);
                        break;
                    case 4:
                        ib5.setImageResource(R.drawable.abcde5);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTab1 = (LinearLayout) findViewById(R.id.tab_1);
        mTab2 = (LinearLayout) findViewById(R.id.tab_2);
        mTab3 = (LinearLayout) findViewById(R.id.tab_3);
        mTab4 = (LinearLayout) findViewById(R.id.tab_4);
        mTab5 = (LinearLayout) findViewById(R.id.tab_5);

        ib1 = (ImageButton) findViewById(R.id.img_1);
        ib2 = (ImageButton) findViewById(R.id.img_2);
        ib3 = (ImageButton) findViewById(R.id.img_3);
        ib4 = (ImageButton) findViewById(R.id.img_4);
        ib5 = (ImageButton) findViewById(R.id.img_5);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab1 = mInflater.inflate(R.layout.tab1, null);
        View tab2 = mInflater.inflate(R.layout.tab2, null);
        View tab3 = mInflater.inflate(R.layout.tab3, null);
        View tab4 = mInflater.inflate(R.layout.tab4, null);
        View tab5 = mInflater.inflate(R.layout.tab5, null);

        mViews.add(tab1);
        mViews.add(tab2);
        mViews.add(tab3);
        mViews.add(tab4);
        mViews.add(tab5);

        mAdpater = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

        mViewPager.setAdapter(mAdpater);

    }

    @Override
    public void onClick(View v) {


        resetImg();
        switch (v.getId()) {
            case R.id.img_1:
                mViewPager.setCurrentItem(0);
                ib1.setImageResource(R.drawable.abcde1);
                break;
            case R.id.img_2:
                mViewPager.setCurrentItem(1);
                ib2.setImageResource(R.drawable.abcde2);
                break;
            case R.id.img_3:
                mViewPager.setCurrentItem(2);
                ib3.setImageResource(R.drawable.abcde3);
                break;
            case R.id.img_4:
                mViewPager.setCurrentItem(3);
                ib4.setImageResource(R.drawable.abcde4);
                break;
            case R.id.img_5:
                mViewPager.setCurrentItem(4);
                ib5.setImageResource(R.drawable.abcde5);
                break;
        }
    }

    /**
     * 将所有的图片切换为暗色的
     */
    private void resetImg() {
        ib1.setImageResource(R.drawable.abcde10);
        ib2.setImageResource(R.drawable.abcde20);
        ib3.setImageResource(R.drawable.abcde30);
        ib4.setImageResource(R.drawable.abcde40);
        ib5.setImageResource(R.drawable.abcde50);
    }
}
