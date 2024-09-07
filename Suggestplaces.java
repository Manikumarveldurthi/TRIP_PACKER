package com.example.trip_packer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suggestplaces extends AppCompatActivity {

    private Map<String, List<String>> placeSuggestions;
    private Spinner stateSpinner;
    private ListView placesListView;
    private Button btnSuggestPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestplaces);

        initializePlaceSuggestions();

        stateSpinner = findViewById(R.id.state_spinner);
        placesListView = findViewById(R.id.places_list_view);
        btnSuggestPlaces = findViewById(R.id.btnSuggestPlaces);

        List<String> sortedStates = new ArrayList<>(placeSuggestions.keySet());
        Collections.sort(sortedStates);


        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,sortedStates

        );
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                List<String> places = placeSuggestions.get(selectedState);
                ArrayAdapter<String> placesAdapter = new ArrayAdapter<>(
                        Suggestplaces.this, android.R.layout.simple_list_item_1, places
                );
                placesListView.setAdapter(placesAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPlace = (String) parent.getItemAtPosition(position);
                openBrowserWithSearch(selectedPlace);
            }
        });

        btnSuggestPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedState = stateSpinner.getSelectedItem().toString();
                if (placeSuggestions.containsKey(selectedState)) {
                    List<String> suggestedPlaces = placeSuggestions.get(selectedState);
                    StringBuilder placesString = new StringBuilder();
                    for (String place : suggestedPlaces) {
                        placesString.append(place).append(", ");
                    }
                    placesString.setLength(placesString.length() - 2); // Remove trailing comma and space

                    Toast.makeText(Suggestplaces.this, "Places suggested for " + selectedState + ": " + placesString.toString(), Toast.LENGTH_SHORT).show();
                    openBrowserWithSearch(selectedState);
                } else {
                    Toast.makeText(Suggestplaces.this, "No suggestions for " + selectedState, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initializePlaceSuggestions() {
        placeSuggestions = new HashMap<>();
        placeSuggestions.put("Andhra Pradesh", Arrays.asList("Tirupati", "Visakhapatnam", "Amaravati", "Vijayawada", "Guntur", "Kakinada", "Kurnool", "Nellore", "Rajahmundry", "Kadapa", "Anantapur", "Chittoor", "Eluru", "Vizianagaram", "Tenali", "Proddatur", "Adoni", "Machilipatnam", "Hindupur", "Nandyal", "Ongole", "Tadipatri", "Tenali", "Srikakulam", "Dharmavaram", "Gudivada", "Bhimavaram", "Guntakal", "Narasaraopet", "Bapatla"));
        placeSuggestions.put("Arunachal Pradesh", Arrays.asList("Tawang", "Itanagar", "Ziro", "Bomdila", "Pasighat", "Namsai", "Roing", "Tezu", "Aalo", "Khonsa", "Changlang", "Daporijo", "Yingkiong", "Mechuka", "Tuting", "Anini", "Along", "Rupa", "Naharlagun", "Bhalukpong", "Seppa", "Raga", "Taliha", "Bameng", "Dambuk", "Pangin", "Tirap", "Borduria", "Changlang District", "Hayuliang"));
        placeSuggestions.put("Assam", Arrays.asList("Guwahati", "Kaziranga National Park", "Majuli", "Jorhat", "Tezpur", "Silchar", "Dibrugarh", "Tinsukia", "Nagaon", "Hajo", "Sibsagar", "Goalpara", "Barpeta", "Diphu", "Nalbari", "Mangaldai", "Nagaon", "Karimganj", "Hailakandi", "Dhubri", "Bongaigaon", "Darrang", "Morigaon", "Sonitpur", "Kamrup", "Lakhimpur", "Cachar", "Udalguri", "Golaghat", "Karbi Anglong"));
        placeSuggestions.put("Andaman and Nicobar Islands", Arrays.asList("Cellular Jail", "Radhanagar Beach", "Ross Island", "Barren Island", "Havelock Island", "Neil Island", "Viper Island", "Jolly Buoy Island", "Mount Harriet National Park", "Mahatma Gandhi Marine National Park", "Chidiya Tapu", "Corbyn's Cove Beach", "Anthropological Museum", "Marina Park and Aquarium", "Samudrika Naval Marine Museum", "North Bay Island", "Munda Pahar Beach", "Chatham Saw Mill", "Rajiv Gandhi Water Sports Complex", "Limestone Caves", "Baratang Island", "Wandoor Beach", "Lalaji Bay Beach", "Butler Bay Beach", "Cinque Island", "Red Skin Island", "Lamiya Bay Beach", "Twin Islands", "Tapu Dara", "Chidiya Tapu Beach", "Kalapathar Beach", "Radhanagar Beach", "Elephant Beach"));
        placeSuggestions.put("Bihar", Arrays.asList("Patna", "Bodh Gaya", "Nalanda", "Munger", "Bhagalpur", "Darbhanga", "Purnia", "Bihar Sharif", "Arrah", "Begusarai", "Katihar", "Muzaffarpur", "Chhapra", "Saharsa", "Sasaram", "Hajipur", "Dehri", "Siwan", "Motihari", "Bettiah", "Ramnagar", "Nawada", "Bagaha", "Buxar", "Kishanganj", "Sitamarhi", "Jamalpur", "Dumraon", "Araria", "Forbesganj"));
        placeSuggestions.put("Chhattisgarh", Arrays.asList("Raipur", "Bastar", "Chitrakoot Falls", "Bilaspur", "Durg", "Rajnandgaon", "Korba", "Raigarh", "Ambikapur", "Jagdalpur", "Dhamtari", "Mahasamund", "Jashpur", "Kawardha", "Dantevada", "Bijapur", "Narayanpur", "Sukma", "Bijapur", "Rajim", "Korba", "Bemetara", "Dalli-Rajhara", "Koriya", "Baikunthpur", "Kunkuri", "Ratanpur", "Dongargarh", "Kurud", "Bhatapara"));
        placeSuggestions.put("Chandigarh", Arrays.asList("Rock Garden", "Sukhna Lake", "Rose Garden", "Capitol Complex", "Open Hand Monument", "Chandigarh Museum", "Leisure Valley", "Elante Mall", "Terraced Garden", "Government Museum and Art Gallery", "International Dolls Museum", "Garden of Fragrance", "Chandigarh Botanical Garden", "Thunder Zone Amusement Park", "Sector 17 Market", "Sector 22 Market", "Fun City", "Sri Sri Radha Madhav Temple", "Mohali Cricket Stadium", "ISKCON Chandigarh Temple", "Mansa Devi Temple", "Butterfly Park", "Saketri Shiv Temple", "Cactus Garden", "Punjab Cricket Association IS Bindra Stadium", "Dhanas Lake", "Mahendra Chaudhary Zoological Park", "Topiary Park", "Japanese Garden", "Capitol Complex Tourist Centre", "Sector 34 Market"));
        placeSuggestions.put("Daman and Diu", Arrays.asList("Fort Diu", "Diu Museum", "Naida Caves", "St. Paul’s Church", "Diu Fort", "Gangeshwar Temple", "Jallandhar Beach", "Diu Island", "INS Khukri Memorial", "Diu Lighthouse", "Zampa Gateway", "Diu Zampa Gateway", "Diu Naida Caves", "Naida Caves", "Diu Shell Museum", "St. Thomas Church", "Nagoa Beach", "Diu Lighthouse", "Diu Fort", "Gomtimata Beach", "St. Paul's Church", "Gangeshwar Temple", "Chakratirth Beach", "Zampa Gateway", "Fort Diu", "Panikotha Fort", "Ghoghla Beach", "Diu Museum", "Simbor Beach", "Gomatimata Beach", "Diu Island"));
        placeSuggestions.put("Dadra and Nagar Haveli", Arrays.asList("Silvassa", "Tribal Cultural Museum", "Dudhni Lake", "Vanganga Lake Garden", "Bal Udyan", "Hirwa Van Garden", "Bindrabin", "Nakshatra Garden", "Lion Safari Wildlife Park", "Vasona Lion Safari Park", "Silvassa Vasona Lion Safari Park", "Tapovan Tourist Complex", "Island Garden Dadra Park", "Vanganga Lake Garden", "Nakshatra Garden", "Tribal Museum", "Bal Udyan", "Dudhni Lake Resort", "Satmalia Deer Park", "Khanvel", "Satmalia Deer Park", "Swaaminarayan Temple", "Madhuban Dam", "Bindrabin", "Vasona Lion Safari Park", "Swaaminarayan Temple", "Satmaliya Deer Park", "Madhuban Dam", "Island Garden Park", "Island Garden Dadra Park", "Satmalia Deer Park"));
        placeSuggestions.put("Delhi", Arrays.asList("India Gate", "Red Fort", "Qutub Minar", "Lotus Temple", "Akshardham Temple", "Jantar Mantar", "Rashtrapati Bhavan", "Humayun's Tomb", "Gurudwara Bangla Sahib", "National Zoological Park", "Chandni Chowk", "Connaught Place", "Lodi Gardens", "National Museum", "Nehru Planetarium", "Purana Qila", "Safdarjung's Tomb", "Dilli Haat", "ISKCON Temple", "Shankar's International Dolls Museum", "Tughlaqabad Fort", "Agrasen ki Baoli", "Raj Ghat", "Jamali Kamali Mosque", "Indira Gandhi Memorial Museum", "Hauz Khas Village", "Jama Masjid", "Feroz Shah Kotla Fort", "Nizamuddin Dargah", "Mehrauli Archaeological Park"));
        placeSuggestions.put("Goa", Arrays.asList("Calangute Beach", "Fort Aguada", "Basilica of Bom Jesus", "Panaji", "Margao", "Vasco da Gama", "Mapusa", "Ponda", "Bicholim", "Curchorem", "Sanquelim", "Mormugao", "Quepem", "Canacona", "Sanguem", "Valpoi", "Dabolim", "Tivim", "Cortalim", "Chaudi", "Colva", "Anjuna", "Baga", "Miramar", "Arambol", "Vagator", "Majorda", "Betul", "Agonda", "Benaulim"));
        placeSuggestions.put("Gujarat", Arrays.asList("Ahmedabad", "Somnath Temple", "Rann of Kutch", "Vadodara", "Surat", "Rajkot", "Gandhinagar", "Bhuj", "Jamnagar", "Junagadh", "Anand", "Bharuch", "Porbandar", "Surendranagar", "Godhra", "Vapi", "Navsari", "Veraval", "Mehsana", "Nadiad", "Ankleshwar", "Morbi", "Valsad", "Bhavnagar", "Palanpur", "Dahod", "Botad", "Modasa", "Dang", "Kutch"));
        placeSuggestions.put("Haryana", Arrays.asList("Gurgaon", "Faridabad", "Kurukshetra", "Panipat", "Ambala", "Yamunanagar", "Rohtak", "Hisar", "Karnal", "Sonipat", "Panchkula", "Bhiwani", "Sirsa", "Bahadurgarh", "Jind", "Kaithal", "Rewari", "Palwal", "Fatehabad", "Tohana", "Narnaul", "Hansi", "Nuh", "Sonepat", "Jagadhri", "Ambala Cantonment", "Gohana", "Mewat", "Bhiwani", "Kalka"));
        placeSuggestions.put("Himachal Pradesh", Arrays.asList("Shimla", "Manali", "Dharamshala", "Kullu", "Chamba", "Dalhousie", "Solan", "Mandi", "Kangra", "Palampur", "Una", "Nahan", "Hamirpur", "Bilaspur", "Kaza", "Lahaul", "Kinnaur", "Chail", "Kasauli", "Rampur", "Kalpa", "Keylong", "Barog", "Khajjiar", "Naldehra", "Bharmour", "Jubbal", "Sujanpur", "Jawalamukhi", "Narkanda"));
        placeSuggestions.put("Jharkhand", Arrays.asList("Ranchi", "Jamshedpur", "Hazaribagh", "Dhanbad", "Bokaro", "Deoghar", "Giridih", "Ramgarh", "Chatra", "Dumka", "Medininagar", "Phusro", "Koderma", "Chas", "Gumla", "Daltonganj", "Godda", "Sahibganj", "Lohardaga", "Jamtara", "Pakur", "Hussainabad", "Chaibasa", "Simdega", "Gumla", "Madhupur", "Chandrapura", "Barhi", "Bundu", "Silli"));
        placeSuggestions.put("Karnataka", Arrays.asList("Bangalore", "Mysore", "Hampi", "Mangalore", "Hubli", "Belgaum", "Gulbarga", "Davanagere", "Bellary", "Bijapur", "Tumkur", "Raichur", "Bidar", "Hospet", "Shimoga", "Gadag", "Udupi", "Robertsonpet", "Mandya", "Chitradurga", "Kolar", "Ramanagara", "Haliyal", "Karwar", "Chickmagalur", "Hassan", "Sakleshpur", "Mudhol", "Bagalkot", "Badami"));
        placeSuggestions.put("Kerala", Arrays.asList("Alappuzha Backwaters", "Munnar", "Kovalam", "Kochi", "Thiruvananthapuram", "Kozhikode", "Thrissur", "Kollam", "Palakkad", "Alappuzha", "Kannur", "Kottayam", "Wayanad", "Idukki", "Varkala", "Thekkady", "Kumarakom", "Ponmudi", "Guruvayur", "Nelliampathi", "Cherai", "Athirappilly", "Poovar", "Kumily", "Marari", "Kalpetta", "Kasaragod", "Chalakudy", "Mavelikara", "Muvattupuzha"));
        placeSuggestions.put("Lakshadweep", Arrays.asList("Agatti Island", "Bangaram Atoll", "Kavaratti", "Minicoy Island", "Kalpeni Island", "Kadmat Island", "Thinnakara Island", "Andrott Island", "Amini Island", "Cheriyam Island", "Bitra Island", "Pitti Island", "Suheli Par", "Kalpeni", "Chetlat Island", "Perumal Par", "Kiltan Island", "Amindivi Island", "Suheli Par", "Suheli Cheriyakara", "Suheli Valiyakara", "Suheli Pitti", "Suheli Par", "Suheli Cheriyakara", "Suheli Valiyakara", "Suheli Pitti", "Kadmat Island", "Amini Island", "Kalpeni Island", "Bitra Island", "Kavaratti Island", "Agatti Island"));
        placeSuggestions.put("Madhya Pradesh", Arrays.asList("Bhopal", "Indore", "Khajuraho", "Gwalior", "Jabalpur", "Ujjain", "Sagar", "Ratlam", "Rewa", "Satna", "Dewas", "Murwara", "Singrauli", "Burhanpur", "Khandwa", "Morena", "Bhind", "Guna", "Shivpuri", "Vidisha", "Chhindwara", "Damoh", "Ratlam", "Raisen", "Balaghat", "Mandsaur", "Sehore", "Hoshangabad", "Narsinghpur", "Itarsi"));
        placeSuggestions.put("Maharashtra", Arrays.asList("Mumbai", "Pune", "Ajanta and Ellora Caves", "Nagpur", "Nashik", "Thane", "Pimpri-Chinchwad", "Kalyan-Dombivli", "Vasai-Virar", "Aurangabad", "Solapur", "Bhiwandi", "Amravati", "Nanded", "Kolhapur", "Sangli", "Jalgaon", "Akola", "Latur", "Dhule", "Ahmednagar", "Chandrapur", "Parbhani", "Ichalkaranji", "Jalna", "Bhusawal", "Navi Mumbai", "Panvel", "Satara", "Beed"));
        placeSuggestions.put("Manipur", Arrays.asList("Imphal", "Loktak Lake", "Kangla Fort", "Bishnupur", "Churachandpur", "Thoubal", "Ukhrul", "Kakching", "Tamenglong", "Senapati", "Jiribam", "Chandel", "Kakching", "Tengnoupal", "Chakpikarong", "Kumbi", "Lamka", "Moreh", "Nungba", "Noney", "Noney", "Khongjom", "Chingai", "Mao", "Kamjong", "Sugnu", "Henglep", "Saikul", "Kangpokpi", "Lilong"));
        placeSuggestions.put("Meghalaya", Arrays.asList("Shillong", "Cherrapunji", "Dawki", "Tura", "Jowai", "Nongpoh", "Williamnagar", "Baghmara", "Resubelpara", "Khliehriat", "Amlarem", "Mairang", "Mawkyrwat", "Nongstoin", "Nongpoh", "Mawphlang", "Mawlynnong", "Dawki", "Jakrem", "Nongkhnum Island", "Balpakram", "Siju", "Tyrna", "Smit", "Laitlum Canyons", "Elephant Falls", "Khasi Hills", "Kynshi River", "Lumpongdeng Island", "Sohra"));
        placeSuggestions.put("Mizoram", Arrays.asList("Aizawl", "Lunglei", "Champhai", "Serchhip", "Kolasib", "Lawngtlai", "Saiha", "Thenzawl", "Saitual", "Khawbung", "Tlabung", "Buarpui", "Hnahthial", "Bilkhawthlir", "Neihdawn", "Darzo", "Phullen", "Vaphai", "Tuipang", "East Lungdar", "Tualbung", "Thingsulthliah", "Tlangsang", "Zawlnuam", "Zawlpui", "Sialsuk", "Thingsai", "Thehlep", "Neihbawi", "Neihdawn"));
        placeSuggestions.put("Nagaland", Arrays.asList("Kohima", "Dimapur", "Dzukou Valley", "Mokokchung", "Tuensang", "Wokha", "Zunheboto", "Phek", "Mon", "Chumukedima", "Kiphire", "Longleng", "Meluri", "Chen", "Pfutsero", "Chare", "Shamator", "Tseminyu", "Tizit", "Kiusam", "Noklak", "Chizami", "Tamlu", "Thonoknyu", "Mangkolemba", "Aghunato", "Kigwema", "Jalukie", "Noklak", "Sanis"));
        placeSuggestions.put("Odisha", Arrays.asList("Bhubaneswar", "Puri", "Konark Sun Temple", "Cuttack", "Rourkela", "Brahmapur", "Sambalpur", "Balasore", "Baripada", "Bhadrak", "Balangir", "Jharsuguda", "Bargarh", "Jeypore", "Bhawanipatna", "Rayagada", "Puri", "Berhampur", "Baleshwar", "Kendujhar", "Jajapur", "Jagatsinghpur", "Kendrapara", "Nabarangpur", "Malkangiri", "Boudh", "Bhawanipatna", "Nayagarh", "Koraput", "Ganjam"));
        placeSuggestions.put("Puducherry", Arrays.asList("Paradise Beach", "Sri Aurobindo Ashram", "Auroville", "Promenade Beach", "Botanical Garden", "Basilica of the Sacred Heart of Jesus", "Chunnambar Boat House", "French War Memorial", "Ousteri Lake", "Seaside Promenade", "Raj Niwas", "Arikamedu", "Serenity Beach", "Manakula Vinayagar Temple", "Pondicherry Museum", "Gingee Fort", "Varadaraja Perumal Temple", "Sacred Heart Church", "Romain Rolland Library", "Auro Beach", "Matri Mandir", "Pondicherry Beach", "Arulmigu Manakula Vinayagar Temple", "Sri Aurobindo Hand Made Paper Factory", "Jawahar Toy Museum", "Bharathi Park", "Sri Varadaraja Perumal Temple", "Immaculate Conception Cathedral", "Sita Cultural Centre", "Cluny Embroidery Centre", "Kanniga Parameswari Temple"));
        placeSuggestions.put("Punjab", Arrays.asList("Amritsar", "Chandigarh", "Golden Temple", "Ludhiana", "Jalandhar", "Patiala", "Bathinda", "Hoshiarpur", "Mohali", "Pathankot", "Moga", "Firozpur", "Batala", "Abohar", "Sangrur", "Faridkot", "Ropar", "Kapurthala", "Rajpura", "Phagwara", "Malerkotla", "Khanna", "Nabha", "Gurdaspur", "Barnala", "Tarn Taran", "Muktsar", "Gobindgarh", "Sunam", "Budhlada"));
        placeSuggestions.put("Rajasthan", Arrays.asList("Jaipur", "Udaipur", "Jaisalmer", "Jodhpur", "Ajmer", "Bikaner", "Kota", "Sikar", "Alwar", "Bhilwara", "Bharatpur", "Sri Ganganagar", "Pali", "Gulabpura", "Hanumangarh", "Chittorgarh", "Barmer", "Nagaur", "Jhunjhunu", "Churu", "Banswara", "Makrana", "Tonk", "Bundi", "Jhalawar", "Kishangarh", "Dungarpur", "Nokha", "Sawai Madhopur", "Sardarshahar"));
        placeSuggestions.put("Sikkim", Arrays.asList("Gangtok", "Nathula Pass", "Tsomgo Lake", "Pelling", "Lachung", "Lachen", "Yuksom", "Namchi", "Ravangla", "Mangan", "Gyalshing", "Rangpo", "Singtam", "Chungthang", "Zuluk", "Rinchenpong", "Dzongu", "Soreng", "Geyzing", "Jorethang", "Chungthang", "Rhenock", "Temi", "Sumbuk", "Burtuk", "Samardung", "Kabi", "Chhangu", "Phodong", "Borong"));
        placeSuggestions.put("Tamil Nadu", Arrays.asList("Chennai", "Mahabalipuram", "Ooty", "Coimbatore", "Madurai", "Tiruchirappalli", "Tiruppur", "Salem", "Erode", "Tirunelveli", "Vellore", "Thoothukudi", "Dindigul", "Thanjavur", "Ranipet", "Nagercoil", "Karur", "Namakkal", "Kanyakumari", "Krishnagiri", "Sivakasi", "Tenkasi", "Ramanathapuram", "Pollachi", "Rajapalayam", "Virudhunagar", "Rasipuram", "Tindivanam", "Perambalur"));
        placeSuggestions.put("Telangana", Arrays.asList("Hyderabad", "Warangal", "Nagarjuna Sagar", "Nizamabad", "Khammam", "Karimnagar", "Ramagundam", "Mahbubnagar", "Nalgonda", "Adilabad", "Siddipet", "Miryalaguda", "Suryapet", "Jagtial", "Vikarabad", "Bhongir", "Kothagudem", "Wanaparthy", "Koratla", "Sangareddy", "Bellampalli", "Mancherial", "Jangaon", "Kagaznagar", "Bodhan", "Palwancha", "Bhadrachalam", "Sadasivpet", "Kamareddy", "Mandamarri"));
        placeSuggestions.put("Tripura", Arrays.asList("Agartala", "Udaipur", "Jampui Hills", "Belonia", "Dharmanagar", "Kailasahar", "Ambassa", "Khowai", "Sonamura", "Kamalpur", "Bishalgarh", "Sabroom", "Bishramganj", "Amarpur", "Khowai", "Jirania", "Mohanpur", "Udaipur", "Melaghar", "Kamalasagar", "Chandigarh", "Kumarghat", "Sabroom", "Amarpur", "Kailashahar", "Gournagar", "Manu", "Kamalpur", "Kanchanpur", "Sonamura"));
        placeSuggestions.put("Uttar Pradesh", Arrays.asList("Agra (Taj Mahal)", "Varanasi", "Lucknow", "Kanpur", "Allahabad", "Ghaziabad", "Meerut", "Noida", "Gorakhpur", "Bareilly", "Moradabad", "Aligarh", "Saharanpur", "Mathura", "Firozabad", "Rampur", "Faizabad", "Muzaffarnagar", "Bulandshahr", "Hapur", "Etawah", "Mirzapur", "Sambhal", "Amroha", "Hardoi", "Fatehpur", "Raebareli", "Orai", "Sitapur"));
        placeSuggestions.put("Uttarakhand", Arrays.asList("Dehradun", "Mussoorie", "Haridwar", "Nainital", "Rishikesh", "Roorkee", "Haldwani", "Rudrapur", "Kashipur", "Rudraprayag", "Chamoli", "Uttarkashi", "Pithoragarh", "Tehri", "Almora", "Srinagar", "Bageshwar", "Kichha", "Manglaur", "Ranikhet", "Pauri", "Jaspur", "Bajpur", "Sitarganj", "Ramnagar", "Ranikhet", "Khatima", "Champawat", "Tanakpur", "Muni Ki Reti"));
        placeSuggestions.put("West Bengal", Arrays.asList("Kolkata", "Darjeeling", "Sundarbans", "Asansol", "Siliguri", "Durgapur", "Bardhaman", "English Bazar", "Baharampur", "Habra", "Kharagpur", "Shantipur", "Dankuni", "Dhulian", "Sainthia", "Haldia", "Raiganj", "Krishnanagar", "Nabadwip", "Medinipur", "Balurghat", "Bankura", "Jalpaiguri", "Bangaon", "Cooch Behar", "Gangarampur", "Tamluk", "Purulia", "Jangipur"));


                  }

    private void openBrowserWithSearch(String query) {
        String searchQuery = "Famous places in " + query + " India";
        String url = "https://www.google.com/search?q=" + Uri.encode(searchQuery);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
