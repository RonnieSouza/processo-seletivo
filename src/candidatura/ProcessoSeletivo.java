package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "CARLOS", "RONNIE", "CAIO", "LETICIA"};
        System.out.println("Processo Seletivo");

        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }


    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato Realizado com Sucesso");
            }
        }while (continuaTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA.");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " TENTATIVAS");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void selecionarCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "CARLOS", "RONNIE", "CAIO", "LETICIA", "ANA", "RODOLFO", "MARCOS", "LUIS"};
        String[] candidatosAprovados = new String[5];

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;


        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou o valor de: " + salarioPretendido + " de salario.");

            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato " + candidato + " foi selecionado para a vaga.");
                candidatosAprovados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;

            }
            candidatoAtual++;
        }

            for (int cont = 0; cont < 5; cont++) {
                 if(candidatosAprovados[cont] != null) {
                System.out.println("Candidato: " + candidatosAprovados[cont]);
                 }
            }
    }

        static double valorPretendido () {
            return ThreadLocalRandom.current().nextDouble(1800, 2200);
        }


        static void analisarCandidato ( double salarioPretendido){
            double salarioBase = 2000.0;
            if (salarioBase > salarioPretendido) {
                System.out.println("Ligar para o Candidato");
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Ligar para o Candidato com uma Contra Proposta");
            } else {
                System.out.println("Aguardando novos candidatos");
            }

        }

    }