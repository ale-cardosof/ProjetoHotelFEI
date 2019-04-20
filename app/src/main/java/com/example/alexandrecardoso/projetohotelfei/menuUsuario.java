package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class menuUsuario extends AppCompatActivity {
    // Cria variáveis globais (COLOCAR NA PRIMEIRA TELA CHAMADA PELO APP)
    public static ArrayList<Administrador> admsLogados = new ArrayList();
    public static ArrayList<Usuario> usuariosLogados = new ArrayList();
    public static infoLogado logado = new infoLogado(0,0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsLogados.add(admInicial);
        // Cria o usuário padrão
        Usuario userInicial = new Usuario("user","User Inicial","123456789","01/01/2019","user@user.com.br","11954546565","user");
        usuariosLogados.add(userInicial);
    }

    public void abrirTelaADM(View view){
        Intent intent = new Intent(menuUsuario.this, loginAdm.class);
        startActivity(intent);

    }
    public void abrirTelaCliente(View view){
        Intent intent = new Intent(menuUsuario.this, loginUser.class);
        startActivity(intent);
    }

}
