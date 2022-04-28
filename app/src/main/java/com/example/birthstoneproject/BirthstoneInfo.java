package com.example.birthstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class BirthstoneInfo extends AppCompatActivity {
    ArrayList<String> monthLinkArrayList =new ArrayList<String>();
    ArrayList<String> monthArrayList =new ArrayList<String>();
    ArrayList<String> stoneArrayList =new ArrayList<String>();
    TextView birthstone,about_month;
    int selectedMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        birthstone=findViewById(R.id.birthstone);
        about_month=findViewById(R.id.about_month);
        addMonthsLinks();
        saveStoneNameInList();
        addMonthList();
        birthstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = monthLinkArrayList.get(selectedMonth);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        selectedMonth =   getIntent().getIntExtra("selectedMonth",-1);
        checkBirthStone();
        super.onStart();
    }
    public void checkBirthStone(){
        //selectedMonth
        birthstone.setText(stoneArrayList.get(selectedMonth));
        about_month.setText(monthArrayList.get(selectedMonth));

    }
    public void addMonthList(){

        monthArrayList.add("January derives its name from a Deity, Janus. This attention-grabbing figure from mythology has two faces, and not in the negative connotation of that description we think of today.");
        monthArrayList.add("Moving into February, we have a month dedicated to purification. The Roman festival of Februa, also called Lupercalia, began as a means of insuring health and fertility, banishing and protecting the region from malevolent entities and cleansing the city.");
        monthArrayList.add("March was named after a God of war, Mars (also known in Greece as Ares). Among the regional Gods, Mars was second only to Jupiter. As a military Deity he reigned supreme.");

        monthArrayList.add("Starting off on a lovely note, April is Aphrodite’s month. She was the goddess of all things beautiful in Greece as well as a governess of love and romance.");
        monthArrayList.add("May’s name comes from the Italian Goddess of spring, Maia, who was the wife of Vulcan. Maia is the eldest of the 7 sisters that comprise the Pleiades.");
        monthArrayList.add("From Maia we move toward the Goddess Juno, the wife (and sister) of Jupiter for whom June was named.She was the most important Goddess in Rome.");

        monthArrayList.add("The 3rd quarter of the Wheel of the Year begins with July. The month’s name was a nod toward, and in honor of, Julius Caesar.");
        monthArrayList.add("August also had another Roman leader for whom its named, Augustus Caesar. While not really being the “fighting type” Augustus managed to expand the Roman Empire into Egypt, Spain and the Balkans.");
        monthArrayList.add("By September, creativity surrounding the months’ names waned. September comes from a word meaning seven, because it was originally the 7th month on the calendar. ");

        monthArrayList.add("The name October proves no more exciting than September. It means simply the 8th month. You might consider this number 8 (business & career) as an alternative to 10 (Karma and the Law of Return) in Numerology when investigating this month’s energies. ");
        monthArrayList.add(" Numerology tells us the sacred Number nine focuses on perception and fresh starts, while it’s modern number eleven, a Master Number, symbolizes faith and instinct.");
        monthArrayList.add("Finally we wrap up the year with December, “deco” the tenth month on the Julian calendar. In Numerology 10 reminds us that what we sew, we reap.");


    }
    public void saveStoneNameInList(){
        stoneArrayList.add("Garnet");
        stoneArrayList.add("Amethyst");
        stoneArrayList.add("Aquamarine");
        stoneArrayList.add("Diamond");

        stoneArrayList.add("Emerald");
        stoneArrayList.add("Alexandrite");
        stoneArrayList.add("Ruby");

        stoneArrayList.add("Peridot \n Spinel");
        stoneArrayList.add("Sapphire");
        stoneArrayList.add("Tourmaline");

        stoneArrayList.add("Golden Topaz \n Citrine");
        stoneArrayList.add("Blue Zircon \n Blue Topaz \nTanzanite ");
    }
    public void addMonthsLinks(){

        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#jan");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#feb");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#mar");

        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#apr");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#may");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#jun");

        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#jul");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#aug");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#sep");

        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#oct");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#nov");
        monthLinkArrayList.add("https://www.gemsociety.org/article/birthstone-chart/#dec");


    }

}