package com.softuvo.frp.api;

import com.softuvo.frp.config.ApiConstant;
import com.softuvo.frp.models.GoogleData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {


    @POST(ApiConstant.FORGOT_PASSWORD)
    Call<Map> forgotPassword(@Body Map map);

    @POST(ApiConstant.TERMS)
    Call<Map> terms();

    @POST(ApiConstant.FAQ)
    Call<Map> FAQ();

    @POST(ApiConstant.SUPPORT)
    Call<Map> Support();

    @POST(ApiConstant.SAVEDVIR)
    Call<Map> saveDVIR(@Body Map map);

    @POST(ApiConstant.ADD_LOGS)
    Call<Map> addLogs(@Body Map map);



    @POST(ApiConstant.DELETE_DOC)
    Call<Map> deleteDocs(@Body Map map);

    @POST(ApiConstant.EDIT_LOGS)
    Call<Map> saveEditedLog(@Body Map map);

    @POST(ApiConstant.EDIT_INSERT_LOGS)
    Call<Map> saveInsertdLogs(@Body Map map);

    @GET(ApiConstant.MAPSADDRESSES)
    Call<GoogleData> getCities(@QueryMap Map<String, String> map);


    @POST(ApiConstant.UPDATE_USERPROFILE)
    Call<Map> updateProfile(@Body Map map);

    @POST(ApiConstant.RESET_PIN)
    Call<Map> resetPin(@Body Map map);

    @POST(ApiConstant.UPDATE_REMARK)
    Call<Map> updateRemark(@Body Map map);

    @POST(ApiConstant.CHANGE_CURRENT_STATUS)
    Call<Map> changeCurrentStatus(@Body Map map);

    @POST(ApiConstant.RESET_PASSWORD)
    Call<Map> resetPassword(@Body Map map);



    @POST(ApiConstant.CERTIFY_LOGS)
    Call<Map> certifyLogs(@Body Map map);

   /* @POST(ApiConstant.GET_DRIVER_DETAILS)
    Call<TimerDetailsModel> getDriverTimerDetails(@Body Map map);*/

    @POST(ApiConstant.SENDEVENTREPORT)
    Call<Map> sendEventReport(@Body Map map);

    @POST(ApiConstant.DISPLAYLOGSPDF)
    Call<Map> displayLogsPdf(@Body Map map);


}
