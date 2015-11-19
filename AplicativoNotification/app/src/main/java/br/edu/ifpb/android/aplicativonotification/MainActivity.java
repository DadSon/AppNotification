package br.edu.ifpb.android.aplicativonotification;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
    private Button notification;
    private int contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = (Button) notification.findViewById();

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {

                    public void run() {

                        try {

                            Thread.sleep(1000);
                            Notificacao("Email confirmado");

                        } catch (Exception e) {

                        }
                    }

                }.start();

            }
        });

    }

    private void Notificacao(String mensagem) {

        final String mensagemBarraStatus = "Notificação:Login Confirmado.";
        final String titulo = "AppExemplo";

        final Class<Login> activity = Login.class;

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notificacao = new Notification(R.drawable.ic_launcher, mensagemBarraStatus, System.currentTimeMillis());

        Intent intentMensagem = new Intent(this, activity);
        PendingIntent p = PendingIntent.getActivity(this, 0, intentMensagem, 0);

        notificacao.setLatestEventInfo(this, titulo, mensagem, p);

        notificacao.vibrate = new long[]{100, 250, 100, 500};
        notificacao.defaults |= Notification.DEFAULT_LIGHTS;
        notificacao.defaults |= Notification.DEFAULT_SOUND;
        notificacao.flags |= Notification.FLAG_AUTO_CANCEL;

        nm.notify(R.string.app_name, notificacao);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action ba    r will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View getMenuInflater() {
        return menuInflater;
    }

    public void setContentView(int contentView) {
        this.contentView = contentView;
    }

}