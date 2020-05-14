package com.example.chatfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class MessagesActivity extends AppCompatActivity {

    private Button btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

         BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.mensagens);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.contatos:
                       startActivity(new Intent(getApplicationContext(),ContatosActivity.class));
                       overridePendingTransition(0,0);
                       return true;


                   case R.id.mensagens:
                       startActivity(new Intent(getApplicationContext(),MessagesActivity.class));
                       overridePendingTransition(0,0);
                       return true;



               }
               return false;

            }
        });

        btnSair = findViewById(R.id.testes);
       /* btnSair.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           FirebaseAuth.getInstance().signOut();
                                           verifyAuthentication();
                                           Intent intent = new Intent(MessagesActivity.this, MainActivity.class);
                                           startActivity(intent);

                                       }
                                   });
*/

        verifyAuthentication();
    }


    private void verifyAuthentication() {

        // verificar se o usuário nao estiver logado. voltara para a pagina de login.
        if (FirebaseAuth.getInstance().getUid() == null) {
            Intent intent = new Intent(MessagesActivity.this, MainActivity.class);
            // flags para sobrepor a nova activity
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navigation, menu);
        return true;

    }

 /*   @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
           case R.id.contatos:
               Intent intent = new Intent(MessagesActivity.this, ContatosActivity.class );
               startActivity(intent);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                verifyAuthentication();
                Intent intent2 = new Intent(MessagesActivity.this, MainActivity.class);
                startActivity(intent2);



                break;

        }
        return super.onOptionsItemSelected(item);


    }
    */

}

