package com.example.alexandrecardoso.projetohotelfei.Classes;

import com.example.alexandrecardoso.projetohotelfei.Estruturas_.Arvore_adm;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.Arvore_user;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.HASH;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;

import java.util.Date;


// Classe que guardará todas as estruturas do aplicativo
public class Estruturas{

    public static boolean criado = false;
    public static LDE<Quarto> ldeQuartos = new LDE<>();
    public static Arvore_user usuariosCadastrados = new Arvore_user();
    public static Arvore_adm admsCadastrados = new Arvore_adm();
    public static infoLogado logado = new infoLogado("",0);
    public static MensagemToast tela = new MensagemToast();
    public static Reserva reserva_clicada = new Reserva();
    public static HASH hash_reservas = new HASH();

    public static void criaEstru (){
        criarAdm();
        insereUsuarios();
        criaQuartos();
        //criaHotel();
        criado = true;
    }

    public static void criaQuartos(){
        Quarto q = new Quarto();

        q.setNumPorta(1);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(120);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Otimo Quarto!!!",5,"Recepção excelente," +
                " serviço de quarto bem atenciosos e instalações de acordo com minhas expectativas."));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        q = new Quarto();
        q.setNumPorta(2);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(100);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Hotel simples.",5,"Hotel simples, " +
                "porém confortável! Café da manhã honesto! Estacionamento pago."));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        q = new Quarto();
        q.setNumPorta(3);
        q.setQntdCamas(1);
        q.setQntdChuveiros(2);
        q.setValorDiaria(300);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Vista incrível",5,"Os hóspedes são " +
                "bastante efusivos ao falar da vista deste hotel. Para os visitantes, um dos grandes destaques do estabelecimento é a cobertura."));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        q = new Quarto();
        q.setNumPorta(4);
        q.setQntdCamas(2);
        q.setQntdChuveiros(1);
        q.setValorDiaria(350);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Fachada 5 estrelas...cuidado!",3,
                "Ótima localização e café da manhã, " +
                        "mas especialmente funcionários muito atenciosos!!"));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        q = new Quarto();
        q.setNumPorta(5);
        q.setQntdCamas(2);
        q.setQntdChuveiros(2);
        q.setValorDiaria(400);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Ótima localização",4,
                "Ótima localização e café da manhã," +
                        "mas especialmente funcionários muito atenciosos!!"));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        q = new Quarto();
        q.setNumPorta(10);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(300);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("O quarto DECA!!!",4,
                "Lugar confortavel, serviço de quarto excelente (Especialidade; Galinha assada)." +
                        "Quem tem mais tem 10!"));
        admsCadastrados.busca("admin").getMeuHotel().setQuartos(q);

        Date dtEntrada = new Date(2019 - 1900, 5, 1);
        Date dtEntrada2 = new Date(2017 - 1900, 7, 8);
        Date dtEntrada3 = new Date(2017 - 1900, 7, 9);
        Date dtSaida = new Date(2019 - 1900, 5, 4);
    }

    public static void destroiEstrutura(){
        criado = false;
        ldeQuartos = null;
    }

    public static void insereUsuarios(){
        Usuario userInicial = new Usuario("user","User Inicial","123456789",
                "01/01/2019","user@user.com.br","11954546565","user");
        usuariosCadastrados.insere(userInicial);

        Usuario userDois = new Usuario("ale","Alexandre Cardoso","123456789",
                "01/01/2019","user@user.com.br","11954546565","ale");
        usuariosCadastrados.insere(userDois);

        Usuario userTres = new Usuario("filipi","Filipi Guimares Silva","123456789",
                "01/01/2019","user@user.com.br","11954546565","filipi");
        Date dtEntrada = new Date(2019 - 1900, 5, 1);
        Date dtSaida = new Date(2019 - 1900, 5, 4);
        Reserva r1 = new Reserva( userTres.getNome(), dtEntrada,dtSaida, ldeQuartos.getByIndex(1), 150);
        userTres.setMinhasReservas(r1);

        dtEntrada = new Date(2019 - 1900, 5, 8);
        dtSaida = new Date(2019 - 1900, 5, 12);
        r1 = new Reserva( userTres.getNome(), dtEntrada,dtSaida, ldeQuartos.getByIndex(3), 450);
        userTres.setMinhasReservas(r1);
        usuariosCadastrados.insere(userTres);

        Usuario userQuatro = new Usuario("serain","Lucas Machado Serain","123456789",
                "01/01/2019","user@user.com.br","11954546565","serain");
        usuariosCadastrados.insere(userQuatro);
    }

    public static void criarAdm(){
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsCadastrados.insere(admInicial);
    }

    public  static  void criaHotel(){

        Hotel nossoHotel = new Hotel(30);
    }
}
