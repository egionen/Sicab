package controle;
public class CPF {
   private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
   private String cpf;

    public CPF(String cpf) {
        this.cpf=cpf;
    }
   
   
   private int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
   }

   public boolean isValidCPF() {
      if ((cpf==null) || (cpf.length()!=14)) return false;
      Integer digito1 = calcularDigito(cpf.substring(0,3) + cpf.substring(4,7) + cpf.substring(8,11), pesoCPF);
      Integer digito2 = calcularDigito(cpf.substring(0,3) + cpf.substring(4,7) + cpf.substring(8,11) + digito1, pesoCPF);
      return cpf.equals(cpf.substring(0,3) +"."+ cpf.substring(4,7) +"."+ cpf.substring(8,11) +"-"+ digito1.toString() + digito2.toString());
   }


}

