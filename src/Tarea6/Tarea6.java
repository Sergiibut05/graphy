package Tarea6;

public class Tarea6 {
    public static void tarea6(){
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
            long numaleatorio = (long)(Math.random()*(nummaximo-numminimo+1)+numminimo);
            long numaleatorio1 = numaleatorio;
            if(color.equals("c")){
                color(numaleatorio, numaleatorio1);
            }else{
                nocolor(numaleatorio, numaleatorio1);
            }
        }catch (NumberFormatException e){
                System.out.println("ERROR: Valor inadecuado");
        }catch (Exception e){
                System.out.println("Ha occurrido un error");
        }
    }
    public static void nocolor(long numaleatorio, long numaleatorio1){
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
    }
    public static void color(long numaleatorio, long numaleatorio1){
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
            if(i==longitud){
                System.out.print("\u2554\u2550\u2550\u2550\u2566");
                for(int j=0;j<=digitomax-2;j++){
                    System.out.print("\u2550\u2550\u2550\u2566");
                }
                System.out.print("\u2550\u2550\u2550\u2557");
            }else{
                System.out.print("\u2560\u2550\u2550\u2550\u256C");
                for(int j=0;j<=digitomax-2;j++){
                    System.out.print("\u2550\u2550\u2550\u256C");
                }
                System.out.print("\u2550\u2550\u2550\u2563");
            }
                
            System.out.println();
            System.out.print("\u2551 "+valor+" \u2551");
            for(int k=1;k<=digitomax;k++){
                if(k<valor+1){
                    System.out.print(" ");
                    numcolores((int)valor);
                    System.out.print(" \u2551");
                }else{
                    System.out.print("   \u2551");
                }
            }
            System.out.println();
            if(i==1){
                System.out.print("\u255A\u2550\u2550\u2550\u2569");
                for(int j=0;j<=digitomax-2;j++){
                    System.out.print("\u2550\u2550\u2550\u2569");
                }
                System.out.print("\u2550\u2550\u2550\u255D");
            }
            }
        System.out.println();        
    }
    public static void numcolores(int valor){
        switch (valor) {
            case 0,1,2,3,4:
                System.out.print("\033[44m \033[0m");
                break;
            case 5,6:
                System.out.print("\033[41m \033[0m");
                break;
            case 7,8:
                System.out.print("\033[42m \033[0m");
                break;
            case 9:
                System.out.print("\033[45m \033[0m");
                break;
            default:
                break;
        }
    }
}

