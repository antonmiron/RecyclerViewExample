# RecyclerViewExample

Example of using DataBinding + MVVM with RecyclerView

<img src="example.gif" width="400px"/>

## Usage
Add in Gradle
```Java
dataBinding{
        enabled=true
    }
```
and in dependencies
```Java
implementation 'android.arch.lifecycle:extensions:1.1.1'
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:cardview-v7:28.0.0'
```
for usage RecyclerView use code below ('Person' for example)
```Java
personAdapter = new RecyclerBindingAdapter<Person>(R.layout.activity_recycler_item, BR.person,personList);
        personRecyclerConfig.setAdapter(personAdapter);
        personRecyclerConfig.setLayoutManager(new LinearLayoutManager(activity));
```
Where layout is holder layout, BR.person is variable in xml file and list of variables
