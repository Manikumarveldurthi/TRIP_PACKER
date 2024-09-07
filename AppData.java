package com.example.trip_packer.Data;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.trip_packer.Database.RoomDB;
import com.example.trip_packer.Models.Items;
import com.example.trip_packer.constants.myconstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB database;
    Context context;
    String category;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 3;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;
        this.context = context;

    }

    public List<Items> getBasicData() {
        category = "Basic Needs";
        List<Items> basicItem = new ArrayList<Items>();
        basicItem.clear();
        basicItem.add(new Items("Visa", category, false));
        basicItem.add(new Items("Passport", category, false));
        basicItem.add(new Items("Tickets", category, false));
        basicItem.add(new Items("Wallet", category, false));
        basicItem.add(new Items("Driving License", category, false));
        basicItem.add(new Items("Currency", category, false));
        basicItem.add(new Items("House key", category, false));
        basicItem.add(new Items("Book", category, false));
        basicItem.add(new Items("Travel pillow", category, false));
        basicItem.add(new Items("Eye patch", category, false));
        basicItem.add(new Items("Umbrella", category, false));
        basicItem.add(new Items("Note Book", category, false));

        return basicItem;
    }
    public List<Items> getPersonalcareData() {
        category = "Personal Care";
        List<Items> personalItem = new ArrayList<Items>();
        personalItem.clear();
        personalItem.add(new Items("Tooth brush", category, false));
        personalItem.add(new Items("Tooth paste", category, false));
        personalItem.add(new Items("Floss", category, false));
        personalItem.add(new Items("MouthWash", category, false));
        personalItem.add(new Items("Shaving cream", category, false));
        personalItem.add(new Items("Razor blade", category, false));
        personalItem.add(new Items("Soap", category, false));
        personalItem.add(new Items("fiber", category, false));
        personalItem.add(new Items("shampoo", category, false));
        personalItem.add(new Items("Hair conditioner", category, false));
        personalItem.add(new Items("Brush", category, false));
        personalItem.add(new Items("Comb", category, false));
        personalItem.add(new Items("Hair dryer", category, false));
        personalItem.add(new Items("Curling iron", category, false));
        personalItem.add(new Items("Hair moulder", category, false));
        personalItem.add(new Items("Hairclip", category, false));
        personalItem.add(new Items("Moisturizer", category, false));
        personalItem.add(new Items("lip cream", category, false));
        personalItem.add(new Items("contact lens", category, false));
        personalItem.add(new Items("Perfume", category, false));
        personalItem.add(new Items("Deodorant", category, false));
        personalItem.add(new Items("Makeup remover", category, false));
        personalItem.add(new Items("Wet wipes", category, false));
        personalItem.add(new Items("pad", category, false));
        personalItem.add(new Items("ear stick", category, false));
        personalItem.add(new Items("Cotton", category, false));
        personalItem.add(new Items("nail polish", category, false));
        personalItem.add(new Items("nail polish remover ", category, false));
        personalItem.add(new Items("tweezers", category, false));
        personalItem.add(new Items("nail files", category, false));
        personalItem.add(new Items("sun tan cream", category, false));



        return personalItem;
    }

    public List<Items> getClothingData() {
        category = "Clothing";
        List<Items> clothingItem = new ArrayList<Items>();
        clothingItem.clear();
        clothingItem.add(new Items("stockings", category, false));
        clothingItem.add(new Items("underwear", category, false));
        clothingItem.add(new Items("pajamas", category, false));
        clothingItem.add(new Items("t-shirts", category, false));
        clothingItem.add(new Items("casual dress", category, false));
        clothingItem.add(new Items("evening dress", category, false));
        clothingItem.add(new Items("shirt", category, false));
        clothingItem.add(new Items("cardigan", category, false));
        clothingItem.add(new Items("vest", category, false));
        clothingItem.add(new Items("jacket", category, false));
        clothingItem.add(new Items("skirt", category, false));
        clothingItem.add(new Items("trousers", category, false));
        clothingItem.add(new Items("jeans", category, false));
        clothingItem.add(new Items("shorts", category, false));
        clothingItem.add(new Items("suit", category, false));
        clothingItem.add(new Items("coat", category, false));
        clothingItem.add(new Items("rain coat", category, false));
        clothingItem.add(new Items("gloves", category, false));
        clothingItem.add(new Items("hat", category, false));
        clothingItem.add(new Items("scarf", category, false));
        clothingItem.add(new Items("bikini", category, false));
        clothingItem.add(new Items("belt", category, false));
        clothingItem.add(new Items("slipper", category, false));
        clothingItem.add(new Items("sneakers", category, false));
        clothingItem.add(new Items("casual shoes", category, false));
        clothingItem.add(new Items("heeled shoes", category, false));
        clothingItem.add(new Items("sports wear", category, false));
        return clothingItem;
    }

    public List<Items> getBabyNeedsData() {
        category = "Baby Needs";
        List<Items> babyneedsItem = new ArrayList<Items>();
        babyneedsItem.clear();
        babyneedsItem.add(new Items("snapsuit", category, false));
        babyneedsItem.add(new Items("outfit", category, false));
        babyneedsItem.add(new Items("jumpsuit", category, false));
        babyneedsItem.add(new Items("baby shocks", category, false));
        babyneedsItem.add(new Items("baby hat", category, false));
        babyneedsItem.add(new Items("baby pajamas", category, false));
        babyneedsItem.add(new Items("baby bath towel", category, false));
        babyneedsItem.add(new Items("muslin", category, false));
        babyneedsItem.add(new Items("blanket", category, false));
        babyneedsItem.add(new Items("dribble bibs", category, false));
        babyneedsItem.add(new Items("baby laundry detergent", category, false));
        babyneedsItem.add(new Items("baby water bottles", category, false));
        babyneedsItem.add(new Items("baby food thermos", category, false));
        babyneedsItem.add(new Items("baby bottle brushes", category, false));
        babyneedsItem.add(new Items("breast feeding cover", category, false));
        babyneedsItem.add(new Items("breast pump", category, false));
        babyneedsItem.add(new Items("water bottle", category, false));
        babyneedsItem.add(new Items("storage container", category, false));
        babyneedsItem.add(new Items("baby food spoon", category, false));
        babyneedsItem.add(new Items("high chairs", category, false));
        babyneedsItem.add(new Items("Diaper", category, false));
        babyneedsItem.add(new Items("wet wipes", category, false));
        babyneedsItem.add(new Items("baby cotton", category, false));
        babyneedsItem.add(new Items("baby care cover", category, false));
        babyneedsItem.add(new Items("baby shampoo", category, false));
        babyneedsItem.add(new Items("baby soap", category, false));
        babyneedsItem.add(new Items("baby nail scissors", category, false));
        babyneedsItem.add(new Items(" baby body moisturizer", category, false));
        babyneedsItem.add(new Items("potty", category, false));
        babyneedsItem.add(new Items("Diaper rash cream", category, false));
        babyneedsItem.add(new Items("serum physiological", category, false));
        babyneedsItem.add(new Items("nasal aspirator", category, false));
        babyneedsItem.add(new Items("fly repellent lotion", category, false));
        babyneedsItem.add(new Items("pyrometer", category, false));
        babyneedsItem.add(new Items("antipyretic syrup", category, false));
        babyneedsItem.add(new Items("baby back pack ", category, false));
        babyneedsItem.add(new Items("probiotic power", category, false));
        babyneedsItem.add(new Items("stroller", category, false));
        babyneedsItem.add(new Items("baby carrier", category, false));
        babyneedsItem.add(new Items("toys ", category, false));
        babyneedsItem.add(new Items("teether", category, false));
        babyneedsItem.add(new Items("playpen", category, false));
        babyneedsItem.add(new Items("baby radio", category, false));
        babyneedsItem.add(new Items("non slip sea shoes", category, false));
        babyneedsItem.add(new Items("baby sunglasses", category, false));


        return babyneedsItem;
    }

    public List<Items> getHealthData() {
        category = "Health";
        List<Items> healthItem = new ArrayList<Items>();
        healthItem.clear();
        healthItem.add(new Items("aspirin", category, false));
        healthItem.add(new Items("drugs used", category, false));
        healthItem.add(new Items("vitamins used", category, false));
        healthItem.add(new Items("lens solutions", category, false));
        healthItem.add(new Items("condom", category, false));
        healthItem.add(new Items("hot water bag", category, false));
        healthItem.add(new Items("tincture of iodine", category, false));
        healthItem.add(new Items("adhesive plaster", category, false));
        healthItem.add(new Items("first aid kit", category, false));
        healthItem.add(new Items("replacement  lens", category, false));
        healthItem.add(new Items("pain reliever", category, false));
        healthItem.add(new Items("fever reducer", category, false));
        healthItem.add(new Items("diarrhea stopper", category, false));
        healthItem.add(new Items("pain relieve spray", category, false));



        return healthItem;
    }

    public List<Items> getTechnologyData() {
        category = "Technology";
        List<Items> technologyItem = new ArrayList<Items>();
        technologyItem.clear();
        technologyItem.add(new Items("mobile phone", category, false));
        technologyItem.add(new Items("phone cover", category, false));
        technologyItem.add(new Items("E book reader", category, false));
        technologyItem.add(new Items("camera", category, false));
        technologyItem.add(new Items("camera charger", category, false));
        technologyItem.add(new Items("portable speaker", category, false));
        technologyItem.add(new Items("ipad", category, false));
        technologyItem.add(new Items("headphone", category, false));
        technologyItem.add(new Items("laptop", category, false));
        technologyItem.add(new Items("laptop charger", category, false));
        technologyItem.add(new Items("mouse", category, false));
        technologyItem.add(new Items("extension cable", category, false));
        technologyItem.add(new Items("data transfer cable", category, false));
        technologyItem.add(new Items("battery", category, false));
        technologyItem.add(new Items("power bank", category, false));
        technologyItem.add(new Items("DVD player", category, false));
        technologyItem.add(new Items("flash light", category, false));
        technologyItem.add(new Items("MP3 player", category, false));
        technologyItem.add(new Items("MP3 player charger", category, false));
        technologyItem.add(new Items("phone charger", category, false));
        technologyItem.add(new Items("voltage adapter", category, false));
        technologyItem.add(new Items("SD card", category, false));



        return technologyItem;
    }

    public List<Items> getFoodData() {
        category = "Food";
        List<Items> foodItem = new ArrayList<Items>();
        foodItem.clear();
        foodItem.add(new Items("snacks", category, false));
        foodItem.add(new Items("sandwich", category, false));
        foodItem.add(new Items("juices", category, false));
        foodItem.add(new Items("tea bags", category, false));
        foodItem.add(new Items("coffee", category, false));
        foodItem.add(new Items("water bottle", category, false));
        foodItem.add(new Items("thermos", category, false));
        foodItem.add(new Items("chips", category, false));
        foodItem.add(new Items("baby food", category, false));


        return foodItem;
    }

    public List<Items> getBeachsuppliesData() {
        category = "Beach Supplies";
        List<Items> beachsuppliesItem = new ArrayList<Items>();
        beachsuppliesItem.clear();
        beachsuppliesItem.add(new Items("sea glasses", category, false));
        beachsuppliesItem.add(new Items("sea bed", category, false));
        beachsuppliesItem.add(new Items("sun tan cream", category, false));
        beachsuppliesItem.add(new Items("beach  umbrella", category, false));
        beachsuppliesItem.add(new Items("swim fins", category, false));
        beachsuppliesItem.add(new Items("beach slippers", category, false));
        beachsuppliesItem.add(new Items("sunbed", category, false));
        beachsuppliesItem.add(new Items("snorkel", category, false));
        beachsuppliesItem.add(new Items("waterproof clock", category, false));



        return beachsuppliesItem;
    }

    public List<Items> getcarsuppliesData() {
        category = "Car Supplies";
        List<Items> carsuppliesItem = new ArrayList<Items>();
        carsuppliesItem.clear();
        carsuppliesItem.add(new Items("pump", category, false));
        carsuppliesItem.add(new Items("car jack", category, false));
        carsuppliesItem.add(new Items("spare car key", category, false));
        carsuppliesItem.add(new Items("accident record set", category, false));
        carsuppliesItem.add(new Items("petrol tank bottle", category, false));
        carsuppliesItem.add(new Items("car cover", category, false));
        carsuppliesItem.add(new Items("car charger", category, false));
        carsuppliesItem.add(new Items("window sun shades", category, false));
        carsuppliesItem.add(new Items("extra wheels", category, false));


        return carsuppliesItem;
    }

    public List<Items> getNeedsData() {
        category = "Needs";
        List<Items> needsItem = new ArrayList<Items>();
        needsItem.clear();
        needsItem.add(new Items("Backpack", category, false));
        needsItem.add(new Items("daily bags", category, false));
        needsItem.add(new Items("laundry bag", category, false));
        needsItem.add(new Items("swimming kit", category, false));
        needsItem.add(new Items("travel lock", category, false));
        needsItem.add(new Items("luggage tag", category, false));
        needsItem.add(new Items("magazine", category, false));
        needsItem.add(new Items("sports equipment", category, false));
        needsItem.add(new Items("important numbers", category, false));

        return needsItem;
    }



    public List<List<Items>> getAllData() {
        List<List<Items>> listofAllItems = new ArrayList<>();
        listofAllItems.clear();
        listofAllItems.add(getBasicData());
        listofAllItems.add(getClothingData());
        listofAllItems.add(getPersonalcareData());
        listofAllItems.add(getBabyNeedsData());
        listofAllItems.add(getHealthData());
        listofAllItems.add(getTechnologyData());
        listofAllItems.add(getFoodData());
        listofAllItems.add(getBeachsuppliesData());
        listofAllItems.add(getcarsuppliesData());
        listofAllItems.add(getNeedsData());
        return listofAllItems;

    }

    public void persistAllData() {
        List<List<Items>> listofAllItems = getAllData();
        for (List<Items> list : listofAllItems) {
            for (Items items : list) {
                database.mainDao().saveItem(items);
            }
        }
        System.out.println("DATA ADDED");
    }


    public void persistDataByCtaegory(String category,Boolean onlydelete)

    {
        try{
            List<Items>list=deleteAndGetlistByCatagory(category, onlydelete);
            if(!onlydelete)
            {
             for(Items item :list)
             {
                 database.mainDao().saveItem(item);
             }
                Toast.makeText(context, category+ "Reset successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(context, category + "Reset successfully", Toast.LENGTH_SHORT).show();
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
            Toast.makeText(context, "something went worng", Toast.LENGTH_SHORT).show();
        }
    }
    private List<Items> deleteAndGetlistByCatagory(String category, Boolean onlyDelete) {
        if (onlyDelete) {
            database.mainDao().deleteAllCategoryAndAddedBy(category,myconstants.SYSTEM_SMALL);

        } else {
database.mainDao().deleteAllBycategory(category);
        }

        switch (category)
        {
            case myconstants.BASIC_NEEDS_CAMEL_CASE:
                return  getBasicData();

            case myconstants.CLOTHING_CAMEL_CASE:
                return  getClothingData();

            case myconstants.PERSONAL_CARE_CAMEL_CASE:
                return  getPersonalcareData();

            case myconstants.BABY_NEEDS_CAMEL_CASE:
                return  getBabyNeedsData();

            case myconstants.HEALTH_CAMEL_CASE:
                return  getHealthData();

            case myconstants.TECHNOLOGY_CAMEL_CASE:
                return  getTechnologyData();

            case myconstants.FOOD_CAMEL_CASE:
                return  getFoodData();

            case myconstants.BEACH_SUPPLIES_CAMEL_CASE:
                return  getBeachsuppliesData();

            case myconstants.CAR_SUPPLIES_CAMEL_CASE:
                return  getcarsuppliesData();

            case myconstants.NEEDS_CAMEL_CASE:
                return  getNeedsData();

            default:
                return new ArrayList<>();
        }
    }
}

