package com.example.recyclerviewexample.viewmodels;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.recyclerviewexample.BR;
import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.models.Person;
import com.example.recyclerviewexample.tools.BindingViewModel;
import com.example.recyclerviewexample.tools.RecyclerBindingAdapter;
import com.example.recyclerviewexample.tools.RecyclerConfiguration;
import com.example.recyclerviewexample.views.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonViewModel extends BindingViewModel {
    private RecyclerBindingAdapter<Person> personAdapter;
    private RecyclerConfiguration personRecyclerConfig = new RecyclerConfiguration();

    /*Getters, Setters*/
    public RecyclerConfiguration getPersonRecyclerConfig() {
        return personRecyclerConfig;
    }
    public void setPersonRecyclerConfig(RecyclerConfiguration personRecyclerConfig) {
        this.personRecyclerConfig = personRecyclerConfig;
    }


    @Override
    public void setActivityType(Activity activity) {
        if(activity instanceof MainActivity)
            setMainActivitySettings(activity);
    }

    /*For Example*/
    private void setMainActivitySettings(final Activity activity){
        List<Person> personList = generatePersonList();

        personAdapter = new RecyclerBindingAdapter<Person>(R.layout.activity_recycler_item, BR.person,personList);
        personRecyclerConfig.setAdapter(personAdapter);
        personRecyclerConfig.setLayoutManager(new LinearLayoutManager(activity));

        personAdapter.setOnItemClickListener(new RecyclerBindingAdapter.OnItemClickListener<Person>() {
            @Override
            public void onItemClick(int position, Person item) {
                Toast.makeText(activity,R.string.click_message,Toast.LENGTH_SHORT).show();
            }
        });
        personAdapter.setOnItemLongClickListener(new RecyclerBindingAdapter.OnItemLongClickListener<Person>() {
            @Override
            public void onItemLongClick(int position, Person item) {
                Toast.makeText(activity,R.string.long_click_message,Toast.LENGTH_SHORT).show();
            }
        });

    }
    private List<Person> generatePersonList(){
        String[] firstNames = new String[5];
        String[] lastNames = new String[5];
        Random random = new Random();
        List<Person> people = new ArrayList<>();

        /*First names*/
        firstNames[0]="Anton";
        firstNames[1]="Ivan";
        firstNames[2]="Andrey";
        firstNames[3]="Pavel";
        firstNames[4]="Vladimir";

        /*Last names*/
        lastNames[0]="Petrov";
        lastNames[1]="Ivanov";
        lastNames[2]="Sergeev";
        lastNames[3]="Putin";
        lastNames[4]="Sidorov";

        for(int i=0;i<20;i++){
            StringBuilder name = new StringBuilder(firstNames[random.nextInt(5)]).append(" ");
            name.append(lastNames[random.nextInt(5)]);

            Person person = new Person();
            person.setName(name.toString());
            person.setAge(random.nextInt(70));

            people.add(person);
        }
        return people;
    }
}
