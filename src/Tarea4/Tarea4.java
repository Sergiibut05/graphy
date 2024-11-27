package Tarea4;

public class Tarea4 {
    public static void tarea4(){
        try{
            System.out.println("GRAPHIFY");
            System.out.println("====================");
            System.out.print("Introduce el valor mínimo del rango: ");
            long numminimo = Long.parseLong(System.console().readLine());
            System.out.print("\nIntroduce el valor máximo del rango: ");
            long nummaximo = Long.parseLong(System.console().readLine());
            if(numminimo<0 || nummaximo<0){
                System.out.println("ERROR: Los valores del rango deben ser mayores o iguales que 0.");
                return;
            }
            if(nummaximo<numminimo){
                System.out.println("ERROR: El número máximo no puede ser menor que el mínimo");
                return;
            }
            System.out.print("\nDibuja la gráfica en clanco y cegro o en color (BIC): ");
            String color= System.console().readLine();
            color = color.toLowerCase();
            if(color.equals("c")){
                
            }
            long numaleatorio = (long)(Math.random()*(nummaximo-numminimo+1)+numminimo);
            long numaleatorio1 = numaleatorio;
            int longitud = (int)Math.log10(numaleatorio)+1;
            long digitomax = 0;
            long valor=0;
            
            for(int i=longitud;i>=1;i--){
                valor = (long)(numaleatorio1/(Math.pow(10, i-1)));
                numaleatorio1=numaleatorio1-(long)(valor*Math.pow(10, i-1));
                if(valor>digitomax){
                    digitomax = valor;
                }
                
            }
        
            numaleatorio1 = numaleatorio;
            for(int i=longitud;i>=1;i--){
                valor = (long)(numaleatorio1/(Math.pow(10, i-1)));
                numaleatorio1=numaleatorio1-(long)(valor*Math.pow(10, i-1));
                for(int j=0;j<=digitomax;j++){
                    System.out.print(" ---");
                }
                System.out.println();
                System.out.print("| "+valor+" |");
                for(int k=1;k<=digitomax;k++){
                    if(k<valor+1){
                        System.out.print(" * |");
                    }else{
                        System.out.print("   |");
                    }
                }
                System.out.println();
                if(i==1){
                    for(int j=0;j<=digitomax;j++){
                        System.out.print(" ---");
                    }
                }
            }
            System.out.println();
        }catch (NumberFormatException e){
            System.out.println("ERROR: Valor inadecuado");
        }catch (Exception e){
            System.out.println("Ha occurrido un error");
        }
    }
}
