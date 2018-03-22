package com.softuvo.frp.api;

import com.softuvo.frp.config.ApiConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private static ApiHelper apiHelper;
    private ApiService apiservice;
    private ApiService mapsservice;

    private ApiHelper() {
    }

    public static ApiHelper init() {
        if (apiHelper == null) {
            apiHelper = new ApiHelper();
            apiHelper.initApiService();
        }
        return apiHelper;
    }

    private void initApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.APP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        Retrofit mapsretrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.MAPS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mapsservice = mapsretrofit.create(ApiService.class);
        apiservice = retrofit.create(ApiService.class);
    }



    /*public void forgotPassword(Map map, final ApiCallBack<Map> apiCallback) {
        apiservice.forgotPassword(map).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {
                apiCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {
                apiCallback.onFailure(App.getAppContext().getResources().getString(R.string.server_error));
            }
        });
    }
*/




  /*  public void getDashboardData(Map map, final ApiCallBack<GetDashboardDataResponse> apiCallback) {
        apiservice.getDashboardData(map).enqueue(new Callback<GetDashboardDataResponse>() {
            @Override
            public void onResponse(Call<GetDashboardDataResponse> call, Response<GetDashboardDataResponse> response) {
                apiCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GetDashboardDataResponse> call, Throwable t) {
                apiCallback.onFailure(App.getAppContext().getResources().getString(R.string.server_error));
            }
        });
    }*/


    /*

    public void changeCurrentStatus(Map map, final ApiCallBack<Map> apiCallback) {
        apiservice.changeCurrentStatus(map).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {
                apiCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {
                apiCallback.onFailure(App.getAppContext().getResources().getString(R.string.server_error));
            }
        });
    }*/



}