package com.softuvo.frp.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Events {
    public static class AdapterActivityMessage {
        private HashMap<Integer, ArrayList<String>> message;

        public AdapterActivityMessage(HashMap<Integer, ArrayList<String>> message) {
            this.message = message;
        }

        public HashMap<Integer, ArrayList<String>> getMessage() {
            return message;
        }
    }

    public static class AdapterTruckMessage {
        private ArrayList<String> TruckCheckedBox;

        public AdapterTruckMessage(ArrayList<String> TruckCheckedBox) {
            this.TruckCheckedBox = TruckCheckedBox;
        }

        public ArrayList<String> getTruckCheckedBox() {
            return TruckCheckedBox;
        }
    }

    public static class AdapterPosition {
        private Integer TrailerNumber;

        public Integer getTrailerNumber() {
            return TrailerNumber;
        }

        public AdapterPosition(Integer trailerNumber) {
            TrailerNumber = trailerNumber;
        }
    }
}


