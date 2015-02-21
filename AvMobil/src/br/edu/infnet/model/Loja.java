package br.edu.infnet.model;

import java.util.ArrayList;

public class Loja {
 private String nome;
 private String endereco;
 private ArrayList<Carro> vCarro = new ArrayList<Carro>();
 private ArrayList<Motocicleta> vMotocicleta = new ArrayList<Motocicleta>();
 
 public Loja() {
  super();
 }

 public Loja(String nome, String endereco, ArrayList<Carro> vCarro,
   ArrayList<Motocicleta> vMotocicleta) {
  super();
  this.nome = nome;
  this.endereco = endereco;
  this.vCarro = vCarro;
  this.vMotocicleta = vMotocicleta;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getEndereco() {
  return endereco;
 }

 public void setEndereco(String endereco) {
  this.endereco = endereco;
 }

 public ArrayList<Carro> getvCarro() {
  return vCarro;
 }

 public void setvCarro(Carro vCarro) {
  this.vCarro.add(vCarro);
 }

 public ArrayList<Motocicleta> getvMotocicleta() {
  return vMotocicleta;
 }

 public void setvMotocicleta(Motocicleta vMotocicleta) {
  this.vMotocicleta.add(vMotocicleta);
 }


}