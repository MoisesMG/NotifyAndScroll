package com.example.moises.notifyandscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int NOTIFICACION_ID=1;
    public static String TAG = MainActivity.class.getSimpleName();
    Button btnNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotify = (Button) findViewById(R.id.btnNotify);
        btnNotify.setOnClickListener(this);
    }//fin del constructor

    @Override
    public void onClick(View v) {
        //Construccion de la accion del intent implicito
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/index.html"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        //Construccion de la notificacion;
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_notify));
        builder.setContentTitle("Ejemplo notificacion basica");
        builder.setContentText("Este es solo una ejemplo de notifiacion basica");
        builder.setSubText("Desarrollo de aplicacion moviles 1");


        switch (v.getId()){
            case R.id.btnNotify:
                //envia la notificacion
                NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICACION_ID,builder.build());
                break;
            default:
                break;
        }//fin de swicth
    }//fin del metodo
}//fin de la clase
