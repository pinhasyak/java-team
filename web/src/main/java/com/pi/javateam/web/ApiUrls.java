package com.pi.javateam.web;

public class ApiUrls {

	// root
	public static final String ROOT_URL_USERS = "/users";
    public static final String ROOT_URL_TEAMS = "/teams";
	public static final String URL_USERS_USER = "/{user}";
    public static final String URL_USERS_TEAM = "/{team}";
    public static final String URL_USERS_ALL_USERS = "/all_users)";
	public static final String URL_USERS_CREATE_USER = "/create_user";
	public static final String URL_USERS_USER_PHOTO = ROOT_URL_USERS + URL_USERS_USER + "/photo";

	// customer API endpoints
	public static final String URL_USERS_USER_CUSTOMERS  = URL_USERS_USER +"/customers";
	public static final String URL_USERS_USER_CUSTOMERS_CUSTOMER = URL_USERS_USER_CUSTOMERS + "/{customer}";

}
