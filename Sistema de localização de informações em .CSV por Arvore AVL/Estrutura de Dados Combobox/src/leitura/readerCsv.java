package leitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import avl.*;
import dados.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;

public class readerCsv {
    public void createCsvFile(){ 
        try{
            try (
                    BufferedWriter StrW = new BufferedWriter(new FileWriter("input4.csv"))) {
                Random gerador = new Random();
                for(int i = 0, j, k; i < 1000000; i++){
                    j = gerador.nextInt(1000000000);
                    k = gerador.nextInt(999999999);
                    StrW.write(i+"nome"+j+";"+j+";"+k+";"+(j*k-k)+";"+(j*k-k)+";"+(j*k-i)+";"+(j*k-j)+";"+(k*i-k)+"\n");
                	//StrW.write(i*j+"\n");
                }
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace(); 
        }catch (IOException e){
            e.printStackTrace();
        } 
    }

    public ArrayList<AVLtree> readCsvFile(String nomeArquivo){
        ArrayList<AVLtree> avls = new ArrayList<>();
        LinkedHashSet<Dados> dds = new LinkedHashSet<>();
        try {
            try ( 
                BufferedReader StrR = new BufferedReader(new FileReader(nomeArquivo))) {
                String Str;
                String[] TableLine;
                
                Str = StrR.readLine();
                TableLine = Str.split(";");
                
                for (int i = 0; i < TableLine.length; i++) {
                    AVLtree a = new AVLtree();
                    avls.add(a);
                }
                
                while((Str = StrR.readLine())!= null){
                    Dados dados = new Dados();
                    dados.getDados().addAll(Arrays.asList(Str.split(";")));
                    dds.add(dados);                                        
                }
                
                System.out.println("terminou");
                
                int j = 0;
                for (AVLtree a: avls) {
                	long tempInicial = System.currentTimeMillis();
					for (Dados d: dds) {
						a.insert(d.getDados().get(j), d);
					}
					long tempFinal = System.currentTimeMillis();
			        long dif = (tempFinal - tempInicial);
			        long minutes = dif / 1000 / 60;
					dif -= minutes * 1000 * 60;
					long seconds = dif / 1000;
					dif -= seconds * 1000;
			        System.out.println(String.format("%02d minutos e %02d segundos", minutes, seconds));
					j++;
				}
                
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        return avls;
    }
}
