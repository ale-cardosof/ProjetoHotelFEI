package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class menuUsuario extends AppCompatActivity {
    // Variáveis Globais
    public static int pessoasCadastradas = 0; // Usado para gerar ID's
    public static ArrayList<Administrador> admsCadastrados = new ArrayList();
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList();
    public static ArrayList<Quarto> quartosCriados = new ArrayList();
    public static infoLogado logado = new infoLogado(0,0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        // Cria o adm padrão
        Administrador admInicial = new Administrador(0,"admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsCadastrados.add(admInicial);
        pessoasCadastradas++;

        // Cria 10 quartos automáticos para o adm padrão
        for(int i=0; i < 10; i++){
            admInicial.insereQuarto(i,15,2,1,true);
        }
        // Cria o usuário padrão
        Usuario userInicial = new Usuario(1,"user","User Inicial","123456789","01/01/2019","user@user.com.br","11954546565","user");
        usuariosCadastrados.add(userInicial);
        pessoasCadastradas++;
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
