package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();
    private static Users userDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUserDao(){
        if (userDao == null){
            userDao = new MySQLUsersDao(config);
        }
        return userDao;
    }

}
