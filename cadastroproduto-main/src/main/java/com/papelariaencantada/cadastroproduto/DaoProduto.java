package com.papelariaencantada.cadastroproduto;

import javafx.scene.control.Label;

import java.sql.*;

public class DaoProduto {
    String url = "jdbc:mysql://localhost:3306/projeto_integrador";
    String user = "root";
    String password = "12345";

    Connection con;


    public DaoProduto() throws SQLException {
        this.con = DriverManager.getConnection(url,user,password);

    }

    public void gravarNoBanco(String nome, String fornecedor, String marca, String categoria, String ultima_compra, String preco_compra, String preco_venda, String quantidade) throws SQLException {
        PreparedStatement query = this.con.prepareStatement("INSERT INTO produtos (nome, fornecedor, marca, categoria, ultima_compra, preco_compra, preco_venda, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        query.setString(1,nome);
        query.setString(2,fornecedor);
        query.setString(3, marca);
        query.setString(4, categoria);
        query.setString(5, ultima_compra);
        query.setString(6, preco_compra);
        query.setString(7,preco_venda);
        query.setString(8, quantidade);
        query.execute();
    }

    public void imprimirDados ( ){
                   try{
                Connection con = Conexao.getConexao();
                try{
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT nome,fornecedor, marca, categoria, ultima_compra, preco_compra, preco_venda, quantidade FROM produtos WHERE id = ? ");
                    while(rs.next()){
                        System.out.printf("%s - %s - %s - %s\n", rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
                    }
                }finally {
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }



    }








