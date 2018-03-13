package cse.ab2018.com.anantabodha_2k18;

import android.annotation.SuppressLint;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.DownloadManager.Request;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import android.widget.Toast;
import android.widget.ProgressBar;




public class MainActivity extends AppCompatActivity {



    SwipeRefreshLayout mySwipeRefreshLayout;

    String lastUrl="";
    private WebView webView;
    boolean flagLayoutControl = true;

    Bitmap bitmap;


    ProgressBar loadingProgressBar;


    @SuppressLint({"NewApi", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeContainer);


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);




        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_SHORT ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/");
            }

        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/#block66");
            }
        });
        button3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/#block362");
            }
        });
        button4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/#block328");
            }
        });
        button5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/#block360");
            }
        });
        button6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("http://jagan.000webhostapp.com/index1.php");
            }
        });
        button7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Please wait..Loading..!" , Toast.LENGTH_LONG ).show();

                webView();

                startWebView("https://anantabodha2k18.bitrix24.site/#block232");
            }
        });

    }



    @SuppressLint("WrongConstant")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void webView() {

        setContentView(R.layout.webview);
        flagLayoutControl = false;

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeContainer);

        loadingProgressBar = (ProgressBar) findViewById(R.id.progressbar_Horizontal);
        webView = (WebView) findViewById(R.id.webView1);



        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        WebSettings webSettings = this.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.webView.setScrollBarStyle(0);
        webSettings.setSaveFormData(true);
        webSettings.setBuiltInZoomControls(true);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                    }
                });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.exit) {


            //Toast.makeText(getApplicationContext(), "About menu item pressed", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Confirm");
            builder.setMessage("Are you sure, Do you want to exit?");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                    dialog.dismiss();
                }

            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing
                    dialog.dismiss();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();

        }
        else if (id == R.id.share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Get UCEA CSE Dept. Symposium APP AnantaBodha_2K18 via:- https://anantabodha-2k18.en.aptoide.com/?store_name=purebrain&app_id=35305819 ");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }

        return super.onOptionsItemSelected(item);


    }


    @SuppressLint("SetJavaScriptEnabled")
    private void startWebView(String url) {

        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Request request = new Request(
                        Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setDescription("Downloading ...!");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Uri.parse(url).getLastPathSegment());
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);

                Toast toast = Toast.makeText(getApplicationContext(), "Downloading...!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;


            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


        });



        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);

        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient() {



            @Override

            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);


                loadingProgressBar.setProgress(newProgress);


                if (newProgress == 100) {
                    loadingProgressBar.setVisibility(View.GONE);

                } else {
                    loadingProgressBar.setVisibility(View.VISIBLE);

                }

            }

        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_BACK) {


            if (flagLayoutControl != true) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    Intent myIntent = new Intent(this, MainActivity.class);
                    startActivityForResult(myIntent, 0);
                    finish();
                }
            }
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }



}



