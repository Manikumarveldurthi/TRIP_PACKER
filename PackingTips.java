package com.example.trip_packer;


import java.util.ArrayList;
import java.util.List;

public class PackingTips {

    public static String getTipForCategoryAndDestination(String category, String destination) {
        String tip = "";


        switch (category.toLowerCase()) {
            case "clothing":
                tip = "Pack suitable clothing for the weather at your destination.";
                break;
            case "toiletries":
                tip = "Remember to pack essential toiletries like toothbrush, toothpaste, and shampoo.";
                break;
            case "electronics":
                tip = "Charge all your electronic devices before packing and bring necessary chargers.";
                break;
            case "footwear":
                tip = "Bring comfortable footwear for your trip.";
                break;
            case "accessories":
                tip = "Don't forget important accessories like sunglasses and hats.";
                break;
            case "medications":
                tip = "If you have any medications, ensure you have enough for the entire trip.";
                break;
            case "documents":
                tip = "Keep important documents like passports and tickets in a secure travel wallet.";
                break;
            case "snacks":
                tip = "Pack some snacks for the journey, especially if you have dietary preferences.";
                break;
            case "books":
                tip = "Bring a good book or e-reader for entertainment during downtime.";
                break;
            case "entertainment":
                tip = "Download music or movies for entertainment during the trip.";
                break;
            case "sunscreen":
                tip = "For destinations with sun, pack sunscreen to protect your skin.";
                break;
            case "travel gadgets":
                tip = "Consider bringing useful travel gadgets like power banks or travel adapters.";
                break;
            default:
                tip = "Consider specific tips for " + category + " based on your destination.";
                break;
        }


        if (destination.toLowerCase().contains("beach")) {
            tip += " Don't forget sunscreen and beachwear.";
        } else if (destination.toLowerCase().contains("mountain")) {
            tip += " Pack warm clothing and hiking gear.";
        } else if (destination.toLowerCase().contains("city")) {
            tip += " Explore local attractions and have a city map handy.";
        } else if (destination.toLowerCase().contains("desert")) {
            tip += " Stay hydrated and bring a hat for sun protection.";
        } else if (destination.toLowerCase().contains("island")) {
            tip += " Pack swimsuits and enjoy water activities.";
        } else if (destination.toLowerCase().contains("ski resort")) {
            tip += " Bundle up with layers and don't forget your skiing equipment.";
        } else if (destination.toLowerCase().contains("cruise")) {
            tip += " Pack formal attire for dinner and swimwear for onboard pools.";
        } else if (destination.toLowerCase().contains("jungle")) {
            tip += " Wear light and breathable clothing, and consider insect repellent.";
        } else if (destination.toLowerCase().contains("historical site")) {
            tip += " Bring comfortable walking shoes and a camera to capture memories.";
        } else if (destination.toLowerCase().contains("national park")) {
            tip += " Plan for outdoor activities and pack a reusable water bottle.";
        } else if (destination.toLowerCase().contains("business trip")) {
            tip += " Pack professional attire and necessary work documents.";
        } else if (destination.toLowerCase().contains("road trip")) {
            tip += " Bring snacks, entertainment, and ensure your vehicle is in good condition.";
        }


        return tip;
    }


    public static List<String> getItemsForDestination(String destination) {
        List<String> items = new ArrayList<>();

        switch (destination.toLowerCase()) {
            case "goa":
                items.add("Sunscreen and after-sun lotion");
                items.add("Beachwear and swimwear");
                items.add("Sunglasses and hat");
                items.add("Flip-flops and sandals");
                items.add("Casual summer clothing");
                items.add("Insect repellent");
                items.add("Portable speaker for beach parties");
                items.add("Waterproof bag for beach trips");
                break;
            case "delhi":
                items.add("Light cotton clothes for summer, warm clothes for winter");
                items.add("Comfortable walking shoes");
                items.add("Pollution mask (especially during winters)");
                items.add("Hat or cap for sun protection");
                items.add("Personal ID and essential documents");
                items.add("Power bank");
                items.add("City map or navigation app");
                items.add("Light snacks and water bottle");
                break;
            // Add cases for other destinations similarly
            case "mumbai":
                items.add("Lightweight clothes");
                items.add("Umbrella or raincoat (during monsoon)");
                items.add("Comfortable footwear");
                items.add("Sunglasses and hat");
                items.add("Local SIM card or roaming plan");
                items.add("Camera or smartphone with good camera");
                items.add("Portable fan or hand fan");
                items.add("Reusable shopping bag");
                break;
            case "jaipur":
                items.add("Light cotton clothes (summer), warm clothes (winter)");
                items.add("Comfortable walking shoes");
                items.add("Hat or cap");
                items.add("Sunglasses");
                items.add("Traditional wear for sightseeing");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Camera with extra memory cards");
                break;
            case "bangalore":
                items.add("Light clothes with a light jacket or sweater");
                items.add("Comfortable walking shoes");
                items.add("Umbrella or raincoat (monsoon)");
                items.add("Power bank");
                items.add("Sunglasses");
                items.add("Light snacks and water bottle");
                items.add("Local map or navigation app");
                items.add("Personal ID and cash");
                break;
            case "kolkata":
                items.add("Light cotton clothes");
                items.add("Umbrella or raincoat (monsoon)");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for cultural events");
                items.add("Camera or smartphone with good camera");
                items.add("Light snacks and water bottle");
                items.add("Local map or navigation app");
                break;
            case "chennai":
                items.add("Light cotton clothes");
                items.add("Umbrella or raincoat (monsoon)");
                items.add("Comfortable footwear");
                items.add("Sunglasses and hat");
                items.add("Beachwear (if visiting Marina Beach)");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Camera or smartphone with good camera");
                break;
            case "hyderabad":
                items.add("Light clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for sightseeing");
                items.add("Power bank");
                items.add("Local SIM card or roaming plan");
                items.add("Light snacks and water bottle");
                items.add("Personal ID and cash");
                break;
            case "agra":
                items.add("Light cotton clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Camera with extra memory cards");
                items.add("Sunscreen and lip balm");
                items.add("Local map or navigation app");
                items.add("Reusable water bottle");
                items.add("Personal ID and cash");
                break;
            case "varanasi":
                items.add("Light cotton clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Camera or smartphone with good camera");
                items.add("Mosquito repellent");
                items.add("Personal ID and cash");
                items.add("Light snacks and water bottle");
                items.add("Local map or navigation app");
                break;
            case "amritsar":
                items.add("Light clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for visiting Golden Temple");
                items.add("Camera with extra memory cards");
                items.add("Power bank");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                break;
            case "shimla":
                items.add("Warm clothes (jackets, sweaters, thermals)");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Camera with extra memory cards");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Power bank");
                break;
            case "manali":
                items.add("Warm clothes (jackets, thermals)");
                items.add("Snow boots");
                items.add("Sunglasses and hat");
                items.add("Camera with extra memory cards");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Power bank");
                break;
            case "udaipur":
                items.add("Light cotton clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for sightseeing");
                items.add("Camera or smartphone with good camera");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                break;
            case "pune":
                items.add("Light clothes with a light jacket or sweater");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Power bank");
                items.add("Camera or smartphone with good camera");
                items.add("Local SIM card or roaming plan");
                items.add("Light snacks and water bottle");
                items.add("Personal ID and cash");
                break;
            case "darjeeling":
                items.add("Warm clothes (jackets, sweaters)");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Camera with extra memory cards");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Power bank");
                break;
            case "mysore":
                items.add("Light cotton clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for sightseeing");
                items.add("Camera or smartphone with good camera");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Light snacks");
                break;
            case "coorg":
                items.add("Light clothes with a light jacket or sweater");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Camera with extra memory cards");
                items.add("Sunscreen and lip balm");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Mosquito repellent");
                break;
            case "pushkar":
                items.add("Light clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Traditional wear for sightseeing");
                items.add("Camera with extra memory cards");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Power bank");
                break;
            case "rishikesh":
                items.add("Light clothes");
                items.add("Comfortable walking shoes");
                items.add("Sunglasses and hat");
                items.add("Mosquito repellent");
                items.add("Camera or smartphone with good camera");
                items.add("Personal ID and cash");
                items.add("Reusable water bottle");
                items.add("Power bank");
                break;
            default:
                items.add("Consider specific items based on your destination.");
                break;
        }

        return items;
    }
}
