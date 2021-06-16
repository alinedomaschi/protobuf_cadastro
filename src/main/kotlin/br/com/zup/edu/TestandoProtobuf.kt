package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(){

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("123.145.567-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.Dev)
        .addEndereco(FuncionarioRequest.Endereco.newBuilder()
                        .setLogradouro("Rua das Tabajaras")
                        .setCep("03059-030")
                        .setComplemento("Casa 20")
                        .build())
        .build()

    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)

}