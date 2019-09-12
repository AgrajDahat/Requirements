package com.xyz.requi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.xyz.requi.model.Country;
import org.springframework.stereotype.Repository;
 
@Repository
public class CountryDAO {
 
    private static final Map<String, Country> COUNTRIES_MAP = new HashMap<>();
 
    static {
        initDATA();
    }
 
    private static void initDATA() {
 
        Country vn = new Country("JAVA", "JAVA");
        Country en = new Country(".NET", ".NET");
        Country fr = new Country("PYTHON", "PYTHON");
        Country us = new Country("Angular", "Angular");
        Country ru = new Country("Full_Stack", "Full Stack");
 
        COUNTRIES_MAP.put(vn.getStackCode(), vn);
        COUNTRIES_MAP.put(en.getStackCode(), en);
        COUNTRIES_MAP.put(fr.getStackCode(), fr);
        COUNTRIES_MAP.put(us.getStackCode(), us);
        COUNTRIES_MAP.put(ru.getStackCode(), ru);
    }
 
    public Country findCountryByCode(String stackCode) {
        return COUNTRIES_MAP.get(stackCode);
    }
 
    public List<Country> getCountries() {
        List<Country> list = new ArrayList<>();
        list.addAll(COUNTRIES_MAP.values());
        return list;
    }
 
}
