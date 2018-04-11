
package classes;

/**
 *
 * @author julioenglish
 */
public class Calculo {

    private double descINSS = 0;
    private double descIRRF = 0;
    private double salarioLiquido = 0;    
    private double salarioBruto = 0;    
    
    private double calcularDescontoINSS (double valorBruto) {
        double valorResult = 0;
        if (valorBruto < 1693.72) {
            valorResult = valorBruto * 0.08;
        } else if ((valorBruto > 1693.72) && (valorBruto <= 2822.90)) {
            valorResult = valorBruto * 0.09;
        } else if ((valorBruto > 2822.90) && (valorBruto <= 5645.80)) {
            valorResult = (valorBruto * 0.11);	        
        }
        return valorResult;
    }

    private double calcularDescontoIRRF (double valorBruto) {
        double valorResult = 0;
        if (valorBruto < 1903.99) {
            valorResult = 0;
        } else if ((valorBruto >= 1903.99) && (valorBruto <= 2826.65)) {
            valorResult = (valorBruto * 0.075) - 142.80;
        } else if ((valorBruto > 2826.65) && (valorBruto <= 3751.05)) {
            valorResult = (valorBruto * 0.15) - 354.80;
        } else if ((valorBruto > 3751.05) && (valorBruto <= 4664.68)) {
            valorResult = (valorBruto * 0.225) - 636.13;
        } else if ((valorBruto > 4664.68)) {
            valorResult = (valorBruto * 0.275) - 869.36;	
        }
        return valorResult;
    }
    
    public void calculaSalarioLiquido(double salarioBruto) {
        
        String sDescIRRF;
        
        this.descINSS = calcularDescontoINSS(salarioBruto);
        this.descIRRF = calcularDescontoIRRF(salarioBruto);
        this.salarioLiquido = salarioBruto - this.descINSS - this.descIRRF;
        this.salarioBruto = this.salarioBruto * 0.08;
        
        if (this.descIRRF == 0) { 
            sDescIRRF = "Isento"; 
        } else { 
            sDescIRRF = String.valueOf(this.descIRRF); 
        }
        
	System.err.println("Salário Bruto:" + salarioBruto);
	System.err.println("Desconto de INSS:" + this.descINSS);
	System.err.println("Desconto de IRRF:" + sDescIRRF);
	System.err.println("Salário Líquido:" + this.salarioLiquido);
        System.err.println("FGTS arrecadado:" + this.salarioBruto);        
        
    }
    
}