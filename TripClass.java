package com.iti.tripplanner;

import android.app.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by aya on 25/03/18.
 */


public class TripClass extends Activity {

    public String Tripname;
    public String Tripfrom;
    public String TripTo;
    public Date StDate;
    public Date EndDate;
    public String note;
    public String Status;
    public String userId;

    public Map<String, Boolean> stars = new HashMap<>();

    public TripClass() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public TripClass(String uid, String name, Date Tstart, Date Tend) {
        this.userId = uid;
        this.Tripname = name;
        this.StDate = Tstart;
        this.EndDate = Tend;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("Tripname", Tripname);
        result.put("StDate", StDate);
        result.put("EndDate", EndDate);
        result.put("note", note);
        result.put("Status", Status);
        result.put("TripFrom", Tripfrom);
        result.put("TripTo", TripTo);


        return result;
    }

}


