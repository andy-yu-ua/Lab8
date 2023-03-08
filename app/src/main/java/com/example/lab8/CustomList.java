package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This count the # of cities in the list
     * @return
     * This is the # of cities in the list
     */
    public int countCities() {
        return cities.size();
    }


    /**
     * This tests if a city is in the list
     * @param city
     * This is the city to test
     * @return
     * Return if the city is in the list
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * This delete the city in the list, if not in the list, throw an exception
     * @param city
     * This is the city to delete
     */
    public void delete(City city) {
        if (hasCity(city)) {
            this.cities.remove(city);
        } else {
            throw new UnsupportedOperationException("City was not found in the list.");
        }
    }
}
