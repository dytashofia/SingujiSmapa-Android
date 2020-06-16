package com.example.loginactivity;

public class JadwalItem {

        private String mapel;
        private String status;
        private String namaguru;
        private String waktumengerjakan;
        private String statussoal;
        private String jumlahsoal;
        private String waktumulai;
        private int imgnote;

        public JadwalItem() {
        }

        public JadwalItem(String mapel, String status, String namaguru, String waktumengerjakan, String statussoal, String jumlahsoal, String waktumulai, int imgnote) {
            this.mapel = mapel;
            this.status = status;
            this.namaguru = namaguru;
            this.waktumengerjakan = waktumengerjakan;
            this.statussoal = statussoal;
            this.jumlahsoal = jumlahsoal;
            this.waktumulai = waktumulai;
            this.imgnote = imgnote;
        }

        //GETTER


        public String getMapel() {
            return mapel;
        }

        public String getStatus() {
            return status;
        }

        public String getNamaguru() {
            return namaguru;
        }

        public String getWaktumengerjakan() {
            return waktumengerjakan;
        }

        public String getStatussoal() {
            return statussoal;
        }

        public String getJumlahsoal() {
            return jumlahsoal;
        }

        public String getWaktumulai() {
            return waktumulai;
        }

        public int getImgnote() {
            return imgnote;
        }

        // SETTER

        public void setMapel(String mapel) {
            this.mapel = mapel;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setNamaguru(String namaguru) {
            this.namaguru = namaguru;
        }

        public void setWaktumengerjakan(String waktumengerjakan) {
            this.waktumengerjakan = waktumengerjakan;
        }

        public void setStatussoal(String statussoal) {
            this.statussoal = statussoal;
        }

        public void setJumlahsoal(String jumlahsoal) {
            this.jumlahsoal = jumlahsoal;
        }

        public void setWaktumulai(String waktumulai) {
            this.waktumulai = waktumulai;
        }

        public void setImgnote(int imgnote) {
            this.imgnote = imgnote;
        }
    }

