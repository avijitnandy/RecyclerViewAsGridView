package com.w3xplorers.recyclerviewasgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    //Image links
    private final String android_image_urls[] = {
            "https://vignette2.wikia.nocookie.net/peridot0/images/2/28/Pink_frosted_sprinkled_donut.png",
            "http://vignette4.wikia.nocookie.net/logopedia/images/d/d8/Andorid-2.3-Gingerbread-logo.png",
            "http://www.pngmart.com/files/4/Android-PNG-Photos.png",
            "http://goodereader.com/blog/uploads/images/android-froyo.png",
            "https://vignette3.wikia.nocookie.net/logopedia/images/2/24/Android_honeycomb.png",
            "http://wpmedia.windsorstar.com/2011/12/android_ice_cream_sandwich.png",
            "http://www.gamefromscratch.com/image.axd?picture=jellybeen.png",
            "http://www.jivi.in/jsp29/Kitkat.png",
            "https://www.xda-developers.com/wp-content/uploads/2015/09/NBAYK8V.png",
            "http://iskin.tooliphone.net/themes/3010/2213/preview-256.png"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.gridRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList prepareData(){
        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

}
