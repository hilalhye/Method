
package com.mycompany.odev;

import java.util.Random;
import java.util.Scanner;

public class İkiBoyutluDizideMetod {
    
    //bu metodun amacı kendisine verilen tabloyu ekrana yazdırmak.
    public static void matrisYaz(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
    //bu metodun amacı ise n sayısı ile n*n boyutunda random sayılar ile yeni bir matris oluşturup döndürmek.
    public static int[][] random(int n){
        Random rand=new Random();
        int[][] b=new int[n][n];  //n*n boyutunda 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j]=rand.nextInt(100); //0-99 arası sayılar
            }
            
        }
        return b; //tablo dolduktan sonra bu metotta ürettiğimiz tabloyu metodu çağıran yere gönderiyoruz. 
    }
    //iki boyutlu iki matrisi toplama ve matrisi döndürme
    public static int[][] matristopla(int[][] x,int[][] y){
        int satir=x.length;
        int sutun=x[0].length;
        int[][] toplam=new int[satir][sutun];
        
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                toplam[i][j]=x[i][j]+y[i][j];
            }
            
        }
        return toplam;
    }
    //her satırdaki en küçük elemanı buluyoruz.
    public static void satirdakienkucuk(int[][] a){
        for (int i = 0; i < a.length; i++) {
            int min=a[i][0]; //ilk elemanı en küçük olarak kabul ettik.
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j]<min) {
                    min=a[i][j];
                }
                
            }
            System.out.println((i+1)+". satirdaki en kucuk eleman: "+min);           
        }        
    }
    //her sütundaki en küçük elemanı buluyoruz.
    public static void sutundakienkucuk(int[][] a){
        for (int j = 0; j < a[0].length; j++) {
            int min=a[0][j];
            for (int i = 1; i <a.length; i++) {
                if (a[i][j]<min) {
                    min=a[i][j];                    
                }                
            }
            System.out.println((j+1)+". sutundaki en kucuk eleman: "+min);           
        }
    }
    //her satırdaki en küçük elemanların indekslerini bir dizye atıp o diziyi döndürüyoruz.
    public static int[] satirenkucukindeks(int[][] a){
        int[] b=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int min=a[i][0];
            int minindeks=0;
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j]<min) {
                    min=a[i][j];
                    minindeks=j;                   
                }
            }
            b[i]=minindeks;           
        }
        return b;
    }
    //her sütundaki en küçük elemanların indekslerini bir diziye atıp döndür.
    public static int[] sutunenkucukindeks(int[][] a){
        int[] b=new int[a.length];
        for (int j = 0; j < a[0].length; j++) {
            int min=a[0][j];
            int minindeks=0;
            for (int i = 1; i < a.length; i++) {
                if (a[i][j]<min) {
                    min=a[i][j];
                    minindeks=i;
                }
            } 
            b[j]=minindeks;
        }
        return b;
    }
    //her satırın ortalamasını bulup döndürme işlemi
    public static double[] satırortalama(int[][] a){
        double[] b=new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double toplam=0;
            for (int j = 0; j < a[i].length; j++) {
                toplam +=a[i][j];
            }
            b[i]=toplam/a[i].length;           
        }
        return b;
    }
    //her sütundaki elemanların ortalamasını bulup diziye aktarıp döndürme işlemi
    public static double[] sutunortalama(int[][] a){
        double[] b=new double[a.length];
        for (int j = 0; j < a[0].length; j++) {
            double toplam=0;
            for (int i = 0; i < a.length; i++) {
                toplam +=a[i][j];                
            }
            b[j]=toplam/a.length;
        }
        return b;
    }
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Bir n sayisi giriniz: ");
        int n=input.nextInt();
        
        int[][] matris1=random(n);
        int[][] matris2=random(n);
        
        System.out.println("Matris 1: ");
        matrisYaz(matris1);
        System.out.println("Matris 2: ");
        matrisYaz(matris2);
        
        System.out.println("-Matrisleri Toplama-");
        int[][] MatrisToplam=matristopla(matris1,matris2);
        matrisYaz(MatrisToplam);
        
        System.out.println("-Satirdaki en kucukleri yazdirma (Matris 1)-");
        satirdakienkucuk(matris1);
        System.out.println("-Sutundaki en kucukeri yazdirma (Matris 1)-");
        sutundakienkucuk(matris1);
        
        System.out.println("-Satirdaki en kucuk indeksler-");
        int[] satirindeks= satirenkucukindeks(matris1);
        for (int i = 0; i < satirindeks.length; i++) {
            System.out.print(satirindeks[i]+" ");
        }
        System.out.println();
        
        System.out.println("-Sutundaki en kucuk indeksler-");
        int[] sutunindeks=sutunenkucukindeks(matris1);
        for (int i = 0; i < sutunindeks.length; i++) {
            System.out.print(sutunindeks[i]+" ");
        }
        System.out.println();
        
        System.out.println("-Satir ortalamalari-");
        double[] satirortalamasi=satırortalama(matris1);
        for (int i = 0; i < satirortalamasi.length; i++) {
            System.out.print(satirortalamasi[i]+" ");
        }
        System.out.println();
        
        System.out.println("-Sutun ortalamalari-");
        double[] sutunortalamasi= sutunortalama(matris1);
        for (int i = 0; i < sutunortalamasi.length; i++) {
            System.out.print(sutunortalamasi[i]+" ");
        }
        System.out.println();
        
    }
    
}
