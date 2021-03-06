package com.carbum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaDashboardController implements Initializable {
    public Button btnVenderPeca;
    public StackPane rootPane;
    public Button btnInicio;
    public Button btnMinhaConta;
    public Button btnFavoritos;
    public Button btnContato;
    public Button btnSair;
    public AnchorPane totalPane;
    public Button btnMeusAnuncios;
    public Button btnVoltar;
    public static String caminho;
    public Label nomeUsuario;
    public Button btnPlanos;
    public Button btnVip;

    private ConexaoBanco conexao;
    private String sql;

    public TelaDashboardController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnInicio){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaInicio = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaInicio);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnVip){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaAnunciosVip = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaAnunciosVip.fxml"));

                rootPane.getChildren().setAll(telaAnunciosVip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnVenderPeca) {
            rootPane.getChildren().clear();

            try {
                AnchorPane telaVenderPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaCadastroPeca.fxml"));

                rootPane.getChildren().setAll(telaVenderPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();*/
        }

        if (actionEvent.getSource() == btnMeusAnuncios){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaMeusAnuncios = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaMeusAnuncios.fxml"));

                rootPane.getChildren().setAll(telaMeusAnuncios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnFavoritos){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaFavoritos = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaFavoritos.fxml"));

                rootPane.getChildren().setAll(telaFavoritos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnPlanos){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaPlanos = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaEscolhaPlanos.fxml"));

                rootPane.getChildren().setAll(telaPlanos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnMinhaConta){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaPlanos = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaMinhaConta.fxml"));

                rootPane.getChildren().setAll(telaPlanos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnContato){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaContato.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnSair){
            totalPane.getChildren().clear();
            rootPane.getChildren().clear();

            try {
                AnchorPane telaLogin = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaLogin.fxml"));

                totalPane.getChildren().setAll(telaLogin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnVoltar){

            if (TelaDashboardController.caminho == null){
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaInicial.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (TelaDashboardController.caminho == "/fxml/TelaPecasBuscadas.fxml"){
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaPecasBuscadas.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                    TelaDashboardController.caminho = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }if (TelaDashboardController.caminho == "/fxml/TelaFavoritos.fxml"){
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaFavoritos.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                    TelaDashboardController.caminho = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (TelaDashboardController.caminho == "/fxml/TelaMeusAnuncios.fxml") {
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaMeusAnuncios.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                    TelaDashboardController.caminho = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (TelaDashboardController.caminho == "/fxml/TelaAnunciosVip.fxml") {
                rootPane.getChildren().clear();
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaAnunciosVip.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                    TelaDashboardController.caminho = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaInicial = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaInicial);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            sql = "SELECT p.nomepessoa FROM pessoa p WHERE p.idpessoa = ?";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setInt(1, LoginController.idUsuario);
            ResultSet rs = pstatement.executeQuery();

            while (rs.next()){
                String nome = rs.getString("nomepessoa");

                nomeUsuario.setText(nome);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
