package com.superg.babymemory;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.superg.babymemory.fragments.EventFragment;
import com.superg.babymemory.fragments.ImageFragment;
import com.superg.babymemory.fragments.NearbyFragment;
import com.superg.babymemory.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private int[] mImageSources = new int[]{R.drawable.event_bg_select, R.drawable.image_bg_select,
            R.drawable.nearby_bg_select, R.drawable.setting_bg_select};
    private String[] mTextArray = new String[]{"Event", "Pictures", "NearBy", "Setting"};
    private Class[] mFragmentArray = new Class[]{EventFragment.class, ImageFragment.class, NearbyFragment.class, SettingFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabHost();
    }

    private void initTabHost() {
        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("Event").setIndicator(getTabItemView(0)), EventFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Pictures").setIndicator(getTabItemView(1)), ImageFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Nearby").setIndicator(getTabItemView(2)), NearbyFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Setting").setIndicator(getTabItemView(3)), SettingFragment.class, null);

    }

    private View getTabItemView(int index) {
        View view = mInflater.inflate(R.layout.tab_item_view, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(mImageSources[index]);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(mTextArray[index]);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
