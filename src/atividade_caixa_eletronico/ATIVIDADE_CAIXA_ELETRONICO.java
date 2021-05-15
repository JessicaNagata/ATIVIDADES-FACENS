package atividade_caixa_eletronico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATIVIDADE_CAIXA_ELETRONICO {

    public static void main(String[] args) {
        int vez = 3, opcao = 0;
        float saldo = 1000f, saque, deposito = 0, valor, saldoAnt;
        String senha, senhaCorreta = "01020304", cpf, cpfCorreto = "123.456.789-00", auxiliar;
        boolean sair = false;
        List<extratoBancario> extratos = new ArrayList<extratoBancario>();

        Scanner ler = new Scanner(System.in);

        do {

            System.out.println("********************** BANCO MONEY CASH **********************");
            System.out.println("******************* SEJA MUITO BENVINDO(A)********************");
            System.out.println();

            do {

                System.out.print(" Informe seu CPF com pontos e traço por favor: ");
                cpf = ler.next();
                System.out.println();

                if (!cpf.equals(cpfCorreto)) {
                    System.out.println("________________________CPF INVÁLIDO__________________________ ");
                    System.out.println("---------------------ACESSO NÃO PERMITIDO--------------------- ");
                    System.out.println("_______________________TENTE NOVAMENTE________________________ ");
                    System.out.println();
                } else {
                    opcao = 1;
                }

            } while (opcao == 0);

            do {

                System.out.print(" Digite a sua senha:  ");
                senha = ler.next();
                System.out.println();

                if (!senha.equals(senhaCorreta)) {
                    vez--;
                    System.out.println("_______SENHA INCORRETA_______  ");
                    System.out.println(vez + " TENTATIVAS DISPONÍVEIS  ");
                    System.out.println();
                }
                if (vez < 1) {
                    System.out.println("---------------------- CONTA BLOQUEADA!-----------------------");
                    System.out.println("--- Por favor, entre em contato com o gerente da sua conta.---");
                    vez = -1;
                    sair = true;
                }
            } while (!senha.equals(senhaCorreta) && vez > 0);

            if (sair == true && !senha.equals(senhaCorreta)) {
                do {
                    System.out.println("PRESSIONE 0 PARA SAIR");
                    opcao = ler.nextInt();
                    System.out.println();
                    if (opcao != 0) {
                        System.out.println("______OPÇÃO INVÁLIDA______");
                    }
                } while (opcao != 0);

            }
            vez = 3;

            do {
                if (senha.equals(senhaCorreta) || opcao == 10) {

                    System.out.println("********************** MENU PRINCIPAL ************************");
                    System.out.println("Selecione o serviço desejado por favor:");
                    System.out.println("1 - SALDO");
                    System.out.println("2 - DEPÓSITO");
                    System.out.println("3 - SAQUE");
                    System.out.println("4 - TRANSFERÊNCIA");
                    System.out.println("5 - CONSULTAR EXTRATO");
                    System.out.println("0 - SAIR");
                    System.out.println("");
                }
                if (opcao != 0) {
                    do {
                        opcao = ler.nextInt();
                        System.out.println();
                        if (opcao < 0 || opcao > 5) {
                            System.out.println("______OPÇÃO INVÁLIDA______");
                            System.out.println("DIGITE NOVAMENTE POR FAVOR");
                        }
                    } while (opcao < 0 || opcao > 5);

                }

                if (sair == false || senha.equals(senhaCorreta)) {
                    switch (opcao) {
                        case 1:
                            System.out.println("SALDO ATUAL: R$ " + saldo);
                            System.out.println("");
                            System.out.println("TRANSAÇÃO CONCLUIDA");
                            break;

                        case 2:
                            saldoAnt = saldo;
                            do {

                                System.out.print("DIGITE O VALOR DO DEPÓSITO: R$ ");
                                deposito = ler.nextFloat();
                                if (deposito < 0) {
                                    System.out.println("______VALOR INVÁLIDO______");
                                } else {
                                    saldo = saldo + deposito;
                                    System.out.print("VALOR DISPONÍVEL APÓS A TRANSAÇÃO: R$ " + saldo);
                                    System.out.println("");
                                }
                            } while (deposito < 0);
                            System.out.println("TRANSAÇÃO CONCLUIDA");

                            extratoBancario resultadoDeposito = new extratoBancario(saldoAnt, "Depósito", deposito, saldo);
                            extratos.add(resultadoDeposito);
                            break;

                        case 3:
                            saldoAnt = saldo;
                            do {
                                System.out.print("DIGITE O VALOR DO SAQUE: R$ ");
                                saque = ler.nextFloat();
                                if (saque > saldo) {
                                    System.out.println("______SALDO INDISPONÍVEL______");
                                } else if (saque < 0) {
                                    System.out.println("______VALOR INVÁLIDO______");
                                } else {
                                    saldo = saldo - saque;
                                    System.out.print("VALOR DISPONÍVEL APÓS A TRANSAÇÃO: R$ " + saldo);
                                    System.out.println("");
                                }
                            } while (saque > saldo || saque < 0);
                            System.out.println("TRANSAÇÃO CONCLUIDA");
                            extratoBancario resultadoSaque = new extratoBancario(saldoAnt, "Saque", saque, saldo);
                            extratos.add(resultadoSaque);
                            break;

                        case 4:
                            saldoAnt = saldo;
                            do {
                                System.out.print("DIGITE O VALOR DA TRANSFERÊNCIA: R$ ");
                                valor = ler.nextFloat();
                                if (valor > saldo) {
                                    System.out.println("______SALDO INDISPONÍVEL______");
                                } else if (valor < 0) {
                                    System.out.println("______VALOR INVÁLIDO______");
                                } else {
                                    System.out.print("INFORME A CONTA PARA A TRANSFERÊNCIA: ");
                                    auxiliar = ler.next();
                                    System.out.print("INFORME A AGENCIA: ");
                                    auxiliar = ler.next();
                                    System.out.print("INSIRA O CÓDIGO DO BANCO DESTINATÁRIO: ");
                                    auxiliar = ler.next();
                                    saldo = saldo - valor;
                                    System.out.print("VALOR DISPONÍVEL APÓS A TRANSAÇÃO: R$ " + saldo);
                                    System.out.println("");
                                }
                            } while (valor > saldo || valor < 0);
                            System.out.println("TRANSAÇÃO CONCLUIDA");
                            extratoBancario resultadoTransf = new extratoBancario(saldoAnt, "Transferência", valor, saldo);
                            extratos.add(resultadoTransf);
                            break;

                        case 5:
                            System.out.println("********************** BANCO MONEY CASH **********************");
                            System.out.println("----------------------EXTRATO BANCÁRIO------------------------");
                            System.out.println();
                            System.out.println("---------------CLIENTE CPF : " + cpf + "--------------------");
                            System.out.println();

                            for (extratoBancario item : extratos) {
                                System.out.println("SALDO ANTERIOR: R$ " + item.valorAnterior);
                                System.out.println("OPERAÇÃO EFETUADA: " + item.tipo);
                                System.out.println("VALOR DA TRANSAÇÃO: R$ " + item.valor);
                                System.out.println("SALDO: R$ " + item.valorPosterior);
                                System.out.println();
                            }

                            if (extratos.isEmpty()) {
                                System.out.println("SEM MOVIMENTAÇÕES");
                                System.out.println("SALDO ATUAL: R$ " + saldo);
                            }
                            
                            System.out.println();
                            System.out.println("SALDO ATUAL: R$ " + saldo);
                            System.out.println("");
                            System.out.println("TRANSAÇÃO CONCLUIDA");
                            break;
                    }
                }
                if (opcao != 0) {
                    do {
                        System.out.println();
                        System.out.print("DIGITE 0 PARA SAIR OU 10 PARA REALIZAR NOVA OPERAÇÃO: ");
                        opcao = ler.nextInt();
                        System.out.println();
                        if (opcao != 0 && opcao != 10) {
                            System.out.println("______OPÇÃO INVÁLIDA______ ");
                        }
                    } while (opcao != 0 && opcao != 10);
                }
                if (opcao == 0) {
                    System.out.println("______________________ ENCERRANDO O SEU ACESSO _______________________");
                    System.out.println("________________ SERÁ SEMPRE UM PRAZER ATENDÊ-LO (A) _________________");
                    System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬ CONTE SEMPRE CONOSCO ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                    System.out.println();
                    System.out.println("_____________BANCO MONEY CASH AGRADECE A SUA PREFERÊNCIA______________");
                    System.out.println("____________________________VOLTE SEMPRE!_____________________________");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();

                }

            } while (senha.equals(senhaCorreta) && opcao == 10);
        } while (opcao == 0);

    }

    public static class extratoBancario {

        public float valorAnterior;
        public String tipo;
        public float valor;
        public float valorPosterior;

        public extratoBancario(float valorAnterior, String tipo, float valor, float valorPosterior) {

            this.valorAnterior = valorAnterior;
            this.tipo = tipo;
            this.valor = valor;
            this.valorPosterior = valorPosterior;
        }

    }
}
