package com.zl.dafeng.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zl.dafeng.R;
import com.zl.dafeng.bo.model.MovieModel;
import com.zl.dafeng.bo.model.ResultModel;
import com.zl.dafeng.bo.model.SouguBean;
import com.zl.dafeng.novate.BaseApiService;
import com.zl.dafeng.novate.BaseSubscriber;
import com.zl.dafeng.novate.DownLoadCallBack;
import com.zl.dafeng.novate.Novate;
import com.zl.dafeng.novate.NovateResponse;
import com.zl.dafeng.service.MyAPI;
import com.zl.dafeng.ui.base.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by Tamic on 2016-06-15.
 * {@link # https://github.com/NeglectedByBoss/Novate
 *
 * @link # http://blog.csdn.net/sk719887916
 * }
 */
public class ExempleActivity extends BaseActivity {

    String baseUrl = "http://ip.taobao.com/";
    @BindView(R.id.bt_test)
    Button btTest;
    @BindView(R.id.bt_simple)
    Button btSimple;
    @BindView(R.id.bt_get)
    Button btGet;
    @BindView(R.id.bt_post)
    Button btPost;
    @BindView(R.id.bt_upload)
    Button btUpload;
    @BindView(R.id.bt_download)
    Button btDownload;
    @BindView(R.id.bt_my_api)
    Button btMyApi;
    private Novate novate;
    private Map<String, String> parameters = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_exemple;
    }

    @Override
    protected void initialize() {
        parameters.put("ip", "21.22.11.33");
        headers.put("Accept", "application/json");

        novate = new Novate.Builder(this)
                //.addParameters(parameters)
                .connectTimeout(20)
                .writeTimeout(15)
                .baseUrl(baseUrl)
                .addHeader(headers)//.addApiManager(ApiManager.class)
                .addLog(true)
                .build();


        BaseApiService api = novate.create(BaseApiService.class);
    }


    /**
     * test
     */
    private void performTest() {

        //http://apis.baidu.com/apistore/weatherservice/cityname?cityname=上海
        Map<String, String> headers = new HashMap<>();
        headers.put("apikey", "27b6fb21f2b42e9d70cd722b2ed038a9");

        novate = new Novate.Builder(this)
                .addParameters(parameters)
                .connectTimeout(5)
                .baseUrl("https://apis.baidu.com/")
                .addHeader(headers)
                .addLog(true)
                .build();

        novate.test("https://apis.baidu.com/apistore/weatherservice/cityname?cityname=上海", null,
                new BaseSubscriber<ResponseBody>(ExempleActivity.this) {
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.e("OkHttp", e.getMessage());
                        Toast.makeText(ExempleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            Toast.makeText(ExempleActivity.this, new String(responseBody.bytes()), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }


    private void perform() {

        parameters = new HashMap<>();
        /*start=0&count=5*/
        parameters.put("start", "0");
        parameters.put("count", "1");

        novate = new Novate.Builder(this)
                .addParameters(parameters)
                .connectTimeout(5)
                .baseUrl("http://api.douban.com/")
                //.addApiManager(ApiManager.class)
                .addLog(true)
                .build();

        novate.get("v2/movie/top250", parameters, new BaseSubscriber<ResponseBody>(ExempleActivity.this) {
            @Override
            public void onNext(ResponseBody responseBody) {
                try {

                    String jstr = new String(responseBody.bytes());

                    Type type = new TypeToken<MovieModel>() {
                    }.getType();

                    MovieModel response = new Gson().fromJson(jstr, type);

                    Toast.makeText(ExempleActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });


    }

    /**
     * performGet
     */
    private void performGet() {

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("ip", "21.22.11.33");
        novate = new Novate.Builder(this)
                //.addParameters(parameters)
                .connectTimeout(5)
                .baseUrl(baseUrl)
                .addLog(true)
                .build();


        /**
         * 如果不需要数据解析后返回 则调用novate.Get()
         * 参考 performPost()中的方式
         */
        novate.executeGet("service/getIpInfo.php", parameters, new Novate.ResponseCallBack<NovateResponse<ResultModel>>() {
            @Override
            public void onStart() {

                // todo onStart

            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(ExempleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccee(NovateResponse<ResultModel> response) {
                Toast.makeText(ExempleActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * performPost
     */
    private void performPost() {

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("ip", "21.22.11.33");
        novate = new Novate.Builder(this)
                .connectTimeout(8)
                .baseUrl(baseUrl)
                //.addApiManager(ApiManager.class)
                .addLog(true)
                .build();


        /**
         *
         *
         * 调用post需要你自己解析数据
         *
         * 如果需要解析后返回 则调用novate.executeGet()
         * 参考 performGet()中的方式
         */
        novate.post("service/getIpInfo.php", parameters, new BaseSubscriber<ResponseBody>(ExempleActivity.this) {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String jstr = new String(responseBody.bytes());

                    Type type = new TypeToken<NovateResponse<ResultModel>>() {
                    }.getType();

                    NovateResponse<ResultModel> response = new Gson().fromJson(jstr, type);
                    Toast.makeText(ExempleActivity.this, response.getData().toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * perform_myApi
     * HostUrl = "http://lbs.sougu.net.cn/";
     */
    private void perform_Api() {

        parameters.clear();
        parameters.put("m", "souguapp");
        parameters.put("c", "appusers");
        parameters.put("a", "network");

        novate = new Novate.Builder(this)
                .addHeader(headers)
                .connectTimeout(10)
                .baseUrl("http://lbs.sougu.net.cn/")
                .addLog(true)
                .build();
        MyAPI myAPI = novate.create(MyAPI.class);

        novate.call(myAPI.getSougu(parameters),
                new BaseSubscriber<SouguBean>(ExempleActivity.this) {

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ExempleActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(SouguBean souguBean) {

                        Toast.makeText(ExempleActivity.this, souguBean.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


    private void performUpLoad() {

        String mPath = "you File path ";
        String url = "";
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("image/jpg"), new File(mPath));

        novate.upload(url, requestFile, new BaseSubscriber<ResponseBody>(ExempleActivity.this) {
            @Override
            public void onNext(ResponseBody responseBody) {

            }
        });
    }

    /**
     * performDown
     */
    private void performDown() {
        String downUrl = "http://apk.hiapk.com/web/api.do?qt=8051&id=723";

        novate.download(downUrl, new DownLoadCallBack() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(ExempleActivity.this, "download is start", Toast.LENGTH_SHORT).show();
                btDownload.setText("DownLoad cancel");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onCancel() {
                super.onCancel();
                btDownload.setText("DownLoad start");
            }

            @Override
            public void onProgress(long fileSizeDownloaded) {
                super.onProgress(fileSizeDownloaded);

            }

            @Override
            public void onSucess(String path, String name, long fileSize) {
                Toast.makeText(ExempleActivity.this, "download  onSucess", Toast.LENGTH_SHORT).show();
                btDownload.setText("DownLoad start");
            }
        });
    }

    @OnClick({R.id.bt_test, R.id.bt_simple, R.id.bt_get, R.id.bt_post, R.id.bt_upload, R.id.bt_download, R.id.bt_my_api})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_test:
                performTest();
                break;
            case R.id.bt_simple:
                perform();
                break;
            case R.id.bt_get:
                performGet();
                break;
            case R.id.bt_post:
                performPost();
                break;
            case R.id.bt_upload:
                performUpLoad();
                break;
            case R.id.bt_download:
                performDown();
                break;
            case R.id.bt_my_api:
                perform_Api();
                break;
        }
    }
}
